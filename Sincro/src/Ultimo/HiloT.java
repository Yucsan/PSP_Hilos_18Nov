package Ultimo;

public class HiloT extends Thread {
	
	private Telegrama tele;
	

	public HiloT(Telegrama tele) {
		super();
		this.tele = tele;
	}

	@Override
	public void run() {
		
		for(int i=0; i<5; i++) {
			
			synchronized(tele) {
				
				while( (this.getName().equals("HILO 1") && !tele.isEstado() )  
					|| ( this.getName().equals("HILO 2") && tele.isEstado() )) {
					
					try {
						tele.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(this.getName().equals("HILO 1")) {
					System.out.println("ENVIO"+ this.getName());
					tele.setEstado(false);
				}else {
					System.out.println("RECIBO"+ this.getName());
					tele.setEstado(true);
				}
				
				tele.notifyAll();
				
			
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		}
		
		
	}
	
	
}
