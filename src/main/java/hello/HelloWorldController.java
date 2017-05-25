package hello;

import hello.model.WebhookRequest;
import hello.model.WebhookResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("StringBufferReplaceableByString")
@Controller
@RequestMapping("/webhook")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    WebhookResponse webhook(@RequestBody WebhookRequest obj) {
        System.out.println(obj);

//        https://content.googleapis.com/youtube/v3/search?part=snippet&q=Eminem%20Without%20Me&key=AIzaSyC-RqIOV5doIxA4y9P1l8hxYU2b_jJC6x0
        String youtubeResult = null;
        try {
            String youtubeSearch = new StringBuilder()
                    .append("https://content.googleapis.com/youtube/v3/search?")
                    .append("part=snippet")
                    .append("&").append("q=").append(obj.getResult().getParameters().get("q"))
                    .append("&").append("key=AIzaSyC-RqIOV5doIxA4y9P1l8hxYU2b_jJC6x0")
                    .toString();
            System.out.println();
            System.out.println(youtubeSearch);
            youtubeResult = getHTML(youtubeSearch);
            System.out.println();
            System.out.println(youtubeResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebhookResponse response = new WebhookResponse();
        response.setDisplayText(youtubeResult);
        response.setSpeech(youtubeResult);
        return response;
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
