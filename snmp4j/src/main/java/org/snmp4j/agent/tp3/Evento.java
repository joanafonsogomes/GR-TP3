package org.snmp4j.agent.tp3;

import org.snmp4j.smi.Counter32;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;

import java.time.Duration;
import java.time.LocalDateTime;

public class Evento {
    String name;
    LocalDateTime data;
    Duration duracao;
    String frasePassado;
    String frasePresente;
    String fraseFuturo;

    public Evento(String name, LocalDateTime data, Duration duracao,
                  String frasePassado, String frasePresente, String fraseFuturo) {
        this.name = name;
        this.data = data;
        this.duracao = duracao;
        this.frasePassado = frasePassado;
        this.frasePresente = frasePresente;
        this.fraseFuturo = fraseFuturo;
    }

    public GrEventosMib.EventoEntryRow getEntry(GrEventosMib.EventoEntryRow row, long counter) {
        row.setEventoIndex(new Counter32(counter));
        row.setEventoName(new OctetString(this.name));
        row.setEventoDuracao(new TimeTicks(this.duracao.toMillis()));
        row.setEventoFrasePassado(new OctetString(this.frasePassado));
        row.setEventoFrasePresente(new OctetString(this.frasePresente));
        row.setEventoFraseFuturo(new OctetString(this.fraseFuturo));

        if (this.data.isAfter(LocalDateTime.now())) {
            row.setEventoEstado(new Integer32(2));
        } else if (this.data.plus(duracao).isBefore(LocalDateTime.now())) {
            row.setEventoEstado(new Integer32(0));
        } else {
            row.setEventoEstado(new Integer32(1));
        }

        //ter em atenção a ordem se é depois ou antes
        //
        //row.setEventoTempo(new TimeTicks(Duration.between(LocalDateTime.now(),this.data).)));
        row.setEventoTempo(new TimeTicks(0));
        return row;
    }
}
