package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class ObtenerCoockieSesion implements Task {
    private final String nombreCookie;

    public ObtenerCoockieSesion(String nombreCookie) {
        this.nombreCookie = nombreCookie;
    }

    public static ObtenerCoockieSesion conNombre(String nombreCookie) {
        return new ObtenerCoockieSesion(nombreCookie);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver navegador = BrowseTheWeb.as(actor).getDriver();
        Cookie cookie = navegador.manage().getCookieNamed(nombreCookie);
        if (cookie != null) {
            actor.remember("valorCookieSesion", cookie.getValue());
        }
    }
}
