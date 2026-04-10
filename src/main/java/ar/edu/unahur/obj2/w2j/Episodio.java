package ar.edu.unahur.obj2.w2j;

public class Episodio {
    private final int numero;
    private final String titulo;
    private final double costoLicencia;

    public Episodio(int numero, String titulo, double costoLicencia) {
        this.numero = numero;
        this.titulo = titulo;
        this.costoLicencia = costoLicencia;
    }

    public int numero() {
        return numero;
    }

    public String titulo() {
        return titulo;
    }

    public double costoLicencia() {
        return costoLicencia;
    }
}
