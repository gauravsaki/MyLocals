package com.mylocals.Handler;

import com.mylocals.constants.Constants;
import com.mylocals.entities.HttpResponse;
import com.mylocals.entities.User;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Url;

/**
 * Created by hp on 14/11/2016.
 */
public interface APIInterface {


    @POST("/"+ Constants.CREATE_USER)
    Call<ResponseBody> registerUser(
            @Body User user
    );

    @GET("/"+Constants.GET_CITY_AND_STATE)
    Call<HttpResponse> getCityAndState();

    @GET
    Call<ResponseBody> getRestaurantDetails(@Url String url);


}
