package org.snmp4j.agent.tp3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    private static Admin instance = null;
    private List<Evento> eventos;
    private long updateTime;

    public static Admin getInstance(){
        if (Admin.instance == null) {
            Admin.instance = new Admin();
        }
        return Admin.instance;
    }

    public Admin(){
        this.eventos = new ArrayList<>();
        this.updateTime = 60000;

        Evento e = new Evento("WebSummit",
                LocalDateTime.of(2021, 2, 10, 1, 1),
                Duration.ofMillis(604800000),
                "O evento já acabou jessica!",
                "OMG this is real?",
                "NUNNNNCAAAA MAAAAAIS :(");
        eventos.add(e);
    }


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
