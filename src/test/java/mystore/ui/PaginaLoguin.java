package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLoguin {
    public static Target EMAIL= Target.the("Entrada de EMAIL")
            .located(By.id("email"));
    public static Target PASSWORD=Target.the("Entrada de contraseña")
            .located(By.id("passwd"));
    public static Target BOTON_SIGN_IN=Target.the("Boton de sing in")
            .located(By.id("SubmitLogin"));

}
