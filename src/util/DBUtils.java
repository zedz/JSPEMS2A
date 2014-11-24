package util;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;
	
	private static int initialSize;
	private static int maxTotal;
	private static int maxWait;
	
	private static BasicDataSource ds=null;
	
	static{
		try {
			Properties prop = new Properties();
			prop.load(DBUtils.class.
					getClassLoader().
					getResourceAsStream("db.properties"));
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			pwd=prop.getProperty("pwd");
			
			initialSize=Integer.parseInt(prop.getProperty("initialSize"));
			maxTotal=Integer.parseInt(prop.getProperty("maxTotal"));
			maxWait=Integer.parseInt(prop.getProperty("maxWait"));
			
			ds=new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(initialSize);
			ds.setMaxActive(maxTotal);
			ds.setMaxWait(maxWait);
			
		} catch (Exception e) {
		}
		
	}
	
	public static Connection getConnection(){
		if (ds!=null){
			try {
				return ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				//连接池中获得的conn对象的close方法被重写为归还
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
