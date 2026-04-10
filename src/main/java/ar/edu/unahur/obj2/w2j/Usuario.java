package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nombre;
    private PlanSuscripcion plan;
    private final List<Contenido> contenidosConsumidos;

    public Usuario(String nombre, PlanSuscripcion plan) {
        this.nombre = nombre;
        this.plan = plan;
        this.contenidosConsumidos = new ArrayList<>();
    }

    public String nombre() {
        return nombre;
    }

    public void cambiarPlan(PlanSuscripcion nuevoPlan) {
        this.plan = nuevoPlan;
    }

    public void registrarVisualizacion(Contenido contenido) {
        contenidosConsumidos.add(contenido);
    }

    public double costoMensual() {
        return plan.costoMensual(contenidosConsumidos);
    }

    public void limpiarConsumoMensual() {
        contenidosConsumidos.clear();
    }

    public int cantidadContenidosConsumidos() {
        return contenidosConsumidos.size();
    }
}
