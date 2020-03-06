import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
@Named(value = "users")
@RequestScoped
public class Users
{
    int id;
    String username;
    String password;
    
    public Users()
    {
        
    }

    public void setId(int id)
    {
        this.id = id;
    }

    
    public int getId()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }   
}
