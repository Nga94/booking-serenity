package testserenity.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Authenticate implements Ability {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Authenticate(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Authenticate LoadTestData(String actorName) {
        try {
            Reader dataReader = new FileReader("C:\\Users\\Ga WBC\\Desktop\\testserenity\\src\\test\\resources\\testdata\\user." +actorName.toLowerCase() +".properties");
            Properties data = new Properties();
            data.load(dataReader);
            String email = data.getProperty("email");
            String password = data.getProperty("password");
            return new Authenticate(email, password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Authenticate("","");
    }

    public static Authenticate as(Actor actor) {
        if(actor.abilityTo(Authenticate.class)==null){
            throw new ExceptionInInitializerError(
                    actor.getName() + "ko co quyen");
        }
        else {
            return actor.abilityTo(Authenticate.class);
        }
    }
}
