package mystore;

import mystore.acciones.Decidido;
import mystore.acciones.IngresarCon;
import mystore.preguntas.LaPaginaMyAccount;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class CuandoUsuarioSeLoguea {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void prepararEsenario(){
        actor= Actor.named("Jorge");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Test
    public void ingresarAMyAccount(){
        /* El actor se registra en la plataforma de ventas
            El actor quiere ingresar a su cuenta
            El actor puede ver el subtitulo de la cuenta MyAccount*/

        //El actor se registra en la plataforma de ventas
        //Dado
        actor.has(Decidido.ingresarConUsuarioYContraseña());

        //El actor quiere ingresar a su cuenta
        //Cuando
        actor.attemptsTo(IngresarCon.usuario("trabucco.francisco@gmail.com").contraseña("argentina1"));

        //El actor puede ver el subtitulo de la cuenta MyAccount
        //Entonces
        actor.should(
                seeThat("subtitulo de pagina MyAccount", LaPaginaMyAccount.subtitulo(),equalTo("Welcome to your account. Here you can manage all of your personal information and orders."))
        );
    }

}
