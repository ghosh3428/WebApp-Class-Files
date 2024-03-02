
package MyServlet;

import Model.Employee;
import MyDataLayer.EmployeeService;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/del")
public class Delemployeeservlet extends HttpServlet
{
    public void doPost(HttpServletRequest sr, HttpServletResponse r)
    {
        Employee emp = new Employee();
        
        emp.setFirstName(sr.getParameter("e_fn"));
        emp.setLastName(sr.getParameter("e_ln"));
        try
        {
            EmployeeService service = new EmployeeService();

            boolean result = service.DelEmployee(emp);

            r.setContentType("text/html");
            
            PrintWriter out = r.getWriter();
            
            if(result == true)
            {
                out.print("<h1 style='color:green'>Data deleted Successfully</h1>");
            }
            else
            {
                out.print("<h1 style='color:red'>Error deleting Data</h1>");
            }
            
            out.print("<a href='index.html'> Go Back to Home </a>");
            
            
            service.con.close();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
