db.createUser({
    user: "root",
    pwd: "password",
    roles: [
        {
            role: "root",
            db: "admin"
        }
    ]
});

db.createUser({
    user: "appUser",
    pwd: "appPassword",
    roles: [
        {
            role: "readWrite",
            db: "product-service"
        }
    ]
});
