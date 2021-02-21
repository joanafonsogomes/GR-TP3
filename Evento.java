package org.snmp4j.agent.tp3;

import org.snmp4j.smi.Counter32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Evento {
    String name;
    Integer estado;
    LocalDateTime tempo;
    LocalDateTime duracao;
    String frasePassado;
    String frasePresente;
    String fraseFuturo;

    public Evento(String name, Integer estado, LocalDateTime tempo, LocalDateTime duracao,
                  String frasePassado, String frasePresente, String fraseFuturo) {
        this.name = name;
        this.estado = estado;
        this.tempo = tempo;
        this.duracao = duracao;
        this.frasePassado = frasePassado;
        this.frasePresente = frasePresente;
        this.fraseFuturo = fraseFuturo;
    }

    public GrEventosMib.EventoEntryRow getEntry(GrEventosMib.EventoEntryRow row, long counter){
        row.setEventoIndex(new Counter32(counter));
        row.setEventoName(new OctetString(this.name));
        row.setEventoDuracao(new TimeTicks(this.duracao.atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli()));
        row.setEventoFrasePassado(new OctetString(this.frasePassado));
        row.setEventoFrasePresente(new OctetString(this.frasePresente));
        row.setEventoFraseFuturo(new OctetString(this.fraseFuturo));


        return null;
    }
}
