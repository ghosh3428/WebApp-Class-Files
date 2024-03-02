package MyDataLayer;

import Model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeService {

    public Connection con;
    String query;
    ResultSet rs;
    PreparedStatement pst;
    String url;
    String userName;
    String password;

    public EmployeeService() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:tcp://localhost/~/test";
        userName = "sa";
        password = "";

        con = DriverManager.getConnection(url, userName, password);

    }

    public boolean addEmployee(Employee emp) throws SQLException {
        try {
            query = "insert into emp values(?,?,?,?,?,?);";
            pst = con.prepareStatement(query);

            pst.setString(1, emp.getFirstName());
            pst.setString(2, emp.getLastName());
            pst.setInt(3, emp.getAge());
            pst.setString(5, emp.getDesignation());
            pst.setInt(4, emp.getExperience());
            pst.setDouble(6, emp.getBasic());

            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
    public boolean DelEmployee(Employee emp) throws SQLException {
        try {
            query = "delete from emp where first_name = ? and last_name =? ";
            pst = con.prepareStatement(query);

            pst.setString(1, emp.getFirstName());
            pst.setString(2, emp.getLastName());
            

            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
