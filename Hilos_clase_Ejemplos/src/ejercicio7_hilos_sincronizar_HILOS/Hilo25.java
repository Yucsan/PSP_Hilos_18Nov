package ejercicio7_hilos_sincronizar_HILOS;

public class Hilo25 extends Thread  {
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	public void run() {
		for(int i=0; i<=25; i++) {
			if(getName().equals("HILO0"))
				System.out.println(BLUE+"Ejecuta+ " +this.getName() +"nº "+i+1);
			else
				System.out.println(RED+"Ejecuta+ " +this.getName() +"nº "+i+1);
		}
	}
}
