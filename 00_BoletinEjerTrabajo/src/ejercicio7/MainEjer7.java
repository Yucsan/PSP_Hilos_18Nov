package ejercicio7;

public class MainEjer7 {
	public void ejecuta(String[] archivos, String palabra) {
        int cont = 0;  // Mueve el contador aquí para reiniciarlo en cada ejecución
        for (String archivo : archivos) {
            Lectura hilo = new Lectura(palabra, archivo);
            hilo.start();

            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }

            // Suma el conteo de cada hilo al total
            cont += hilo.getCuenta();
        }
        System.out.println("Palabra: " + palabra + " número total en todos los archivos: " + cont);
    }

    public static void main(String[] args) {
        String[] archivitos = { "archivo1", "archivo2", "archivo3", "archivo4" };

        // Crear instancia de MainEjer7 y ejecutar con palabra a buscar "web"
        MainEjer7 m7 = new MainEjer7();
        m7.ejecuta(archivitos, "web");
        m7.ejecuta(archivitos, "Fernando");
    }

}
