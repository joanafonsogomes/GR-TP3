package org.snmp4j.agent.tp3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnventosDAO {

    private File eventFile;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public EnventosDAO(String path) throws IOException {
        eventFile = new File(path);
        if (!eventFile.exists())
            eventFile.createNewFile();

    }

    public static void main(String[] args) throws IOException {
        EnventosDAO enventosDAO = new EnventosDAO("events.txt");
        for (Evento e : enventosDAO.getList()) {
            System.out.println(e.toString());
        }
        Evento evento = new Evento("hello", LocalDateTime.now(), Duration.ofMillis(100000), "Adeus", "ola", "UI");
        enventosDAO.remove(evento.getName());
        for (Evento e : enventosDAO.getList()) {
            System.out.println(e.toString());
        }
    }

    public void add(Evento e) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(eventFile, true));
        dataOutputStream.write((e.toString() + '\n').getBytes(StandardCharsets.UTF_8));
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void remove(String name) throws IOException {

        File tempFile = new File("tmp.txt");
        tempFile.createNewFile();

        BufferedReader reader = new BufferedReader(new FileReader(eventFile));
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(tempFile, true));

        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains(name)) continue;
            writer.write((line + '\n').getBytes(StandardCharsets.UTF_8));
            writer.flush();
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(eventFile);
        System.out.println(successful);
    }

    public List<Evento> getList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(eventFile.getPath()));
        List<Evento> eventos = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            eventos.add(lineToEvent(line));
            line = br.readLine();
        }
        br.close();

        return eventos;
    }

    private Evento lineToEvent(String line) {
        Evento evento = new Evento(
                getValue(line, "nome"),
                LocalDateTime.parse(Objects.requireNonNull(getValue(line, "data"))),
                Duration.parse(Objects.requireNonNull(getValue(line, "duracao"))),
                getValue(line, "frasePresente"),
                getValue(line, "fraseFuturo"),
                getValue(line, "frasePassado"));
        return evento;
    }

    private String getValue(String line, String value) {
        Pattern NAMEpattern = Pattern.compile(value + "=\"[^\"]*\"");
        Matcher NAMEmatcher = NAMEpattern.matcher(line);
        if (NAMEmatcher.find()) {
            String NAMEaux = NAMEmatcher.group();
            Pattern NAME2pattern = Pattern.compile("[^(" + value + "=)\"].*[^\"]");
            Matcher NAME2matcher = NAME2pattern.matcher(NAMEaux);
            if (NAME2matcher.find()) {
                return NAME2matcher.group();
            } else return null;
        } else return null;

    }
}