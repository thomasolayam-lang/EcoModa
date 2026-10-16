import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    // Listas (corregidas las mayúsculas y nombres de clases en singular)
    private List<Inventario> listaInventario;
    private List<Vendedor> listaVendedores;
    private List<Venta> listaVentas;

    public Sucursal(String codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;

        this.listaInventario = new ArrayList<>();
        this.listaVendedores = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "Codigo:'" + codigo + '\'' +
                ", Nombre:'" + nombre + '\'' +
                ", Direccion:'" + direccion + '\'' +
                ", Ciudad:'" + ciudad + '\'' +
                ", lista de Inventario:" + listaInventario +
                ", lista de Vendedores:" + listaVendedores +
                ", lista de Ventas:" + listaVentas + '}';
    }

    // ==================== MÉTODOS DE NEGOCIO ====================

    // Registrar o actualizar inventario
    public boolean registrarInventario(Inventario inventario) {
        if (inventario == null) return false;

        // Buscar si ya existe la prenda con la misma talla y color en esta sucursal
        for (Inventario inv : this.listaInventario) {
            if (inv.getPrenda().getCodigo().equalsIgnoreCase(inventario.getPrenda().getCodigo()) &&
                    inv.getTalla().equalsIgnoreCase(inventario.getTalla()) &&
                    inv.getColor().equalsIgnoreCase(inventario.getColor())) {

                // Si ya existe, sumamos el stock recibido al stock actual
                inv.aumentarStock(inventario.getCamtidadDisponible());
                return true;
            }
        }

        // Si es un producto nuevo en esta sucursal, lo agregamos a la lista
        return this.listaInventario.add(inventario);
    }

    // Registrar venta
    public boolean registrarVenta(Venta venta) {
        if (venta == null) return false;

        // Confirmar la venta (descuenta el stock de cada ítem)
        boolean ventaConfirmada = venta.confirmarVenta();

        if (ventaConfirmada) {
            return this.listaVentas.add(venta);
        }
        return false;
    }

    // Calcular ingresos totales
    public double calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (Venta venta : this.listaVentas) {
            ingresosTotales += venta.getTotalVenta();
        }
        return ingresosTotales;
    }

    // Consultar prendas agotadas
    public List<Inventario> consultarPrendasAgotadas() {
        List<Inventario> agotadas = new ArrayList<>();
        for (Inventario inv : this.listaInventario) {
            if (inv.getCamtidadDisponible() == 0) {
                agotadas.add(inv);
            }
        }
        return agotadas;
    }

    // Consultar prendas disponibles
    public List<Inventario> consultarPrendasDisponibles() {
        List<Inventario> disponibles = new ArrayList<>();
        for (Inventario inv : this.listaInventario) {
            if (inv.getCamtidadDisponible() > 0) {
                disponibles.add(inv);
            }
        }
        return disponibles;
    }
}
