package PruebaT;

public class Cliente {
	private String nombre;
	private float dinero;

	public Cliente(String nombre, float dinero) {
		super();
		this.nombre = nombre;
		this.dinero = dinero;
	}

	public void opera(float ingreso) {
		for (int i = 1; i < 5; i++) {
			dinero += i;
			System.out.println(i);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
