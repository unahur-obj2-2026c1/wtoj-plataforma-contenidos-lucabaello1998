package ar.edu.unahur.obj2.w2j;

import java.util.List;

public class PlanFamiliar implements PlanSuscripcion {
    private final PlanBasico planBasico;

    public PlanFamiliar(double valorFijoMensual, int maximoContenidos) {
        this.planBasico = new PlanBasico(valorFijoMensual, maximoContenidos);
    }

    @Override
    public double costoMensual(List<Contenido> contenidosConsumidos) {
        return planBasico.costoMensual(contenidosConsumidos) * 0.85;
    }
}
