
package Service;

import Model.Bus;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BusService 
{
    Connection con;
    Statement st;
    ResultSet rs;
    String query;
    Bus b;
    PreparedStatement pst;
    final String url ="jdbc:mysql://localhost:3306/project?useSSL=false" ;
    final String user = "root";
    final String password ="yourpassword";
    
    public Bus getBusDetail(int id) throws SQLException
    {
        con = DriverManager.getConnection(url, user, password);
        
        query = "select * from businfo where id = ?;";
        
        pst = con.prepareStatement(query);
        
        pst.setInt(1, id);
        
        rs = pst.executeQuery();
        
        b= null;
        
        if(rs.next())
        {
            b = new Bus();
            b.setId(rs.getInt(1));
            b.setBusNumber(rs.getString(2));
            b.setBusType(rs.getString(6));
            b.setDestination(rs.getString(5));
            b.setDriverContact(rs.getString(8));
            b.setDriverName(rs.getString(7));
            b.setSource(rs.getString(4));
            b.setTravellername(rs.getString(3));
        }
        
        con.close();
        
        return b;        
    }
    
    
}
