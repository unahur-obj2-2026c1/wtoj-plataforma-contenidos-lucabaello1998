package ar.edu.unahur.obj2.w2j;

import java.util.List;

public class PlanPremium implements PlanSuscripcion {
    private final double valorFijoMensual;

    public PlanPremium(double valorFijoMensual) {
        this.valorFijoMensual = valorFijoMensual;
    }

    @Override
    public double costoMensual(List<Contenido> contenidosConsumidos) {
        return valorFijoMensual;
    }
}
