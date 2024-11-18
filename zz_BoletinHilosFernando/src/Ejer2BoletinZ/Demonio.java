package Ejer2BoletinZ;

public class Demonio extends Thread {

	private int num1;
	private int num2;
	private final static String ANSIRED = "\u001B[31m";
	
	public Demonio(int num1, int num2) {
		if(num1>num2) {			
			this.num1 = num1;
			this.num2 = num2;
		}else {
			this.num1 = num2;
			this.num2 = num1;
		}
	}

	@Override
	public void run() {
		System.out.println(num1+"  -  "+num2);
		
		System.out.println(ANSIRED+"Inicio DEMONIO");
		
		while(this.num1>this.num2) {
			System.out.println(ANSIRED+this.num1++);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(ANSIRED+"fin del demonio:"+this.getName());
	}

}
