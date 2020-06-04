package testserenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testserenity.abilities.Authenticate;
import testserenity.actions.Verification;
import testserenity.questions.WebTestMasterPageTitle;
import testserenity.tasks.Login;
import testserenity.ui.LoginPage;

import static org.hamcrest.CoreMatchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class LoginTestMasterStory {
    Actor ngant = Actor.named("ngant");

    @Managed
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        ngant.can(BrowseTheWeb.with(herBrowser)).can(Authenticate.LoadTestData(ngant.getName()));
    }

    @Test
    public void loginWithEmailAndPasswordGetCode() {
        givenThat(ngant).wasAbleTo(Open.url("http://testmaster.vn/admin"));
        when(ngant).attemptsTo(
                Login.withEmail(Authenticate.as(ngant).getEmail())
                        .andPassword(Authenticate.as(ngant).getPassword())
        );
        and(ngant).attemptsTo(
                Enter.theValue(Verification.OTPFromEmail().answeredBy(ngant)).into(LoginPage.OTPCODE),
                Click.on(LoginPage.CONFIRM_OTP)
        );
        then(ngant).should(
                seeThat(WebTestMasterPageTitle.get(), is("Admin - Testmaster.vn"))
        );
    }
}
