package sundayrealty.restwebservices.common;


import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountPojo;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountResponse;

public interface Restapi {
    @POST("/{method_name}")
    void login(@Path("method_name") String method_name, @Body AgentContactCountPojo loginPojo,
               RestCallback<AgentContactCountResponse> callback);


}
