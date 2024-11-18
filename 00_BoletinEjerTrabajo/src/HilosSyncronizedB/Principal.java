package HilosSyncronizedB;


public class Principal {

    public static void main(String[] args) {
       
    	Saludo s=new Saludo();
    	
    	Persona hola = new Persona("persona 1", s, false);
    	Persona adios = new Persona("persona 2", s, true);
    	
    	hola.start();
    	adios.start();
    	

    }

}
