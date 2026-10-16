public class Cliente extends Persona{

    private String codigoAfiliacion;

    //relación con enum
    private Membresia membresia;

    public Cliente(String documentoIdentidad, String nombre, String email, String telefono, String codigoAfiliacion, Membresia membresia) {
        super(documentoIdentidad, nombre, email, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.membresia = membresia;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo de Afiliacion:'" + codigoAfiliacion + '\'' +
                ", membresia:" + membresia;
    }
    //Métodos
    public double obtenerPorcentajeDescuento() {
        if (this.membresia != null) {
            return this.membresia.getPorcentajeDescuento();
        }
        return 0.0;
    }
}
