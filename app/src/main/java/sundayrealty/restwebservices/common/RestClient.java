package sundayrealty.restwebservices.common;


import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private static Restapi REST_CLIENT;
    private static String ROOT =
            "your_URL/dumy.asmx";


    static {
        setupRestClient();
    }

    public static Restapi get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ROOT)
                .setClient(new OkClient(new OkHttpClient()))
                .setRequestInterceptor(new SessionRequestInterceptor())
                .setConverter(new LenientGsonConverter(new Gson()))
                .build();

        REST_CLIENT = restAdapter.create(Restapi.class);
    }
}
