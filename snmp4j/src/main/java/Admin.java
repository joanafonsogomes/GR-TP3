import java.io.IOException;
import java.util.List;

/**
 * Classe que armazena a instância para buscar os eventos bem como o tempo de atualização da MIB.
 *
 * @author Filipe Miguel Teixeira Freitas Guimarães - A865308
 * @author Joana Isabel Afonso Gomes - A84912
 */
public class Admin {
    /**
     * Instância única da classe.
     */
    private static Admin instance = null;
    /**
     * Classe para obter a lista de eventos.
     */
    private EventosDAO eventos;
    /**
     * Tempo para atualizar a MIB.
     */
    private long updateTime;


    /**
     * Caso já exista uma instância criada desta classe retorna a mesma,
     * caso contrário cria uma.
     *
     * @return Instância única da classe.
     */
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
