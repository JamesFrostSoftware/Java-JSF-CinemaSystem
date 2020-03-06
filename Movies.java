import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "movies")
@RequestScoped
public class Movies
{
    int id;
    String filmName;
    int screenNo;
    int ticketsLeft;

    public int getTicketsLeft()
    {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft)
    {
        this.ticketsLeft = ticketsLeft;
    }
    
    public Movies()
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

    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public int getScreenNo()
    {
        return screenNo;
    }

    public void setScreenNo(int screenNo)
    {
        this.screenNo = screenNo;
    }
    
    
    
}
