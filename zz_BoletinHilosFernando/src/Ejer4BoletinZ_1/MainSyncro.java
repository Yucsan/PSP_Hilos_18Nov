package Ejer4BoletinZ_1;

public class MainSyncro {

	public static void main(String[] args) {
		
		Mensaje mensaje=new Mensaje();
		
		String[] nombres = {"hilo1","hilo2"};
		int inx=0;
		for(int i=0; i<10;i++) {	
			if(i%2==0)
				inx=0;
			else
				inx=1;
			
			HilosEj4 h=new HilosEj4(mensaje);
			Thread hilo=new Thread(h);
			hilo.setName(nombres[inx]);
			hilo.start();
			
		}

	}

}
