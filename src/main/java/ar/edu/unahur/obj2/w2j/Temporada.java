package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private final int numero;
    private final List<Episodio> episodios;

    public Temporada(int numero) {
        this.numero = numero;
        this.episodios = new ArrayList<>();
    }

    public int numero() {
        return numero;
    }

    public void agregarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    public List<Episodio> episodios() {
        return List.copyOf(episodios);
    }
}
