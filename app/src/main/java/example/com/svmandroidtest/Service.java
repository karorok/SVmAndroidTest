package example.com.svmandroidtest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("jokes/random/20")
    Call<JokeData> callJoke();
}
