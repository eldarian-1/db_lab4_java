<%@ page
	language="java"
	contentType="text/html; charset=utf-16"
	pageEncoding="utf-16"
	import="restfull.EmployeeContext"
	import="restfull.Employee"
	import="java.util.ArrayList"
%><%!

String link(int id){
	return "<td><a href='?action=edit&id=<?=$id?>'>" + id + "</a></td>";
}

String emp(Employee emp){
	return "<tr>" + link(emp.getEmployeeId())
		+ "<td>" + emp.getFirstName() + "</td>"
		+ "<td>" + emp.getLastName() + "</td>"
		+ "<td>" + emp.getPhoneNumber() + "</td>"
		+ "<td>" + emp.getSalary() + "</td>"
		+ "<td>" + emp.getAddress() + "</td>"
		+ "<td>" + emp.getExpirience() + "</td></tr>";
}

String emps(ArrayList<Employee> emps){
	String result = "";
	for(Employee emp : emps)
		result += emp(emp);
	return result;
}

%><%

try{
	out.println(emps(new EmployeeContext().select()));
}
catch(Exception ex){
	out.println(ex);
}

%>