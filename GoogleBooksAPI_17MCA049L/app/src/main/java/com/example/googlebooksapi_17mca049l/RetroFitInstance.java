package com.example.googlebooksapi_17mca049l;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class RetroFitInstance {

    final static String BaseURL = "https://www.googleapis.com/";
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
        @GET("books/v1/volumes?q=twostates")
        Call<String> getData();
    }
}
