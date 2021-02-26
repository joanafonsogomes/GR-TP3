import org.snmp4j.smi.Counter32;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;

import java.time.Duration;
import java.time.LocalDateTime;

public class Evento {
    private String name;
    private LocalDateTime data;
    private Duration duracao;
    private String frasePassado;
    private String frasePresente;
    private String fraseFuturo;
    private Duration timer;


    public Evento(String name, LocalDateTime data, Duration duracao,
                  String frasePassado, String frasePresente, String fraseFuturo) {
        this.name = name;
        this.data = data;
        this.duracao = duracao;
        this.frasePassado = frasePassado;
        this.frasePresente = frasePresente;
        this.fraseFuturo = fraseFuturo;
        timer = null;
    }

    public GrEventosMib.EventoEntryRow getEntry(GrEventosMib.EventoEntryRow row, int index) {
        row.setEventoIndex(new Counter32(index));
        row.setEventoName(new OctetString(this.name));
        row.setEventoDuracao(new TimeTicks(this.duracao.toMillis()));
        row.setEventoFrasePassado(new OctetString(this.frasePassado));
        row.setEventoFrasePresente(new OctetString(this.frasePresente));
        row.setEventoFraseFuturo(new OctetString(this.fraseFuturo));

        if (this.data.isAfter(LocalDateTime.now())) {
            row.setEventoEstado(new Integer32(2)); //futuro
            Duration duration = Duration.between(this.data, LocalDateTime.now());
            setEventoTime(row, duration);
        } else if (this.data.plus(duracao).isBefore(LocalDateTime.now())) {
            row.setEventoEstado(new Integer32(0)); //passado
            Duration duration = Duration.between(this.data, LocalDateTime.now());
            setEventoTime(row, duration);
        } else {
            row.setEventoEstado(new Integer32(1)); //presente
            setEventoTime(row, 0, 0, 0, 0, 0, 0);
        }

        return row;
    }

    private void setEventoTime(GrEventosMib.EventoEntryRow row, Duration duration) {
        long durationMillis = duration.toMillis();

        long years = durationMillis / 31556952000L;
        durationMillis -= (years * 31556952000L);
        long months = durationMillis / 2592000000L;
        durationMillis -= (months * 2592000000L);
        long weeks = durationMillis / 604800000L;
        durationMillis -= (weeks * 604800000L);
        long days = durationMillis / 86400000L;
        durationMillis -= (days * 86400000L);
        long hours = durationMillis / 3600000L;
        durationMillis -= (hours * 3600000L);
        long minutes = durationMillis / 60000L;

        setEventoTime(row, years, months, weeks, days, hours, minutes);
    }

    private void setEventoTime(GrEventosMib.EventoEntryRow row,
                               long years, long months, long weeks, long days, long hours, long minutes) {
        row.setEventoTempoAnos(new Integer32(Long.valueOf(years).intValue()));
        row.setEventoTempoMeses(new Integer32(Long.valueOf(months).intValue()));
        row.setEventoTempoSemanas(new Integer32(Long.valueOf(weeks).intValue()));
        row.setEventoTempoDias(new Integer32(Long.valueOf(days).intValue()));
        row.setEventoTempoHoras(new Integer32(Long.valueOf(hours).intValue()));
        row.setEventoTempoMinutos(new Integer32(Long.valueOf(minutes).intValue()));
    }

    public String getName() {
        return name;
    }

    public boolean itsTime() {
        if (timer == null) {
            return false;
        } else if (this.data.plus(duracao).plus(timer).isBefore(LocalDateTime.now())) {
            return true;
        } else return false;

    }

    public void setTimer(Duration timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        String s = "{nome=\"" + name + '\"' +
                ", data=\"" + data.toString() + '\"' +
                ", duracao=\"" + duracao.toString() + '\"' +
                ", frasePassado=\"" + frasePassado + '\"' +
                ", frasePresente=\"" + frasePresente + '\"' +
                ", fraseFuturo=\"" + fraseFuturo + '\"';
        if (timer == null){
            s += '}';
        } else s += ", timer=\""+timer.toString()+ "\"}";

        return s;
    }
}
