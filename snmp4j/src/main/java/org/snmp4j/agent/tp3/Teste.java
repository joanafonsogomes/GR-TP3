package org.snmp4j.agent.tp3;

import java.time.Duration;
import java.time.LocalDateTime;

public class Teste {

    public static void main(String[] args) {
        Duration duration = Duration.ofMillis(5052696815L);
        System.out.println(duration.toString());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        Duration duration1 = Duration.parse("P4DT12H30M5S");
        System.out.println(duration1.toString());
    }
}
