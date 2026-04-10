package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {
    private final List<Temporada> temporadas;

    public Serie(String titulo, double costoBaseLicencia) {
        super(titulo, costoBaseLicencia);
        this.temporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    @Override
    public double costoLicencia() {
        return costoBaseLicencia() + promedioCostosEpisodios();
    }

    private double promedioCostosEpisodios() {
        return temporadas.stream()
                .flatMap(temporada -> temporada.episodios().stream())
                .mapToDouble(Episodio::costoLicencia)
                .average()
                .orElse(0);
    }
}
