package ar.edu.unahur.obj2.w2j;

public class Pelicula extends Contenido {

    public Pelicula(String titulo, double costoBaseLicencia) {
        super(titulo, costoBaseLicencia);
    }

    @Override
    public double costoLicencia() {
        return costoBaseLicencia();
    }
}
