package Ejercicio1_boletin_literal2;

public class HiloEjer1 extends Thread  {
	
	private int prioridad;
	private String id;
	
	public HiloEjer1(String info, int prioridad) {
		this.id = info;
		this.prioridad=prioridad;
		
	}
	
	public void run() {
		
		System.out.println("Dentro del Hilo:"+this.getName()+" Prioridad: "+this.prioridad+" ID: "+this.id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
