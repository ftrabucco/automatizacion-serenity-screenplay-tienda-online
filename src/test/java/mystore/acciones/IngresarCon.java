package mystore.acciones;

import mystore.ui.PaginaLoguin;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class IngresarCon implements Task {

    private final String usuario;
    private final String contraseña;

    public static IngresarConBuilder usuario(String usuario) {
        return new IngresarConBuilder(usuario);
    }


    @Override
    @Step("{0} ingresa a su cuenta con usuario: #usuario y contraseña: #contraseña")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(usuario).into(PaginaLoguin.EMAIL).thenHit(Keys.TAB),
                Enter.theValue(contraseña).into(PaginaLoguin.PASSWORD).thenHit(Keys.TAB),
                Click.on(PaginaLoguin.BOTON_SIGN_IN)
        );

    }

    public IngresarCon(String usuario, String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;
    }

    public static class IngresarConBuilder{
        private String usuario;

        public IngresarConBuilder(String usuario){
            this.usuario=usuario;
        }
        public Performable contraseña(String contraseña){
            return Instrumented.instanceOf(IngresarCon.class)
                    .withProperties(usuario, contraseña);
        }
    }

}
