package Ultimo;

public class Telegrama {
	
	private String mensaje;
	private boolean estado;

	public Telegrama() {
		this.mensaje = "";
		this.estado=true;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
}	
