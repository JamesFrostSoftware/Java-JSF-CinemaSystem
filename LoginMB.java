import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "loginMB")
@RequestScoped

public class LoginMB
{
    UsersMB uMB;
    
    public LoginMB()
    {
        uMB = new UsersMB();
    }
    
    public void registerUser(String username, String password)
    {
        uMB.createUser(username, password);
    }
    
    public void registerAdmin(String username, String password)
    {
        uMB.createAdmin(username, password);
    }
    
    public String logIn(String username, String password)
    {
        if(uMB.logIn(username, password))
        {
            return "landingPage";
        }
        return "login";
    }
    public String logInAdmin(String username, String password)
    {
        if(uMB.logInAdmin(username, password))
        {
            return "landingPageAdmin";
        }
        return "login";
    }
    public void newFilm(String filmName, int screenNo, int ticketsLeft)
    {
        uMB.addNewFilm(filmName, screenNo, ticketsLeft);
    }
    public void editFilm(int id, String filmName, int screenNo)
    {
        uMB.editFilm(id, filmName, screenNo);
    }
    public void deleteFilm(int id)
    {
        uMB.deleteFilm(id);
    }
    public void deleteUser(int id)
    {
        uMB.deleteUser(id);
    }
    public void displayFilm()
    {
        uMB.displayFilm();
    }
    public void bookTickets(int id, int ticketsLeft)
    {
        uMB.bookTickets(id, ticketsLeft);
    }
}
