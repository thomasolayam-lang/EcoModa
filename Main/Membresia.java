public enum Membresia {

    BRONCE(0.015),
    PLATA(0.10),
    ORO(0.15);

    private double porcentajeDescuento;

    Membresia(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Membresia{" +
                "porcentaje de Descuento=" + porcentajeDescuento+"%";
    }
}
