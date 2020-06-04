package testserenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.collections.iterators.ArrayIterator;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testserenity.actions.CalendarAction;
import testserenity.questions.ListOfResultQuestion;
import testserenity.tasks.OpenTheApplication;
import testserenity.tasks.SearchDestination;
import testserenity.tasks.VisitedCustomer;
import testserenity.ui.SearchBox;

import java.util.ArrayList;
import java.util.Arrays;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class SearchBookingStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                SearchDestination.with("Phu Quoc"),
                CalendarAction.withCheckIn("2020-06-13").andCheckOut("2020-06-16").on(SearchBox.CALENDAR),
                VisitedCustomer.adults(4).child(2).room(3).on(SearchBox.GUEST_CONTAINER),
                Click.on(SearchBox.BTN_SEARCH));

        then(anna).should(
                seeThat(ListOfResultQuestion.displayed(),
                        Matchers.hasItem(Matchers.containsString("Phu Quoc")))
        );

    }
}