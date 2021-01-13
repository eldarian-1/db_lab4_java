package restfull;

import java.io.Serializable;

public class Employee implements Serializable  {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int salary;
	private String address;
	private int expirience;
	
	public Employee() {}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getExpirience() {
		return expirience;
	}
	
	public void setEmployeeId(int arg) {
		employeeId = arg;
	}
	
	public void setFirstName(String arg) {
		firstName = arg;
	}
	
	public void setLastName(String arg) {
		lastName = arg;
	}
	
	public void setPhoneNumber(String arg) {
		phoneNumber = arg;
	}
	
	public void setSalary(int arg) {
		salary = arg;
	}
	
	public void setAddress(String arg) {
		address = arg;
	}
	
	public void setExpirience(int arg) {
		expirience = arg;
	}
	
}
