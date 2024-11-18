package correo2;

public class Principal {
    public static void main(String[] args) {
        Correo correo = new Correo();

        HiloC h1 = new HiloC(correo, "Hilo 1");
        HiloC h2 = new HiloC(correo, "Hilo 2");

        h1.start();
        h2.start();
    }
}
