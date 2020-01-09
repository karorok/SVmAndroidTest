package example.com.svmandroidtest;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance instance = new RetrofitInstance();

    private  Retrofit
    retrofit = new Retrofit.Builder()
            .baseUrl("http://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setLenient()
                    .create()))
            .build();
    private RetrofitInstance(){

    }

    public static RetrofitInstance getInstance(){
        return instance;
    }

    Service service = retrofit.create(Service.class);

    public Service getService(){
        return service;
    }

}
