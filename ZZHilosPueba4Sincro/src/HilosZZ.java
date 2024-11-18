
public class HilosZZ extends Thread {
	
	private String nom;
	private float num;
	private Opera opera;
	
	public HilosZZ(String nombre, float num) {
		this.nom=nombre;
		this.num=num;
	}
	
	 public void setOpera(Opera opera) {
	        this.opera = opera; // Asignar la instancia compartida
	    }
	
	public void run() {
		opera.ejecuta(this.nom, this.num); //usamos el mismo opera que viene del main IMPORTANTE
	}
	
}
