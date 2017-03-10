package com.xiaodemo.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn;
	
	static{
		
		try {
			Properties prop = new Properties();
			InputStream is = ConnectionFactory.class.getClassLoader().
					getResourceAsStream("dbconfig.properties");
			
			prop.load(is);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
		} catch (IOException e) {
			System.out.println("---------配置文件读取错误------------");
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance(){
		
		return	factory ;
	}
	
	public Connection getConnection(){
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
			
}
