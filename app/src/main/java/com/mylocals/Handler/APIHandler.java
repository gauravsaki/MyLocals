package com.mylocals.Handler;

import com.mylocals.constants.Constants;
import com.mylocals.entities.HttpResponse;
import com.mylocals.entities.User;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by hp on 14/11/2016.
 */
public class APIHandler {
    private static APIHandler apiHandler = new APIHandler();

    public synchronized static APIHandler getInstance() {
        if(apiHandler!=null) {
            return apiHandler;
        }else
        {
            return new APIHandler();
        }

    }

    public void createUser(User user, Callback<ResponseBody> callbackInterface){
        APIInterface apiInterface = getRetrofitObject();
        Call<ResponseBody> call =apiInterface.registerUser(user);
        // Asynchronously execute HTTP request
        call.enqueue(callbackInterface);

    }

    public void getCityAndState(Callback<HttpResponse> callbackInterface){
        APIInterface apiInterface = getRetrofitObject();
        Call<HttpResponse> call =apiInterface.getCityAndState();
        // Asynchronously execute HTTP request
        call.enqueue(callbackInterface);

    }

    public void getRestaurantDetailsByLatLong(String lat,String lon,Callback<ResponseBody> callbackInterface){
        APIInterface apiInterface = getRetrofitObject();
        String dynamicURL = Constants.GET_RESTAURANT_DETAILS+lat+"/and/"+lon+"/";
        Call<ResponseBody> call =apiInterface.getRestaurantDetails(dynamicURL);
        // Asynchronously execute HTTP request
        call.enqueue(callbackInterface);

    }


    private APIInterface getRetrofitObject(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIInterface.class);
    }

    private APIHandler() {
    }


}
