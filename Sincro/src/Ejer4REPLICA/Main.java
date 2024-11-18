package Ejer4REPLICA;

public class Main {

    public static void main(String[] args) {

        MensajeReplica mensaje = new MensajeReplica();

        HiloR t1 = new HiloR(mensaje);
        t1.setName("HILO 1");

        HiloR t2 = new HiloR(mensaje);
        t2.setName("HILO 2");

        t1.start();
        t2.start();
    }
}
