
public class Main {

	public static void main(String[] args) {
		
		 Opera op = new Opera("Instancia Opera", 4f); // Instancia compartida de Opera
		
		for(int i=0; i<4; i++) {
			HilosZZ h= new HilosZZ("HILLO: "+i, i); 
			h.setOpera(op);
			h.start();
		}
		

	}

}
