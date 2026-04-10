package ar.edu.unahur.obj2.w2j;

public abstract class Contenido {
    private final String titulo;
    private double costoBaseLicencia;

    protected Contenido(String titulo, double costoBaseLicencia) {
        this.titulo = titulo;
        this.costoBaseLicencia = costoBaseLicencia;
    }

    public String titulo() {
        return titulo;
    }

    public double costoBaseLicencia() {
        return costoBaseLicencia;
    }

    public void actualizarCostoBaseLicencia(double nuevoCostoBaseLicencia) {
        this.costoBaseLicencia = nuevoCostoBaseLicencia;
    }

    public abstract double costoLicencia();
}
