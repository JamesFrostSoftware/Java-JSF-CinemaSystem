import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.JTextPane;


@Named(value = "usersMB")
@ApplicationScoped

public class UsersMB
{
    public UsersMB()
    {
        
    }
    
    public boolean createUser(String username, String password)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Users(user_name, user_password) VALUES (?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean createAdmin(String username, String password)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Admins(admin_name, admin_password) VALUES (?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean logIn(String username, String password)
    {
        ResultSet resSet = null;
        boolean loginOK = false;
        
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Users WHERE user_name = ? AND user_password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            resSet = ps.executeQuery();
            
            loginOK = resSet.next();
            
            resSet.close();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return loginOK;
    }
    
    public boolean logInAdmin(String username, String password)
    {
        ResultSet resSet = null;
        boolean loginOK = false;
        
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Admins WHERE admin_name = ? AND admin_password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            resSet = ps.executeQuery();
            
            loginOK = resSet.next();
            
            resSet.close();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return loginOK;
    }
    
    public boolean addNewFilm(String filmName, int screenNo, int ticketsLeft)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Movies(film_name, screenNo, ticketsLeft) VALUES (?,?,?)");
            ps.setString(1, filmName);
            ps.setInt(2, screenNo);
            ps.setInt(3, ticketsLeft);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean editFilm(int id, String filmName, int screenNo)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("UPDATE Movies SET film_name = ?, screenNo = ? WHERE film_ID = ?");
            ps.setString(1, filmName);
            ps.setInt(2, screenNo);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteUser(int id)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("DELETE FROM Users WHERE user_ID = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteFilm(int id)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("DELETE FROM Movies WHERE film_ID = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    
        public boolean displayFilm()
    {
        ResultSet rs = null;
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Movies");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                int filmID = rs.getInt("film_ID");
                String filmName = rs.getString("film_Name");
                int ticketsLeft = rs.getInt("ticketsLeft");
                int screenNo = rs.getInt("screenNo");
                System.out.println(filmID + " " + filmName + " " + ticketsLeft + " " + screenNo);
            }
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
        
        public boolean bookTickets(int id, int tickets_Left)
    {
        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/WMAD_DB", "James", "James");
            
            PreparedStatement ps = c.prepareStatement("UPDATE Movies SET ticketsLeft = ticketsLeft - ? WHERE film_ID = ?");
            ps.setInt(1, tickets_Left);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            ps.close();
            c.close();
        }
        
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }     
}
