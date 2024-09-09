import java.sql.Connection;

import db.DB;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Connection conn = DB.getConnection();
		DB.closeConnection();
    }
}
