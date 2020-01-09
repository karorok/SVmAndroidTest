package example.com.svmandroidtest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Joke {
    @SerializedName("id")
    String id;

    @SerializedName("joke")
    String joke;

    @SerializedName("categories")
    ArrayList<String> categories;
}
