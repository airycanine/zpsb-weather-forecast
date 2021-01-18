package pl.qbawalat.weather;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLEncoder;

class WwoApi {
    static final boolean LOGD = true;

    //These keys are only for Demo purpose.
    //You should replace the key with your own key.
    //You can obtain your own key after registering on World Weather Online website.
    private static final String FREE_API_KEY = "e4561ecc74254973981164247211801";
    public String key;
    String apiEndPoint;

    WwoApi() {
        key = FREE_API_KEY;
    }

    static InputStream getInputStream(String url) {
        InputStream is = null;

        try {
            is = (new URL(url)).openConnection().getInputStream();
        } catch (Exception e) {

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

    class RootParams {
        public String getQueryString(Class cls) {
            String query = null;

            Field[] fields = cls.getDeclaredFields();

            try {
                for (Field field : fields) {
                    Object f = field.get(this);
                    if (f != null) {
                        if (query == null)
                            query = "?" + URLEncoder.encode(field.getName(),
                                                            "UTF-8") + "=" + URLEncoder.encode((String) f, "UTF-8");
                        else
                            query += "&" + URLEncoder.encode(field.getName(),
                                                             "UTF-8") + "=" + URLEncoder.encode((String) f, "UTF-8");
                    }
                }
            } catch (Exception e) {

            }

            return query;
        }
    }
}