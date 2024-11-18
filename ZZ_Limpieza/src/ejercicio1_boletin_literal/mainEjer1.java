package ejercicio1_boletin_literal;

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
		
		
		HiloEjer1 hilo1=new HiloEjer1(nombres[0],prioridades.get(0));
		hilo1.setName(nombres[0]);
		hilo1.start();
		
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloEjer1 hilo2=new HiloEjer1(nombres[1],prioridades.get(1));
		hilo2.setName(nombres[1]);
		hilo2.start();
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloEjer1 hilo3=new HiloEjer1(nombres[2],prioridades.get(2));
		hilo3.setName(nombres[2]);
		hilo3.start();
		
		
		

	}

}
