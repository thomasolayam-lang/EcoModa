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
}
