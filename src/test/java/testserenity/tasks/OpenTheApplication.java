package testserenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import testserenity.ui.BookingPage;
import testserenity.ui.SearchBox;

public class OpenTheApplication implements Task {

    BookingPage bookingPage;

    @Step("Open the web page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(bookingPage),
                Click.on(SearchBox.LANGUAGE),
                Click.on(SearchBox.CHOOSE_LANG)
        );
    }
}
