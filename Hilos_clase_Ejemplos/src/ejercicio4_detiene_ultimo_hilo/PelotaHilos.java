package ejercicio4_detiene_ultimo_hilo;

import java.awt.Component;

public class PelotaHilos implements Runnable {
	private Pelota pelota;
	private Component componente;
	@Override
	public void run() {
		System.out.println("Estado del hilo al comenzar: "+Thread.currentThread().isInterrupted());
		//for(int i=1; i<=3000;i++) {
			while(!Thread.currentThread().isInterrupted()){
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			//interrupmimos el hilo salta InterruptedException
			try {
				Thread.sleep(4);;
			}catch(InterruptedException e) {
				//e.printStackTrace();
				System.out.println("El Hilo a sido interrumpido");
				Thread.currentThread().interrupt();//solo interrumpe el último
			}
		}
		System.out.println("Estado del hilo al terminar: "+Thread.currentThread().isInterrupted());	
	}
	public PelotaHilos(Pelota pelota, Component componente) {
		super();
		this.pelota = pelota;
		this.componente = componente;
	}
	
	
	

}
