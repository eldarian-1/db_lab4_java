package restfull;

import java.sql.*;

public class MyConnection{
	
	private final String c_Host = "localhost";
	private final String c_Port = "3306";
    private final String c_User = "root";
    private final String c_Password = "19841986";
    private final String c_Database = "usersdb7";
	
    private static Connection s_Instance = null;
    
    private MyConnection()
    {
    	String url = "jdbc:mysql://" + c_Host + ":" + c_Port + "/" + c_Database + "?serverTimezone=Europe/Moscow&allowPublicKeyRetrieval=true&useSSL=false";
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		s_Instance = DriverManager.getConnection(url, c_User, c_Password);
    	} catch(Exception ex) {}
    }
    
    public static Connection getInstance()
    {
    	if(s_Instance == null)
    		new MyConnection();
    	return s_Instance;
    }
}
