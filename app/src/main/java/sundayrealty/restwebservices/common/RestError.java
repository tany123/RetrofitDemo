package sundayrealty.restwebservices.common;

import lombok.Data;
import lombok.ToString;

// This is class should be modified as your server's error response

@Data
@ToString
public class RestError {
    public Integer errorCode;
    public String extendedMessage;
    public String message;
    public String moreInfo;
    public Integer status;

    public RestError() {
    }

    public RestError(String message) {
        this.message = message;
    }

    /*public String toJSON() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("errorCode", errorCode);
            jsonObject.put("extendedMessage", extendedMessage);
            jsonObject.put("message", message);
            jsonObject.put("moreInfo", moreInfo);
            jsonObject.put("status", status);

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }*/
}