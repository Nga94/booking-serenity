package testserenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import testserenity.ui.SearchBox;

import java.util.List;

public class ListOfResultQuestion implements Question<List<String>> {

    public static ListOfResultQuestion displayed() {
        return new ListOfResultQuestion();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(SearchBox.LIST_RESULT).viewedBy(actor).asList();
    }
}
