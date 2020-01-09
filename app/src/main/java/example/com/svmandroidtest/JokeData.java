package example.com.svmandroidtest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JokeData {
    @SerializedName("type")
    String type;

    @SerializedName("value")
    ArrayList<Joke> jokes;
}
