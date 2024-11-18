package envio;

public class Main {

	public static void main(String[] args) {
		
		
		Envio envio= new Envio();
		HiloEnvio h1=new HiloEnvio(envio);
		h1.setName("HILO 1");
		HiloEnvio h2=new HiloEnvio(envio);
		h2.setName("HILO 2");
		
		h1.start();
		h2.start();
		
		

	}

}
