package hello.model;

import java.util.HashMap;

public class WebhookResponse {
    private final String source = "media-webhook";
    private String speech;
    private String displayText;
    private HashMap<String, String> data;//"data": {"slack": slack_message, "facebook": facebook_message},

    public String getSource() {
        return source;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
//   "contextOut": [{"name":"weather", "lifespan":2, "parameters":{"city":"Rome"}}]


}
