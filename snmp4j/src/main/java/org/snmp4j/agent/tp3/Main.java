package org.snmp4j.agent.tp3;

public class Main {

    public static void main(String[] args) {
        new Thread(()->
                Agent.main(new String[]{"-c", "Agent.cfg", "-bc", "Agent.bc", "udp:127.0.0.1/3003"}))
        .start();
        new Thread(()->
                MainFX.launch(args))
        .start();
    }
}
