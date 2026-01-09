package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.util.logging.Logger;


public class AbrirPagina implements Task {
    Logger LOGGER = Logger.getLogger(AbrirPagina.class.getName());
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.wasAbleTo(
                    Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            );
            LOGGER.info("Se inicia la pagina correctamente");
        }catch (Exception e){
             LOGGER.warning(e.getMessage());
        }

    }

    public static AbrirPagina abrirPagina() {
        return Tasks.instrumented(AbrirPagina.class);
    }
}
