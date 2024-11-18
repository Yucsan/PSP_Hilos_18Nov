package ejercicio12_bancoUsoBloqueoObjeto;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas;  //array donde se guarda el saldo de cada cuenta
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad) throws InterruptedException{
		
		/* Vloquea un trozo de codigo del programa
		 * para que solo pueda ser ejecutado por un unico hilo simultaneamente
		 * */
		
		try {
			while(cuentas[cuentaOrigen]<cantidad)  {
				Thread nombreHilo = Thread.currentThread();
			
				wait(); //clase Object
				//Hace que el subproceso actual espere hasta que otro subproceso invoque al notifyAll()
				System.out.println(nombreHilo.getName()+" Esta a la espera");
			}
			
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen]-=cantidad;
			System.out.printf("Cantidad transferida: %10.2f de Cuenta origen %d para cuenta destino %d", cantidad,cuentaOrigen,cuentaDestino);
			cuentas[cuentaDestino]+=cantidad;
			System.out.printf("\n Saldo total: %10.2f%n",this.getSaldoTotal());		
			
			//informa a todos los hilos para que despierten a los hilos que estan a la espera
			notifyAll(); 
			
		}finally{
			
			//desbloquea el codigo
		}
	}
	
	public Double getSaldoTotal() {
		Double suma_cuentas=0.0;
		
		for(Double a:cuentas) {
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
	
	public Banco() {
		//inicialmente  a cada cuenta se le asignan 2000 euros
		// en el banco hay 100 cuentas
		cuentas=new Double[100];
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000.0;
		}
	}

	

	public Double[] getCuentas() {
		return cuentas;
	}
	
	
	
}
