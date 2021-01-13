import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restfull.Employee;
import restfull.EmployeeContext;
import restfull.MyConnection;

@WebServlet("/testConnection")
public class TestConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestConnectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			Connection co = MyConnection.getInstance();
			writer.println(co);
			/**EmployeeContext con = new EmployeeContext();
			writer.println(con);
			writer.println(con.getConnection());
			ArrayList<Employee> emps = con.select();*/
			writer.println("Ok, boss!");
		}
		catch(Exception ex){
			writer.println(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
