package HilosSyncronizedA;



public class Principal {

    public static void main(String[] args) {
       
    	Saludo s=new Saludo();
    	
    	Empleado emple1 = new Empleado("Pepe", s, false);
    	Empleado emple2 = new Empleado("José", s, false);
    	Empleado emple3 = new Empleado("Pedro", s, false);
    	Empleado jefe1 = new Empleado("JEFE", s, true);
    	
    	emple1.start();
    	emple2.start();
    	emple3.start();
    	jefe1.start();
    	

    }

}
