import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccionPrincipal;

    // Listas / Atributos
    private List<Sucursal> listaSucursales;
    private List<Prenda> listaCatalogoPrendas;
    private List<Cliente> listaClientes;
    private List<Vendedor> listaVendedoresE;

    public Empresa(String nombre, String nit, String direccionPrincipal) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccionPrincipal = direccionPrincipal;

        this.listaSucursales = new ArrayList<>();
        this.listaCatalogoPrendas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaVendedoresE = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public List<Sucursal> getListaSucursalesE() {
        return listaSucursales;
    }

    public List<Prenda> getListaCatalogoPrendas() {
        return listaCatalogoPrendas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Vendedor> getListaVendedoresE() {
        return listaVendedoresE;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "Nombre: '" + nombre + '\'' +
                ", nit:'" + nit + '\'' +
                ", Direccion Principal:'" + direccionPrincipal + '\'' +
                ", lista de Sucursales:" + listaSucursales.size() +
                ", Catalogo de Prendas:" + listaCatalogoPrendas.size() +
                ", lista de Clientes:" + listaClientes.size() +
                ", lista de Vendedores:" + listaVendedoresE.size() +
                '}';
    }

    // ==================== MÉTODOS DE NEGOCIO ====================

    // Método para registrar la sucursal
    public boolean registrarSucursal(Sucursal sucursal) {
        if (sucursal != null && !this.listaSucursales.contains(sucursal)) {
            return this.listaSucursales.add(sucursal);
        }
        return false;
    }

    // Método para registrar prenda en el catálogo global
    public boolean registrarPrenda(Prenda prenda) {
        if (prenda != null && !this.listaCatalogoPrendas.contains(prenda)) {
            return this.listaCatalogoPrendas.add(prenda);
        }
        return false;
    }

    // Método para registrar cliente
    public boolean registrarCliente(Cliente cliente) {
        if (cliente != null && !this.listaClientes.contains(cliente)) {
            return this.listaClientes.add(cliente);
        }
        return false;
    }

    // metodo para consultar prendas disponibles de una sucursal específica
    public List<Inventario> consultarPrendasDisponibles(String codigoSucursal) {
        for (Sucursal sucursal : this.listaSucursales) {
            if (sucursal.getCodigo().equalsIgnoreCase(codigoSucursal)) {
                return sucursal.consultarPrendasDisponibles();
            }
        }
        return new ArrayList<>(); // Si no se encuentra la sucursal
    }

    // metodo para vconsultar ventas globales realizadas por un vendedor
    public List<Venta> consultarVentasPorVendedor(String codigoEmpleado) {
        List<Venta> ventasVendedor = new ArrayList<>();
        for (Sucursal sucursal : this.listaSucursales) {
            for (Venta venta : sucursal.getListaVentas()) {
                if (venta.getVendedor() != null &&
                        venta.getVendedor().getCodigoEmpleado().equalsIgnoreCase(codigoEmpleado)) {
                    ventasVendedor.add(venta);
                }
            }
        }
        return ventasVendedor;
    }

    // metodo para consultar compras globales realizadas por un cliente
    public List<Venta> consultarComprasPorCliente(String codigoAfiliacion) {
        List<Venta> comprasCliente = new ArrayList<>();
        for (Sucursal sucursal : this.listaSucursales) {
            for (Venta venta : sucursal.getListaVentas()) {
                if (venta.getCliente() != null &&
                        venta.getCliente().getCodigoAfiliacion().equalsIgnoreCase(codigoAfiliacion)) {
                    comprasCliente.add(venta);
                }
            }
        }
        return comprasCliente;
    }

    // Calcular la prenda con mayor volumen de unidades vendidas
    public Prenda calcularPrendaMasVendida() {
        if (this.listaCatalogoPrendas.isEmpty()) return null;

        Prenda masVendida = null;
        int maxCantidad = 0;

        for (Prenda prenda : this.listaCatalogoPrendas) {
            int totalVendidas = 0;

            // Recorremos todas las sucursales, ventas y detalles
            for (Sucursal sucursal : this.listaSucursales) {
                for (Venta venta : sucursal.getListaVentas()) {
                    for (DetalleVenta detalle : venta.getDetalles()) {
                        if (detalle.getInventario() != null &&
                                detalle.getInventario().getPrenda().equals(prenda)) {
                            totalVendidas += detalle.getCantidad();
                        }
                    }
                }
            }

            if (totalVendidas > maxCantidad) {
                maxCantidad = totalVendidas;
                masVendida = prenda;
            }
        }

        return masVendida;
    }
}