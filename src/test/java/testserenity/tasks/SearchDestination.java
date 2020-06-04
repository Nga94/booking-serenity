package testserenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import testserenity.ui.SearchBox;

public class SearchDestination implements Task {

    private final String destination;

    protected SearchDestination(String destination) {
        this.destination = destination;
    }

    @Step("Search for #destination")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(destination)
                     .into(SearchBox.SEARCH_FIELD),
                Click.on(SearchBox.SUGGESTION_RESULT)
        );
    }

    public static SearchDestination with(String destination) {
        return instrumented(SearchDestination.class, destination);
    }
}
