package envio;

public class Envio {
	
	private String mensaje;
	private boolean llegado;

	public Envio() {
		this.mensaje = "";
		this.llegado = true;
	}

	public boolean isLlegado() {
		return llegado;
	}

	public void setLlegado(boolean llegado) {
		this.llegado = llegado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
