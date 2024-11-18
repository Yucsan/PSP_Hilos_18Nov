package Ejercicio4_pingpong;

import java.util.ArrayList;
import java.util.List;

public class Hilos {
    public void iniciar() {
        // Se crean hilos `ping` y `pong` por cada par, para sincronizar uno a uno.
        for (int i = 0; i < 5; i++) {
            Object lock = new Object(); // Bloqueo específico para cada par de ping y pong
            
            // Crea y ejecuta el hilo `ping`
            Thread thPing = new Thread(new Ping("ping", i, lock, true));
            thPing.start();
            
            // Crea y ejecuta el hilo `pong`
            Thread thPong = new Thread(new Ping("pong", i, lock, false));
            thPong.start();
        }
    }

    public static void main(String[] args) {
        Hilos h = new Hilos();
        h.iniciar();
    }
}