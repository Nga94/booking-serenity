package testserenity.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("username field").located(By.cssSelector("input[type=\"email\"]"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.cssSelector("input[type=\"password\"]"));
    public static final Target OTPCODE = Target.the("OTP code").located(By.cssSelector("div.login-form input[type=\"text\"]"));
    public static final Target LOGIN = Target.the("login button").locatedBy("(//button[@type=\"button\"])[1]");
    public static final Target CONFIRM_OTP = Target.the("confirm with OTP code").located(By.cssSelector("button.btn-confirm"));
}
