package example.com.svmandroidtest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    JokeData mJokeData;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        callJoke();
    }

    public void initUI(){
        mRecyclerView = findViewById(R.id.RecyclerView);
        mSwipeRefreshLayout = findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                callJoke();
            }
        });
    }

    public void callJoke(){
        Call<JokeData> responseRetrofitCall = RetrofitInstance.getInstance().getService().callJoke();
        responseRetrofitCall.enqueue(new Callback<JokeData>() {
            @Override
            public void onResponse(Call<JokeData> call, retrofit2.Response<JokeData> response) {
                mJokeData = response.body();
                initRecyclerView();
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<JokeData> call, Throwable t) {
                Log.e(TAG, "Err : " + t.getMessage());
            }
        });
    }

    public void initRecyclerView(){
        mLinearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new Adapter(mJokeData.jokes);
        mRecyclerView.setAdapter(mAdapter);
    }
}
