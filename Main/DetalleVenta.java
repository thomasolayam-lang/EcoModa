public class DetalleVenta {

    private int cantidad;

    //relaciones
    private Inventario inventario;
    private Venta venta;

    public DetalleVenta(int cantidad, Inventario inventario, Venta venta) {
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "cantidad=" + cantidad +
                ", inventario=" + inventario +
                ", venta=" + venta +
                '}';
    }
    //                                          METODOS
//metodo para calcular el precio unitario

    public double calcularPrecioUnitario() {
        Prenda prenda = this.inventario.getPrenda();
        double precioBase = prenda.getPrecioBase();

        // 1. Obtener recargo por categoría (% extra)
        double porcentajeRecargo = prenda.getCategoriaPrenda().getPorcentajeRecargo();
        double precioConRecargo = precioBase * (1 + porcentajeRecargo);

        // 2. Obtener descuento por membresía del cliente (% descuento)
        double porcentajeDescuento = 0.0;
        if (this.venta != null && this.venta.getCliente() != null) {
            porcentajeDescuento = this.venta.getCliente().getMembresia().getPorcentajeDescuento();
        }

        // 3. Aplicar descuento sobre el precio con recargo
        return precioConRecargo * (1 - porcentajeDescuento);
    }

//metodo para calcular el subtotal
public double calcularSubTotal() {
    return this.cantidad * calcularPrecioUnitario();
}


}
