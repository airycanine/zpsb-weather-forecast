package pl.qbawalat.weather.api;

import java.lang.reflect.Field;
import java.net.URLEncoder;

public class WorldWeatherOnlineApiRootParams {
    public String getQueryString(Class cls) {
        String query = null;

        Field[] fields = cls.getDeclaredFields();

        try {
            for (Field field : fields) {
                Object f = field.get(this);
                if (f != null) {
                    if (query == null)
                        query = "?" + URLEncoder.encode(field.getName(), "UTF-8") + "=" + URLEncoder.encode((String) f,
                                                                                                            "UTF-8");
                    else
                        query += "&" + URLEncoder.encode(field.getName(), "UTF-8") + "=" + URLEncoder.encode((String) f,
                                                                                                             "UTF-8");
                }
            }
        } catch (Exception e) {
//            System.out.println(e);
        }

        return query;
    }
}