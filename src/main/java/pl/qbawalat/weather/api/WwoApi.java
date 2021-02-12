package pl.qbawalat.weather.api;

import java.io.InputStream;
import java.net.URL;

public class WwoApi {
    //These keys are only for Demo purpose.
    //You should replace the key with your own key.
    //You can obtain your own key after registering on World Weather Online website.
    private static final String FREE_API_KEY = "e4561ecc74254973981164247211801";
    public final boolean LOGD = true;
    public String key;
    public String apiEndPoint;

    public WwoApi() {
        key = FREE_API_KEY;
    }

    public InputStream getInputStream(String url) {
        InputStream is = null;

        try {
            is = (new URL(url)).openConnection().getInputStream();
        } catch (Exception e) {
//            System.out.println(e);
        }

        return is;
    }

    WwoApi setKey(String key) {
        this.key = key;
        return this;
    }

    WwoApi setApiEndPoint(String apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
        return this;
    }


}