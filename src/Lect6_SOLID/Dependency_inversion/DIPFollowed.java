package Lect6_SOLID.Dependency_inversion;


/**
 Dependency Inversion Principle (DIP) states that high-level modules should not
 depend on low-level modules. Both should depend on abstractions (interfaces).
 In this example, UserService1 depends on the Database interface instead of MySQLDatabase1 or MongoDBDatabase1.
 Using constructor dependency injection, any database implementation can be supplied at runtime without modifying
 the business logic, making the code flexible, loosely coupled, and easier to maintain
 **/

// Abstraction (Interface)
interface Database {
    void save(String data);
}

// MySQL implementation (Low-level module)
class MySQLDatabase1 implements Database {
    @Override
    public void save(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + data + "');"
        );
    }
}

// MongoDB implementation (Low-level module)
class MongoDBDatabase1 implements Database {
    @Override
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})"
        );
    }
}

// High-level module (Now loosely coupled via Dependency Injection)
class UserService1 {
    private final Database db;

    public UserService1(Database database) {
        this.db = database;
    }

    public void storeUser(String user) {
        db.save(user);
    }
}

public class DIPFollowed {
    public static void main(String[] args) {
        MySQLDatabase1 mysql = new MySQLDatabase1();
        MongoDBDatabase1 mongodb = new MongoDBDatabase1();

        UserService1 service1 = new UserService1(mysql);
        service1.storeUser("Aditya");

        UserService1 service2 = new UserService1(mongodb);
        service2.storeUser("Rohit");
    }
}

