package co.com.davivienda.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;


public class PaginaInicial extends PageObject {

    public static final Target OBTENER_USERNAME=
            Target.the("Obtiene el texto username admin").
                    locatedBy("(//p[@class='oxd-text oxd-text--p'])[1]");

    public static final Target OBTENER_CONTRASENIA=
                Target.the("Obtiene el texto contrasenia admin").
                        locatedBy("(//p[@class='oxd-text oxd-text--p'])[2]");

    public static final Target CAMPO_TEXTO_USERNAME=
                Target.the("Campo para escribir usuario a loguear").
                        locatedBy("//input[@name='username']");

    public static final Target CAMPO_TEXTO_CONTRASENIA=
                Target.the("Campo para escribir la contrasenia del usuario a loguear").
                        locatedBy("//input[@name='password']");

    public static final Target BOTON_LOGIN=
                    Target.the("Boton para iniciar sesion").
                            locatedBy("//button[@type='submit']");


}
