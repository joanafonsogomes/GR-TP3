package org.snmp4j.agent.tp3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
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

    public void add(Evento e) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(eventFile, true));
        dataOutputStream.write((e.toString() + '\n').getBytes(StandardCharsets.UTF_8));
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    public List<Evento> getList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(eventFile.getPath()));
        List<Evento> eventos = new ArrayList<>();
        int index = 1;
        String line = br.readLine();
        while (line != null) {
            eventos.add(lineToEvent(line,index));
            line = br.readLine();
            index++;
        }
        br.close();

        return eventos;
    }

    private Evento lineToEvent(String line,int index){
        Evento evento = new Evento();
        System.out.println(getValue(line,"nome")+" "+getValue(line,"data")+" "+getValue(line,"duracao"));
        return null;
    }

    private String getValue(String line,String value){
        Pattern NAMEpattern = Pattern.compile(value+"=\"[^\"]*\"");
        Matcher NAMEmatcher = NAMEpattern.matcher(line);
        if (NAMEmatcher.find()) {
            String NAMEaux = NAMEmatcher.group();
            Pattern NAME2pattern = Pattern.compile("[^("+value+"=)\"].*[^\"]");
            Matcher NAME2matcher = NAME2pattern.matcher(NAMEaux);
            if (NAME2matcher.find()) {
                return NAME2matcher.group();
            } else return null;
        } else return null;

    }

    public static void main(String[] args) throws IOException {
        EnventosDAO enventosDAO = new EnventosDAO("events.txt");
        enventosDAO.getList();
    }
}