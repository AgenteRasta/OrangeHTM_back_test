package setup;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class SetUpBack extends SetUpFront{

    protected Actor actor = new Actor("Estiven");

    protected void setUp(String urlBase){
        actorCallAnApi(urlBase);
    }

    private void actorCallAnApi(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }

}
