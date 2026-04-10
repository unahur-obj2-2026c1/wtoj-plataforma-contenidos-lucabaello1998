package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

public class PlataformaContenidos {
    private final List<Usuario> usuarios;

    public PlataformaContenidos() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public double facturacionTotalDelMes() {
        return usuarios.stream()
                .mapToDouble(Usuario::costoMensual)
                .sum();
    }

    public double cerrarMes() {
        double facturacion = facturacionTotalDelMes();
        usuarios.forEach(Usuario::limpiarConsumoMensual);
        return facturacion;
    }
}
