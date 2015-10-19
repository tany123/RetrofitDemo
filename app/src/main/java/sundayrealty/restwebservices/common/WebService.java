package sundayrealty.restwebservices.common;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import retrofit.client.Response;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountPojo;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountResponse;

public class WebService extends AsyncTask<String, Void, String> {

    ServiceListner listener = null;
    Object pojo;
    Context context;
    MethodsEnum methodsEnum;

    public WebService(Object pojo, Context context, MethodsEnum methodsEnum,
                      ServiceListner listner) {
        // super();
        this.context = context;
        this.pojo = pojo;
        this.listener = listner;
        this.methodsEnum = methodsEnum;
    }

    @Override
    protected String doInBackground(String... arg0) {
        switch (methodsEnum) {
            case AgentContactCount:
                login();
                break;
        }
        return null;
    }


    private void login() {
        RestClient.get().login(MethodsEnum.AgentContactCount.getMethodName(), (AgentContactCountPojo) pojo,
                new RestCallback<AgentContactCountResponse>() {
                    @Override
                    public void success(AgentContactCountResponse loginResponse, Response response) {
                        // success!
                        listener.onResponse(loginResponse, ResponseTypeEnum.SUCCESS);
                    }

                    @Override
                    public void failure(RestError error) {
                        // something went wrong
                        Log.e("There are some problem", error.toString());
                        listener.onResponse(error, ResponseTypeEnum.ERROR);
                    }
                });
    }


}
