package testserenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import testserenity.ui.SearchBox;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisitedCustomer implements Task {

    public int adults;
    public int child;
    public int room;
    public Target guestContainer;

    public VisitedCustomer(int adults, int child, int room, Target guestContainer) {
        this.adults = adults;
        this.child = child;
        this.room = room;
        this.guestContainer = guestContainer;
    }

    @Step("#actor books #room rooms for #adults adults and #child childrents")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(this.guestContainer)
        );
        for (int i = 0; i < this.adults - 2; i++) {
            actor.attemptsTo(
                    Click.on(SearchBox.ADD_ADULTS)
            );
        }
        for (int i = 0; i < this.child; i++) {
            actor.attemptsTo(
                    Click.on(SearchBox.ADD_CHILD)
                    );
        }
        for (int i = 0; i < this.child - 1; i++) {
            actor.attemptsTo(
                    Click.on(SearchBox.ADD_ROOM)
            );
        }
    }

    public static VisitedCustomerBuilder adults(int number) {
        return new VisitedCustomerBuilder(number);
    }

    public static class VisitedCustomerBuilder {
        public int adults;
        public int child;
        public int room;

        public VisitedCustomerBuilder(int adults) {
            this.adults = adults;
        }

        public VisitedCustomerBuilder child(int child) {
            this.child = child;
            return this;
        }

        public VisitedCustomerBuilder room(int room) {
            this.room = room;
            return this;
        }

        public VisitedCustomer on(Target guestContainer) {
            return instrumented(VisitedCustomer.class, this.adults, this.child, this.room, guestContainer);
        }
    }
}
