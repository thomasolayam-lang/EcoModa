import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{

    private String codigoEmpleado;
    private LocalDate FechaContratacion;
    private double salarioBasico;
    private List<Venta> ventasRealizadas;

    public Vendedor(String documentoIdentidad, String nombre, String email, String telefono, String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico) {
        super(documentoIdentidad, nombre, email, telefono);
        this.codigoEmpleado = codigoEmpleado;
        FechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.ventasRealizadas = new ArrayList<>();
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

    public List<Venta> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(List<Venta> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codigo de Empleado:'" + codigoEmpleado + '\'' +
                ", Fecha de Contratacion:" + FechaContratacion +
                ", Salario Basico:" + salarioBasico;
    }
}
