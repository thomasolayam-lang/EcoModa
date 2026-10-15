import java.util.ArrayList;

public class Sucursal {

    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    //listas
    private list<Inventario> listaInventario;
    private list<Vendedores> listaVendedoresS;
    private list<Ventas> listaVentas;

    public Sucursal(String codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;

        listaInventario= new ArrayList<>();
        listaVendedoresS= new ArrayList<>();
        listaVentas= new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "Sucursal{" +
                "Codigo:'" + codigo + '\'' +
                ", Nombre:'" + nombre + '\'' +
                ", Direccion:'" + direccion + '\'' +
                ", Ciudad:'" + ciudad + '\'' +
                ", lista de Inventario:" + listaInventario +
                ", lista de Vendedores:" + listaVendedoresS +
                ", lista de Ventas:" + listaVentas;
    }

    //metodos
}
