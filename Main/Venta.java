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
}
