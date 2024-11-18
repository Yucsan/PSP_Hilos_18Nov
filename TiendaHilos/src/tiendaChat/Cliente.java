package tiendaChat;

import java.util.List;

public class Cliente {
    private Integer codigo;
    private String nombre;
    private List<ItemProducto> factura;

    public Cliente(Integer codigo, String nombre, List<ItemProducto> factura) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.factura = factura;
    }

    public Integer getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public List<ItemProducto> getFactura() { return factura; }
}
