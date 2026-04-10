package ar.edu.unahur.obj2.w2j;

public class Documental extends Contenido {
    private static double canonIdra = 0.5;

    public Documental(String titulo, double costoBaseLicencia) {
        super(titulo, costoBaseLicencia);
    }

    public static void actualizarCanonIdra(double nuevoCanon) {
        canonIdra = nuevoCanon;
    }

    @Override
    public double costoLicencia() {
        return costoBaseLicencia() + canonIdra;
    }
}
