package testserenity.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import testserenity.common.Utility;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class Verification implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        Properties mail = new Properties();
        mail.put("mail.pop3.host", "pop.gmail.com");
        mail.put("mail.pop3.port", "995");
        mail.put("mail.pop3.starttls.enable", "true");

        Session emailSession = Session.getDefaultInstance(mail);
        try {
            Store store = emailSession.getStore("pop3s");
            store.connect("pop.gmail.com", "nganguyen.nuce@gmail.com", "a@conga13029494");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();

            return Utility.getTextFromMessage(messages[messages.length-1]);

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Question<String> OTPFromEmail()
    {
        return new Verification();
    }
}
