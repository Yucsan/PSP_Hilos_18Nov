package Ejer2BoletinZ;

public class HiloEj2 implements Runnable {

	private int num1;
	private int num2;
	private final static String CYAN = "\u001b[36m";
	
	public HiloEj2(int num1, int num2) {
		if(num1<num2) {
			this.num1=num1;
			this.num2=num2;
		}else {
			this.num1=num2;
			this.num2=num1;
		}
		
		
	}
	
	
	@Override
	public void run() {
		System.out.println("menor: "+this.num1);
		String nombreHilo = Thread.currentThread().getName();
		
		while(this.num2>=this.num1) {
			System.out.println(CYAN + nombreHilo+ this.num1);
			this.num1++;
		}
		
		/*
		for(int i=this.num1; i<=this.num2; i++) {
			System.out.println(CYAN+i);
		}*/
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("fin de: "+nombreHilo);
	}

}
