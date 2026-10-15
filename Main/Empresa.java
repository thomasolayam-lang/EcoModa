import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccionPrincipal;

    //listas
    private list<Sucursales> listaSucursalesE;
    private list<Prendas>  listaCatalogoPrendas;
    private  list<Clientes> listaClientes;
    private list <Vendedores> listaVendedoresE;

    public Empresa(String nombre, String nit, String direccionPrincipal) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccionPrincipal = direccionPrincipal;

        listaSucursalesE= new ArrayList<>();
        listaCatalogoPrendas= new ArrayList<>();
        listaClientes= new ArrayList<>();
        listaVendedoresE= new ArrayList<>();
    }

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

    public list<Sucursales> getListaSucursalesE() {
        return listaSucursalesE;
    }

    public void setListaSucursalesE(list<Sucursales> listaSucursalesE) {
        this.listaSucursalesE = listaSucursalesE;
    }

    public list<Prendas> getListaCatalogoPrendas() {
        return listaCatalogoPrendas;
    }

    public void setListaCatalogoPrendas(list<Prendas> listaCatalogoPrendas) {
        this.listaCatalogoPrendas = listaCatalogoPrendas;
    }

    public list<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(list<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public list<Vendedores> getListaVendedoresE() {
        return listaVendedoresE;
    }

    public void setListaVendedoresE(list<Vendedores> listaVendedoresE) {
        this.listaVendedoresE = listaVendedoresE;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "Nombre: '" + nombre + '\'' +
                ", nit:'" + nit + '\'' +
                ", Direccion Principal:'" + direccionPrincipal + '\'' +
                ", lista de Sucursales:" + listaSucursalesE +
                ", Catalogo de Prendas:" + listaCatalogoPrendas +
                ", lista de Clientes:" + listaClientes +
                ", lista de Vendedores:" + listaVendedoresE;
    }
//metodos

}
