package co.com.davivienda.tasks;

import co.com.davivienda.models.InfoEmpleado;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;
import java.util.logging.Logger;

import static co.com.davivienda.questions.ReturnResponse.returnResponse;
import static co.com.davivienda.utils.TransformarJsons.transformarJsonAListaEmpleados;

public class ServicioEmployessFiltroNombre implements Task {
    private EnvironmentVariables environmentVariables;
    private static final Logger LOGGER = Logger.getLogger(ServicioEmployessFiltroNombre.class.getName());
    Response respuesta;
    JSONObject resBody = null;
    JSONParser parser = new JSONParser();

    private String nombre;
    private String coockieSesion;

    public ServicioEmployessFiltroNombre conCoockieSesion(String coockieSesion){
        this.coockieSesion=coockieSesion;
        return this;
    }

    public ServicioEmployessFiltroNombre conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(
                CallAnApi.at(environmentVariables.optionalProperty("url").orElse("https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/directory/"))
        );
        String recurso="employees?nameOrId=%s";
        try{
            actor.attemptsTo(
                    Get.resource(environmentVariables.optionalProperty("recurso").orElse(String.format(recurso,nombre))).with(request -> request
                            .header("Cookie","orangehrm="+coockieSesion)
                    )
            );
            respuesta = returnResponse().answeredBy(actor);
            resBody = (JSONObject) parser.parse(respuesta.getBody().asString());
            JSONArray listaEmpleadosJson = (JSONArray) resBody.get("data");
            List<InfoEmpleado> listaEmpleados= transformarJsonAListaEmpleados(listaEmpleadosJson);
            InfoEmpleado empleadoEncontrado= listaEmpleados.stream().findFirst().orElse(null);
            LOGGER.info("Se obtiene el empleado" + empleadoEncontrado.toString());
            actor.remember("empleadoEncontrado", empleadoEncontrado);

        }catch (Exception e){
            LOGGER.warning("Error al configurar el servicio de empleados: " + e.getMessage());
        }

    }

    public static ServicioEmployessFiltroNombre get(){
        return Tasks.instrumented(ServicioEmployessFiltroNombre.class);
    }
}
