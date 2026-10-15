import java.time.LocalDate;

public class Vendedor extends Persona{

    private String codigoEmpleado;
    private LocalDate FechaContratacion;
    private double salarioBasico;

    public Vendedor(String documentoIdentidad, String nombre, String email, String telefono, String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico) {
        super(documentoIdentidad, nombre, email, telefono);
        this.codigoEmpleado = codigoEmpleado;
        FechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        FechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codigo de Empleado:'" + codigoEmpleado + '\'' +
                ", Fecha de Contratacion:" + FechaContratacion +
                ", Salario Basico:" + salarioBasico;
    }
}
