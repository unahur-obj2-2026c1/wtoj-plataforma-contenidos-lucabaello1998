package ar.edu.unahur.obj2.w2j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlataformaContenidosTest {

    @BeforeEach
    void resetearCanonIdra() {
        Documental.actualizarCanonIdra(0.5);
    }

    @Test
    void unaPeliculaTieneComoCostoDeLicenciaSuCostoBase() {
        Pelicula pelicula = new Pelicula("Peli 1", 2.0);

        assertEquals(2.0, pelicula.costoLicencia(), 0.0001);

        pelicula.actualizarCostoBaseLicencia(3.5);
        assertEquals(3.5, pelicula.costoLicencia(), 0.0001);
    }

    @Test
    void unDocumentalSumaElCanonIdraAlCostoBase() {
        Documental documental = new Documental("Docu 1", 1.0);

        assertEquals(1.5, documental.costoLicencia(), 0.0001);

        Documental.actualizarCanonIdra(0.8);
        assertEquals(1.8, documental.costoLicencia(), 0.0001);
    }

    @Test
    void elCostoDeLicenciaDeUnaSerieEsBaseMasPromedioDeEpisodios() {
        Serie serie = new Serie("Serie 1", 3.0);

        Temporada temporada1 = new Temporada(1);
        temporada1.agregarEpisodio(new Episodio(1, "Ep 1", 2.0));
        temporada1.agregarEpisodio(new Episodio(2, "Ep 2", 4.0));

        Temporada temporada2 = new Temporada(2);
        temporada2.agregarEpisodio(new Episodio(1, "Ep 1", 6.0));

        serie.agregarTemporada(temporada1);
        serie.agregarTemporada(temporada2);

        // promedio episodios: (2 + 4 + 6) / 3 = 4
        assertEquals(7.0, serie.costoLicencia(), 0.0001);
    }

    @Test
    void planBasicoCobraExcedentesPorCostoBase() {
        Usuario usuario = new Usuario("Luca", new PlanBasico(5.0, 2));

        usuario.registrarVisualizacion(new Pelicula("P1", 2.0));
        usuario.registrarVisualizacion(new Pelicula("P2", 3.0));
        usuario.registrarVisualizacion(new Pelicula("P3", 4.0));
        usuario.registrarVisualizacion(new Pelicula("P4", 1.0));

        // primeros 2 dentro del plan, excedentes: 4 + 1
        assertEquals(10.0, usuario.costoMensual(), 0.0001);
    }

    @Test
    void planPremiumSiempreCobraValorFijo() {
        Usuario usuario = new Usuario("Ana", new PlanPremium(12.0));

        usuario.registrarVisualizacion(new Pelicula("P1", 2.0));
        usuario.registrarVisualizacion(new Pelicula("P2", 3.0));
        usuario.registrarVisualizacion(new Documental("D1", 1.0));

        assertEquals(12.0, usuario.costoMensual(), 0.0001);
    }

    @Test
    void unUsuarioPuedeCambiarDePlanBasicoAFamiliarYSeAplicaDescuento() {
        Usuario usuario = new Usuario("Juan", new PlanBasico(10.0, 1));

        usuario.registrarVisualizacion(new Pelicula("P1", 2.0));
        usuario.registrarVisualizacion(new Pelicula("P2", 4.0));

        // basico: 10 + 4 = 14
        assertEquals(14.0, usuario.costoMensual(), 0.0001);

        usuario.cambiarPlan(new PlanFamiliar(10.0, 1));

        // familiar: (10 + 4) * 0.85 = 11.9
        assertEquals(11.9, usuario.costoMensual(), 0.0001);
    }

    @Test
    void alCerrarMesSeCalculaFacturacionTotalYLimpiaConsumos() {
        PlataformaContenidos plataforma = new PlataformaContenidos();

        Usuario u1 = new Usuario("Luca", new PlanPremium(12.0));
        u1.registrarVisualizacion(new Pelicula("P1", 2.0));

        Usuario u2 = new Usuario("Mica", new PlanBasico(5.0, 1));
        u2.registrarVisualizacion(new Pelicula("P2", 3.0));
        u2.registrarVisualizacion(new Pelicula("P3", 4.0));

        plataforma.registrarUsuario(u1);
        plataforma.registrarUsuario(u2);

        // premium 12 + basico (5 + 4) = 21
        assertEquals(21.0, plataforma.facturacionTotalDelMes(), 0.0001);

        double facturacionCierre = plataforma.cerrarMes();
        assertEquals(21.0, facturacionCierre, 0.0001);
        assertEquals(0, u1.cantidadContenidosConsumidos());
        assertEquals(0, u2.cantidadContenidosConsumidos());
    }
}
