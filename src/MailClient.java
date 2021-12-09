import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MailClient {

    public static void sendMail(String fromMail, String toMail, String message) throws IOException {
        String urlString = "https://timoschessl.com/mailserverAndroid.php?to="+toMail+"&from="+fromMail+"&message="+message+"";
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();

    }
}
