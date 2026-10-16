import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private String codigo;
    private LocalDate fecha;
    private double totalVenta;

    // Relaciones según UML
    private Sucursal sucursal;
    private Vendedor vendedor;
    private Cliente cliente; // <-- Agregado: indispensable para descuentos

    // Listas / Composición
    private List<DetalleVenta> detalles;

    // Se remueve totalVenta como parámetro del constructor (arranca en 0.0)
    public Venta(String codigo, LocalDate fecha, Sucursal sucursal, Vendedor vendedor, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.totalVenta = 0.0;
        this.detalles = new ArrayList<>();
    }

    // Getters y Setters
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", totalVenta=" + totalVenta +
                ", sucursal=" + (sucursal != null ? sucursal.getNombre() : "N/A") +
                ", vendedor=" + (vendedor != null ? vendedor.getNombre() : "N/A") +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "N/A") +
                ", numDetalles=" + detalles.size() +
                '}';
    }

    // ==================== MÉTODOS DE NEGOCIO ====================

    // Método para agregar un detalle a la venta
    public boolean agregarDetalle(DetalleVenta detalle) {
        if (detalle != null) {
            this.detalles.add(detalle);
            calcularTotalVenta(); // Re-calcula el total provisional
            return true;
        }
        return false;
    }

    // Método para calcular el valor total de la venta
    public double calcularTotalVenta() {
        double total = 0.0;
        for (DetalleVenta detalle : this.detalles) {
            total += detalle.calcularSubTotal();
        }
        this.totalVenta = total;
        return total;
    }

    // Método para confirmar la venta
    public boolean confirmarVenta() {
        // 1. Validar que la venta tenga productos
        if (this.detalles.isEmpty()) {
            return false;
        }

        // 2. Verificar que haya stock suficiente para todos los ítems antes de modificar
        for (DetalleVenta detalle : this.detalles) {
            Inventario inv = detalle.getInventario();
            if (!inv.verificarStock(detalle.getCantidad())) {
                return false; // Si falta stock en alguno, no procesa la compra
            }
        }

        // 3. Descontar el stock de cada inventario
        for (DetalleVenta detalle : this.detalles) {
            Inventario inv = detalle.getInventario();
            inv.descontarStock(detalle.getCantidad());
        }

        // 4. Recalcular el total final
        calcularTotalVenta();
        return true;
    }
}