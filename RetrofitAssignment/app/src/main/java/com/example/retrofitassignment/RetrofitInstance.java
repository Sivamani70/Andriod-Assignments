package com.example.retrofitassignment;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class RetrofitInstance {
    final static String BaseURL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            return retrofit;
        }
        return retrofit;
    }


    public interface NetworkEndPoint {
        @GET("photos/")
        Call<String> getData();
    }
}
