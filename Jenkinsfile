pipeline {
    agent any
    
    tools {
        maven 'M2'  // Must match name in Jenkins Global Tool Configuration
        jdk 'JAVA17'       // Must match name in Jenkins Global Tool Configuration
    }
    
    
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build API Gateway') {
            steps {
                script {
                    try {
                        dir('api-gateway') {
                            sh 'mvn -B package'
                        }
                    } catch (Exception e) {
                        echo "API Gateway build failed: ${e.message}"
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        
        stage('Build Inventory Service') {
            steps {
                script {
                    try {
                        dir('inventory-service') {
                            sh 'mvn -B package'
                        }
                    } catch (Exception e) {
                        echo "Inventory Service build failed: ${e.message}"
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        
        stage('Collect Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true, fingerprint: true
            }
        }
    }
    
    post {
        always {
            cleanWs()  // Clean workspace after build
        }
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
        unstable {
            echo 'Build is unstable (some modules failed)'
        }
    }
}
