package ar.edu.unahur.obj2.w2j;

import java.util.List;

public class PlanBasico implements PlanSuscripcion {
    private final double valorFijoMensual;
    private final int maximoContenidos;

    public PlanBasico(double valorFijoMensual, int maximoContenidos) {
        this.valorFijoMensual = valorFijoMensual;
        this.maximoContenidos = maximoContenidos;
    }

    @Override
    public double costoMensual(List<Contenido> contenidosConsumidos) {
        double excedentes = contenidosConsumidos.stream()
                .skip(maximoContenidos)
                .mapToDouble(Contenido::costoBaseLicencia)
                .sum();

        return valorFijoMensual + excedentes;
    }
}
