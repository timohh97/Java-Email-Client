import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateMail(String emailString)
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailString);
        return matcher.find();
    }
}
