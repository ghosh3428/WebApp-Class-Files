package MyServlet;

import Model.Employee;
import MyDataLayer.EmployeeService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/addemp")
public class AddEmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Employee emp = new Employee();
        emp.setFirstName(req.getParameter("e_fn"));
        emp.setLastName(req.getParameter("e_ln"));
        emp.setAge(Integer.parseInt(req.getParameter("e_age")));
        emp.setBasic(Double.parseDouble(req.getParameter("e_sal")));
        emp.setDesignation(req.getParameter("e_desig"));
        emp.setExperience(Integer.parseInt(req.getParameter("e_exp")));

        try {
            EmployeeService service = new EmployeeService();

            boolean result = service.addEmployee(emp);

            res.setContentType("text/html");
            
            PrintWriter out = res.getWriter();
            
            if(result == true)
            {
                out.print("<h1 style='color:green'>Data Added Successfully</h1>");
            }
            else
            {
                out.print("<h1 style='color:red'>Error Adding Data</h1>");
            }
            
            out.print("<a href='index.html'> Go Back to Home </a>");
            
            
            service.con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }
}
