package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;

    public static Connection getConnection() throws Exception {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		}
		return conn;
	}

    public static void closeConnection() throws Exception {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		}
	}

    private static Properties loadProperties() throws Exception {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new Exception(e.getMessage());
		}
	}
}
