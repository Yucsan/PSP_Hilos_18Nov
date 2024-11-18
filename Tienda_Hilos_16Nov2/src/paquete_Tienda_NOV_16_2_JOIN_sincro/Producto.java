package paquete_Tienda_NOV_16_2_JOIN_sincro;

import java.util.Objects;

public class Producto {

	private Integer codigoProducto;
	private String nombreProd;
	private Integer stock;
	private Double precio;

	
	public Producto(Integer codigoProducto) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProd = "";
		this.stock = 0;
		this.precio = 0.0;
	}
	public Producto(Integer codigoProducto, String nombreProd, Integer stock, Double precio) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProd = nombreProd;
		this.stock = stock;
		this.precio = precio;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("Producto codigoProducto: %s, nombreProd: %s, stock: %s, precio: %s", codigoProducto,
				nombreProd, stock, precio);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigoProducto, other.codigoProducto);
	}
	
	
	
}