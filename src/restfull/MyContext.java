package restfull;

import java.sql.*;
import java.util.ArrayList;

public class MyContext {
	
	public ArrayList<Employee> select() throws SQLException {
		ArrayList<Employee> result = new ArrayList<Employee>();
		Statement statement = MyConnection.getInstance().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        while(resultSet.next()){
            Employee temp = new Employee();
            temp.setEmployeeId(resultSet.getInt("EmployeeId"));
            temp.setFirstName(resultSet.getString("FirstName"));
            temp.setLastName(resultSet.getString("LastName"));
            temp.setPhoneNumber(resultSet.getString("PhoneNumber"));
            temp.setSalary(resultSet.getInt("Salary"));
            temp.setAddress(resultSet.getString("Address"));
            temp.setExpirience(resultSet.getInt("Expirience"));
            result.add(temp);
        }
		return result;
	}
	
	public Employee select(int employeeId) throws SQLException {
		Employee result = new Employee();
		String sql = "SELECT * FROM employee WHERE EmployeeId=?";
		PreparedStatement statement = MyConnection.getInstance().prepareStatement(sql);
		statement.setInt(1, employeeId);
		ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
        	result.setEmployeeId(resultSet.getInt("EmployeeId"));
        	result.setFirstName(resultSet.getString("FirstName"));
        	result.setLastName(resultSet.getString("LastName"));
        	result.setPhoneNumber(resultSet.getString("PhoneNumber"));
        	result.setSalary(resultSet.getInt("Salary"));
        	result.setAddress(resultSet.getString("Address"));
        	result.setExpirience(resultSet.getInt("Expirience"));
        }
		return result;
	}
	
	public int insert(Employee employee) throws SQLException {
		String sql = "INSERT INTO employee (FirstName, LastName, PhoneNumber, Salary, Address, Expirience) Values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(sql);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getPhoneNumber());
        preparedStatement.setInt(4, employee.getSalary());
        preparedStatement.setString(5, employee.getAddress());
        preparedStatement.setInt(6, employee.getExpirience());
        return  preparedStatement.executeUpdate();
	}
	
	public int update(Employee employee) throws SQLException {
		String sql = "UPDATE employee SET FirstName=?, LastName=?, PhoneNumber=?, Salary=?, Address=?, Expirience=? WHERE EmployeeId=?";
        PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(sql);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getPhoneNumber());
        preparedStatement.setInt(4, employee.getSalary());
        preparedStatement.setString(5, employee.getAddress());
        preparedStatement.setInt(6, employee.getExpirience());
        preparedStatement.setInt(7, employee.getEmployeeId());
        return  preparedStatement.executeUpdate();
	}
	
	public int delete(Employee employee) throws SQLException {
		String sql = "DELETE FROM employee WHERE EmployeeId=?";
        PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(sql);
        preparedStatement.setInt(1, employee.getEmployeeId());
        return  preparedStatement.executeUpdate();
	}
	
}
