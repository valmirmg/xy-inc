package persistence;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.sun.jersey.server.impl.container.servlet.JerseyServletContainerInitializer;


public class ConnectionSqLite {
	
	public static Statement conn() throws Exception{
		
		try {
			 Class.forName("org.sqlite.JDBC");
			 Connection connection = null;
			    
			 connection = DriverManager.getConnection("jdbc:sqlite:poi.sqlite");
			 Statement statement = connection.createStatement();
			 statement.setQueryTimeout(30);
			 
			 return statement;

		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unused")
	public Connection getConnection() throws Exception {
		// Conectando na base de dados
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			
			File arquivo = new File(System.getProperty("user.dir") + "/db", "poi.db");
			conn = DriverManager.getConnection(String.format("jdbc:sqlite:%s", arquivo.getAbsolutePath()));
			
			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}
		} catch (Exception e) {
			close(conn);
			throw new RuntimeException("Falha ao tentar conectar no banco local.\n(" + e.getMessage() + ")", e);
		}
		return conn;
	}
	
	private static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}
}
