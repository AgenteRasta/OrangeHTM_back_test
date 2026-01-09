package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.logging.Logger;

import static co.com.davivienda.userinterface.PaginaInicial.*;
import static co.com.davivienda.utils.StringUtils.obtenerStringNecesario;

public class IniciarSesionAdmin implements Task {

    private String usernameAdmin;
    private String contraseniaAdmin;
    Logger LOGGER = Logger.getLogger(IniciarSesionAdmin.class.getName());

    @Override
    public <T extends Actor> void performAs(T actor) {
        usernameAdmin=obtenerStringNecesario(OBTENER_USERNAME.resolveFor(actor).getText(), ": ");
        contraseniaAdmin=obtenerStringNecesario(OBTENER_CONTRASENIA.resolveFor(actor).getText(), ": ");
        LOGGER.info("Se obteuvo el username: " + usernameAdmin);
        LOGGER.info("Se obteuvo la contraseña: " + contraseniaAdmin);
        actor.attemptsTo(
                Enter.theValue(usernameAdmin).into(CAMPO_TEXTO_USERNAME),
                Enter.theValue(contraseniaAdmin).into(CAMPO_TEXTO_CONTRASENIA),
                Click.on(BOTON_LOGIN)
        );


    }

    public static IniciarSesionAdmin iniciarSesionAdmin(){
        return new IniciarSesionAdmin();
    }
}
