package testserenity.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.yecht.Data;
import testserenity.ui.SearchBox;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CalendarAction implements Interaction {

    public String checkIn;
    public String checkOut;
    public Target calendarContainer;

    public CalendarAction(String checkIn, String checkOut, Target calendarContainer) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.calendarContainer = calendarContainer;
    }

    @Override
    @Step("#actor books a room from #checkIn to #checkOut")
    public <T extends Actor> void performAs(T actor) {
        Target calendar = Target.the("Calendar").located(By.className("xp__dates__checkin"));
        Target checkInBtn = Target.the("check in")
                .locatedBy("//td[@data-date=\"{0}\"]").of(this.checkIn);
        Target checkOutBtn = Target.the("check out")
                .locatedBy("//td[@data-date=\"{0}\"]").of(this.checkOut);
        actor.attemptsTo(
                DoubleClick.on(calendar),
                Click.on(checkInBtn),
                Click.on(checkOutBtn)
        );
    }

    public static CalendarBuilder withCheckIn(String checkIn) {
        return new CalendarBuilder(checkIn);
    }

    public static class CalendarBuilder {
        public String checkIn;
        public String checkOut;

        public CalendarBuilder(String checkIn) {
            this.checkIn = checkIn;
        }

        public CalendarBuilder andCheckOut(String checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Interaction on(Target calendarContainer) {
            return instrumented(CalendarAction.class, this.checkIn, this.checkOut, calendarContainer);
        }
    }
}
