pipeline {
    agent any

    tools {
        maven 'M2'
        jdk 'JAVA24'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build API Gateway') {
            steps {
                dir('api-gateway') {
                    bat 'mvn.cmd clean package'
                }
            }
        }

        stage('SonarQube API Gateway') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    dir('api-gateway') {
                        bat '''
                        mvn.cmd sonar:sonar ^
                        -Dsonar.projectKey=api-gateway ^
                        -Dsonar.projectName=API-Gateway ^
                        -Dsonar.java.binaries=target
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'API Gateway build & SonarQube analysis completed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
