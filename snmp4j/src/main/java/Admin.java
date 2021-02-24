import java.io.IOException;
import java.util.List;

public class Admin {

    private static Admin instance = null;
    private EventosDAO eventos;
    private long updateTime;

    public static Admin getInstance(){
        if (Admin.instance == null) {
            Admin.instance = new Admin();
        }
        return Admin.instance;
    }

    public Admin(){
        try {
            this.eventos = new EventosDAO("events.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.updateTime = 10000;
    }


    public List<Evento> getEventos() {
        try {
            return eventos.getList();
        } catch (Exception ignored){}
        return null;
    }

    public EventosDAO getEventosDAO() {
        return eventos;
    }

    public long getUpdateTime() {
        return updateTime;
    }



    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
