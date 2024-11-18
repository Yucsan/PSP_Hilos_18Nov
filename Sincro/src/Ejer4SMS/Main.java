package Ejer4SMS;

public class Main {

    public static void main(String[] args) {

        sms mensaje = new sms();

        HiloR t1 = new HiloR(mensaje);
        t1.setName("HILO 1");

        HiloR t2 = new HiloR(mensaje);
        t2.setName("HILO 2");

        t1.start();
        t2.start();
    }
}
