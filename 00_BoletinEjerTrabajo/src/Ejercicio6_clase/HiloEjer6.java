package Ejercicio6_clase;

import java.util.ArrayList;
import java.util.List;

public class HiloEjer6 extends Thread {
	public static final String CYAN = "\u001b[36m";
	
	public void run() {
		List<Integer> numeros = new ArrayList<Integer>();
		
		for (int i = 0; i <= 1000000; i++) {
			numeros.add(i);
		}
		  // Medir tiempo inicial en milisegundos
        long TiempoComienzo1 = System.currentTimeMillis();
        int max=numeros.get(0);
        int min=numeros.get(0);
        int inx;
        for(int i=0; i < numeros.size(); i++) {
        	if (numeros.get(i) > max)
        		max=numeros.get(i);
        	if (numeros.get(i) < min)
        		min=numeros.get(i);

        }
        System.out.println(CYAN+"max ArrayHilo: "+max);
        System.out.println(CYAN+"min ArrayHilo: "+min);
        long TiempoFinal1 = System.currentTimeMillis();
        long demora1 = TiempoFinal1-TiempoComienzo1;
        System.out.println(CYAN+" Demora con Hilos: "+demora1+ " milisegundos");
        System.out.println(CYAN+this.getName()+" fin del Hilo");
	}
}
