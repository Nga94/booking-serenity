package testserenity.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target LANGUAGE = Target.the("language").located(By.cssSelector("a[aria-controls=\"language_selector_popover\"]"));
    public static Target CHOOSE_LANG = Target.the("choose lang").locatedBy("//a[@hreflang=\"en-gb\"]");
    public static Target SEARCH_FIELD = Target.the("search field").located(By.cssSelector("input[type=\"search\""));
    public static Target SUGGESTION_RESULT = Target.the("suggestion").locatedBy("(//ul[@role=\"listbox\"]//li)[1]");
    public static Target CALENDAR = Target.the("calendar").located(By.cssSelector("(div.xp__dates-inner)[1]"));
    public static Target LIST_RESULT = Target.the("list result").located(By.cssSelector("div.sr_card_address_line a"));
    public static Target BTN_SEARCH = Target.the("button search").located(By.className("sb-searchbox__button"));
    public static Target GUEST_CONTAINER = Target.the("customer container").located(By.id("xp__guests__toggle"));
    public static Target ADD_ADULTS = Target.the("add adults").located(By.cssSelector("div.sb-group__field-adults button.bui-stepper__add-button"));
    public static Target ADD_CHILD = Target.the("add child").located(By.cssSelector("div.sb-group-children button.bui-stepper__add-button"));
    public static Target ADD_ROOM = Target.the("add room").located(By.cssSelector("div.sb-group__field-rooms button.bui-stepper__add-button"));
}

