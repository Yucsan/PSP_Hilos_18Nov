package Ejercicio6_clase;

import java.util.ArrayList;
import java.util.List;

public class MainEjer6 {

	public static void main(String[] args) {
		//final String MAG = "\u001b[35m";
		List<Integer> numeros = new ArrayList<Integer>();
		
		for (int i = 0; i <= 1000000; i++) {
			numeros.add(i);
		}
		  // Medir tiempo inicial en milisegundos
        long TiempoComienzo = System.currentTimeMillis();
        int max=numeros.get(0);
        int min=numeros.get(0);
        int inx;
        for(int i=0; i < numeros.size(); i++) {
        	if (numeros.get(i) > max)
        		max=numeros.get(i);
        	if (numeros.get(i) < min)
        		min=numeros.get(i);

        }
        System.out.println("max: "+max);
        System.out.println("min: "+min);
        long TiempoFinal = System.currentTimeMillis();
        long demora = TiempoFinal-TiempoComienzo;
        System.out.println("Demora sin Hilos: "+demora+ " milisegundos");
        
        HiloEjer6 hilo=new HiloEjer6();
        hilo.start();
        
        /*
		int aux = 0;
		for (int i = 0; i < numeros.size() - 1; i++) {
			for (int j = i + 1; j < numeros.size(); j++) {
				if (numeros.get(i) > numeros.get(j)) {
					aux = numeros.get(i);
					numeros.set(i, numeros.get(j));  // Corregido: usar set() para actualizar
		            numeros.set(j, aux);             
				}
			}
		}*/
		

	}

}
