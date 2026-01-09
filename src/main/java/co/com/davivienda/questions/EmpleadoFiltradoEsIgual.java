package co.com.davivienda.questions;

import co.com.davivienda.models.InfoEmpleado;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Logger;

public class EmpleadoFiltradoEsIgual implements Question<Boolean> {
    private static final Logger LOGGER = Logger.getLogger(EmpleadoFiltradoEsIgual.class.getName());
    private final InfoEmpleado empleadoEsperado;

    public EmpleadoFiltradoEsIgual(InfoEmpleado empleadoEsperado) {
        this.empleadoEsperado = empleadoEsperado;
    }

    public static EmpleadoFiltradoEsIgual alEmpleadoSeleccionado(InfoEmpleado empleadoEsperado) {
        return new EmpleadoFiltradoEsIgual(empleadoEsperado);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        InfoEmpleado empleadoFiltrado = actor.recall("empleadoEncontrado");
        LOGGER.info("Comparando empleado esperado: " + empleadoEsperado);
        LOGGER.info("Con empleado filtrado: " + empleadoFiltrado);
        boolean resultado = empleadoEsperado.equals(empleadoFiltrado);
        LOGGER.info("¿Son iguales? " + resultado);
        return resultado;
    }
}
