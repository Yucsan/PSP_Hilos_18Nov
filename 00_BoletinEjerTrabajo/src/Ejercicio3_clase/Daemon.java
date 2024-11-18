package Ejercicio3_clase;

public class Daemon extends Thread {
	
	private int numero1;
	private int numero2;
	public static final String MAG = "\u001b[35m";
	/*
	public Daemon() {
		setDaemon(true);
		start();
	}*/
	
	public Daemon(int num1, int num2) {
		this.numero1=num1;
		this.numero2=num2;
	}
	
	@Override
	public void run() {
		 while (numero1 <= numero2) {  		    	
		    	if(getName().equals("Demonio"))
					System.out.println(MAG+"Ejecuta+ " +this.getName() +" CuentaDemonio: "+numero2);
		        numero2++;
		        System.out.println("fin del :"+this.getName());
		    }
		 System.out.println(MAG+"fin del demonio:"+this.getName());
		 System.out.println(MAG+"El demonio " + this.getName() + " ha finalizado.");
	}
}