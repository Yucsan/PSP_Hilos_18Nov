
public class Opera {
	
	
	private String nombre;
	private float num;
	private boolean enProceso = false;
	
	public Opera(String nombre, float num) {
		this.nombre=nombre;
		this.num=num;
	}
	
	
	public synchronized void ejecuta(String nombre, float num) {
		
		while (enProceso) { // Espera activa hasta que el proceso actual termine
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Error durante la espera: " + e.getMessage());
            }
        }
		
		enProceso = true; // Marca que un cliente está siendo procesado
        System.out.println("Iniciando"+ nombre );
        
		for(int i=0; i<=5; i++) {
			System.out.println(i);
		}
		
		 System.out.println("Finalizando"+ nombre );
		System.out.println(this.nombre+" fin numero: "+this.num);
		enProceso = false; // Libera el proceso para el siguiente cliente
        notifyAll(); 
	}
	
	
	
	
}
