public abstract class Persona {

    private String documentoIdentidad;
    private String nombre;
    private String email;
    private String telefono;

    public Persona(String documentoIdentidad, String nombre, String email, String telefono) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "documento de Identidad:'" + documentoIdentidad + '\'' +
                ", nombre:'" + nombre + '\'' +
                ", email:'" + email + '\'' +
                ", telefono:'" + telefono + '\'';
    }
}
