package ejercicio7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lectura extends Thread {
    private String nomFile;
    private String palabra;
    private int cuenta = 0;

    public Lectura(String palabra, String nomFile) {
        this.palabra = palabra;
        this.nomFile = nomFile;
    }

    @Override
    public void run() {
        try (FileReader fr = new FileReader("./archivos7/" + nomFile + ".txt");
             BufferedReader br = new BufferedReader(fr)) {

            String linea="";
            while (br.ready()) {
            	linea = br.readLine();
                if (linea.contains(palabra)) { // Verificar si la línea contiene la palabra
                    cuenta++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public int getCuenta() {
        return this.cuenta;
    }

    public String getPalabra() {
        return palabra;
    }
}
