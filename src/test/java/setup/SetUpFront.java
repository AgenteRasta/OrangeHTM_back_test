package setup;


import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class SetUpFront {

    @Managed
    protected WebDriver webDriver;

    public static final String ACTOR_NAME = "Estiven";
    private void setUpStageAndActor() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(ACTOR_NAME).can(BrowseTheWeb.with(webDriver));
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(webDriver));
    }

    protected void initialSetUpFront() {
        setUpStageAndActor();
    }

    protected void quitarDriver() {
        webDriver.quit();
    }
}
