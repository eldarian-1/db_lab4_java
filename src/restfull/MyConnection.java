package restfull;

import java.sql.*;

public class MyConnection{
	
	private final String c_Host = "localhost";
	private final String c_Port = "3306";
    private final String c_User = "root";
    private final String c_Password = "19841986";
    private final String c_Database = "testdb";
	
    private static Connection s_Instance = null;
    
    private MyConnection() throws Exception
    {
    	String url = "jdbc:mysql://" + c_Host + ":" + c_Port + "/" + c_Database
    			+ "?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
    	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    	s_Instance = DriverManager.getConnection(url, c_User, c_Password);
    }
    
    public static Connection getInstance() throws Exception
    {
    	if(s_Instance == null)
    		new MyConnection();
    	return s_Instance;
    }
}
