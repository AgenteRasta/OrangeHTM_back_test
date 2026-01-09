package stepdefinitions;

import co.com.davivienda.models.InfoEmpleado;
import co.com.davivienda.questions.EmpleadoFiltradoEsIgual;
import co.com.davivienda.tasks.ServicioEmployess;
import co.com.davivienda.tasks.ServicioEmployessFiltroNombre;
import co.com.davivienda.tasks.front.IniciarSesionAdmin;
import co.com.davivienda.tasks.front.ObtenerCoockieSesion;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setup.SetUpBack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static co.com.davivienda.tasks.front.AbrirPagina.abrirPagina;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FiltroPorNombreStepdefinitions extends SetUpBack {
    private String coockieSesion;
    private int limit;
    private int usuarioAleatorio;
    private InfoEmpleado empleadoSeleccionado=new InfoEmpleado();
    private InfoEmpleado empleadoSeleccionadoFiltro=new InfoEmpleado();
    private List<InfoEmpleado> listaEmpleadosServicio=new ArrayList<>();
    private SecureRandom random = new SecureRandom();
    @Before
    public void setUp() {
        initialSetUpFront();
    }

    @When("se inicia sesion como administrador en OrangeHRM")
    public void seIniciaSesionComoAdministradorEnOrangeHRM() {
        theActorInTheSpotlight().wasAbleTo(abrirPagina());
        theActorInTheSpotlight().attemptsTo(
                IniciarSesionAdmin.iniciarSesionAdmin()
        );
    }
    @When("se obtiene la cockie de sesion para consumor los servicios")
    public void seObtieneLaCockieDeSesionParaConsumorLosServicios() {
        theActorInTheSpotlight().attemptsTo(
                ObtenerCoockieSesion.conNombre("orangehrm")
        );
        quitarDriver();
        coockieSesion = theActorInTheSpotlight().recall("valorCookieSesion");
        limit=random.nextInt(10)+1;
    }
    @When("se consume el servicio que lista los usuarios")
    public void seConsumeElServicioQueListaLosUsuarios() {
        theActorInTheSpotlight().attemptsTo(
                ServicioEmployess.get()
                        .conCoockieSesion(coockieSesion)
                        .conLimit(String.valueOf(limit))
        );
        listaEmpleadosServicio=theActorInTheSpotlight().recall("listaEmpleados");
        usuarioAleatorio=random.nextInt(limit);
    }
    @When("se selecciona un usuario aleatorio de la lista")
    public void seSeleccionaUnUsuarioAleatorioDeLaLista() {
        empleadoSeleccionado=listaEmpleadosServicio.get(usuarioAleatorio);
    }
    @When("se consume el servicio que filtra por nombre en el directorio con el nombre del usuario seleccionado")
    public void seConsumeElServicioQueFiltraPorNombreEnElDirectorioConElNombreDelUsuarioSeleccionado() {
        theActorInTheSpotlight().attemptsTo(
                ServicioEmployessFiltroNombre.get()
                        .conCoockieSesion(coockieSesion)
                        .conNombre(empleadoSeleccionado.getFirstName())
        );
        empleadoSeleccionadoFiltro=theActorInTheSpotlight().recall("empleadoEncontrado");
    }
    @Then("el sistema retorna la informacion correcta del usuario filtrado")
    public void elSistemaRetornaLaInformacionCorrectaDelUsuarioFiltrado() {
        theActorInTheSpotlight().should(
                seeThat(EmpleadoFiltradoEsIgual.alEmpleadoSeleccionado(empleadoSeleccionado), equalTo(true))
        );
    }
}
