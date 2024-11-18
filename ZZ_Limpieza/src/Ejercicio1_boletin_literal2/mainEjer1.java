package Ejercicio1_boletin_literal2;

import java.util.ArrayList;
import java.util.List;

public class mainEjer1 {

	public static void main(String[] args) {
		
		String[] nombres= {"tarea1","tarea2","tarea3"};
		
		List<Integer> prioridades = new ArrayList<Integer>();
		
		while(prioridades.size()!=3) {		
			
			int aux = (int)(Math.random()*11);
			if(!prioridades.contains(aux)){
				prioridades.add(aux);
				System.out.println(aux);
			}
			
		}
		prioridades.sort((o1, o2) -> o1.compareTo(o2)); //ordena
		
		for(Integer p: prioridades) { //revizo el nuevo orden
			System.out.println(p);
		}
		
		//creamos e instanciamos los 3 hilos y sincronizamos con join
		for(int i=0; i<nombres.length; i++) {
			
			HiloEjer1 hilo=new HiloEjer1(nombres[i],prioridades.get(i));
			hilo.setName(nombres[i]);
			hilo.start();
			
			
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
		
		
		

	}

}
