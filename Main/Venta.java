import java.time.LocalDate;

public class Venta {

    private String codigo;
    private LocalDate fecha;
    private double totalVenta;

    //relaciones
    private Sucursal sucursal;
    private Vendedor vendedor;

    public Venta(String codigo, LocalDate fecha, double totalVenta, Sucursal sucursal, Vendedor vendedor) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", totalVenta=" + totalVenta +
                ", sucursal=" + sucursal +
                ", vendedor=" + vendedor +
                '}';
    }


    //                                           METODOS

    //Metodo para calcular el valor total de la venta
    public double calcularTotalVenta() {
        double total = 0.0;
        for (DetalleVenta detalle : this.detalles) {
            // Llama al método de DetalleVenta para obtener subtotal (que ya descuenta la membresía)
            total += detalle.calcularSubTotal();
        }
        this.totalVenta = total;
        return total;
    }
//  metodo para confirmar la venta
    public boolean confirmarVenta() {
        // 1. Validar que la venta tenga productos
        if (this.detalles.isEmpty()) {
            return false;
        }

        // 2. Paso 1: Verificar que HAYA STOCK suficiente para TODOS los ítems antes de modificar nada
        for (DetalleVenta detalle : this.detalles) {
            Inventario inv = detalle.getInventario();
            if (!inv.verificarStock(detalle.getCantidad())) {
                return false; // Si tan solo un producto no tiene stock suficiente, se cancela la venta
            }
        }

        // 3. Paso 2: Si todos tienen stock, procedemos a descontar el stock de cada inventario
        for (DetalleVenta detalle : this.detalles) {
            Inventario inv = detalle.getInventario();
            inv.descontarStock(detalle.getCantidad());
        }

        // 4. Recalcular el total final
        calcularTotalVenta();
        return true;
    }

    //metodo para agregar el detalle
    public boolean agregarDetalle(DetalleVenta detalle) {
        if (detalle != null) {
            this.detalles.add(detalle);
            calcularTotalVenta(); // Re-calcula el total provisional
            return true;
        }
        return false;
    }
}
