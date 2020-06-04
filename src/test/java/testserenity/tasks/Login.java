package testserenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import testserenity.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login (String username, String password){
        this.username =username;
        this.password =password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN)
        );
    }

    public static LoginBuilder withEmail(String email){
        return new LoginBuilder(email);
    }
    public static class LoginBuilder
    {
        private String email;
        public LoginBuilder(String email){
            this.email = email;
        }
        public Login andPassword(String password){
            return instrumented(Login.class, this.email, password);
        }
    }
}
