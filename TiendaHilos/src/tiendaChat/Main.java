package tiendaChat;
public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        for (Cliente cliente : tienda.getCarroClientes()) {
            HiloCompra hiloCompra = new HiloCompra(cliente, tienda);
            hiloCompra.start();
        }
    }
}
