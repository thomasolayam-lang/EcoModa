public class Prenda {

    private String codigo;
    private String nombre;
    private String marca;
    private double precioBase;

    //Relacion con enum

    private CategoriaPrenda categoriaPrenda;

    public Prenda(String codigo, String nombre, String marca, double precioBase, CategoriaPrenda categoriaPrenda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoriaPrenda = categoriaPrenda;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setCategoriaPrenda(CategoriaPrenda categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "Codigo:'" + codigo + '\'' +
                ", Nombre:'" + nombre + '\'' +
                ", Marca=:" + marca + '\'' +
                ", Precio Base:" + precioBase +
                ", Categoria Prenda:" + categoriaPrenda;
    }
}
