package paquete_Tienda_NOV_16_2_syncronized.CHATGPT;

public class ItemProducto {
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	
	public Integer getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public ItemProducto(Integer codigoProducto, Integer cantidad, Double precio) {
		super();
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	@Override
	public String toString() {
		return String.format("codigoProducto: %s, cantidad: %s, precio: %s", codigoProducto, cantidad,
				precio);
	}
	
	
	
	
	
	
	
}