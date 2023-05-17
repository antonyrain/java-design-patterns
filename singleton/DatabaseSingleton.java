/*
This example shows the implementation of the Singleton Design Pattern in Java.
Singleton can be used to create a single instance that represents a connection
to the database to all the clients.
*/

public class DatabaseSingleton {
    private static DatabaseSingleton dbObject;
    
    private DatabaseSingleton() {
    }

    public static DatabaseSingleton getInstance() {
        if(dbObject == null) {
            dbObject = new DatabaseSingleton();        
        }
        return dbObject;
    }
    public void getConnection() {
        System.out.println("Connection established!");
    }
}

class Main {
    public static void main(String[] args) {
        DatabaseSingleton db;
        db = DatabaseSingleton.getInstance();
        db.getConnection();
    }
}
