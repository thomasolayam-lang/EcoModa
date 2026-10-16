public class Inventario {

    private String talla;
    private String color;
    private  int cantidadDisponible;

    //Relaciones
    private Prenda prenda;
    private Sucursal sucursal;

    public Inventario(String talla, String color, int cantidadDisponible, Prenda prenda, Sucursal sucursal) {
        this.talla = talla;
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.prenda = prenda;
        this.sucursal = sucursal;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "Talla:" + talla + '\'' +
                ", Color:'" + color + '\'' +
                ", Camtidad Disponible:" + cantidadDisponible +
                ", Prenda:" + prenda +
                ", Sucursal:" + sucursal + '}' ;
    }

    //                                                  METODOS

    //verificar Stock
    public boolean verificarStock(int cantidad) {
        return cantidad > 0 && this.cantidadDisponible >= cantidad;
    }

    //descontar Strock

    public boolean descontarStock(int cantidad) {
        if (verificarStock(cantidad)) {
            this.cantidadDisponible -= cantidad;
            return true;
        }
        return false; // No hay suficiente stock disponible
    }
//aumentar Stock
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.cantidadDisponible += cantidad;
        }
    }
    
}
