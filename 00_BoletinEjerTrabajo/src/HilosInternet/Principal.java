package HilosInternet;


public class Principal {

    public static void main(String[] args) {
       
    	Saludo s=new Saludo();
    	
    	Persona p1 = new Persona("Pepe", s, false);
    	Persona p2 = new Persona("Ana", s, true);
    	
    	p1.start();
    	p2.start();
    	

    }

}
