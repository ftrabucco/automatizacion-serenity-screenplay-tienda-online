package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaMiCuenta {
    public static final Target SUBTITULO = Target.the("subtitulo de la pagina MyAccount")
            .located(By.cssSelector(".info-account"));
}
