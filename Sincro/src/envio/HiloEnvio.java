package envio;

public class HiloEnvio extends Thread {

	private Envio envio;

	public HiloEnvio(Envio envio) {
		this.envio = envio;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			
			synchronized (envio) {
				
				/*  HILO 1 espera si llegado es false.
					HILO 2 espera si llegado es true. */
				
				while ( (this.getName().equals("HILO 1") && !envio.isLlegado())
                        || (this.getName().equals("HILO 2") && envio.isLlegado())) {
					try {
						envio.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


				if(this.getName().equals("HILO 1")) {
					System.out.println("Envio" + this.getName());
					envio.setLlegado(false);
                }else {
                	System.out.println("Recibo" + this.getName());
					envio.setLlegado(true);
                }
 
                // Notificar a los demás hilos
                envio.notifyAll();
				
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

		}

	}

}
