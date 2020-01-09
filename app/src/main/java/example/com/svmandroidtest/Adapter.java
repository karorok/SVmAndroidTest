package example.com.svmandroidtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Joke> jokes;

    public Adapter(ArrayList<Joke> jokes) {
        this.jokes = jokes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.joke_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Joke joke = jokes.get(position);
        holder.id.setText(joke.id);
        holder.joke.setText(joke.joke);
        if(joke.categories.size() == 0){
            holder.category.setText("none");
        }else{
            holder.category.setText(joke.categories.get(0));
        }
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView joke;
        public TextView category;


        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.Joke_id);
            joke = (TextView) itemView.findViewById(R.id.Joke_joke);
            category = (TextView) itemView.findViewById(R.id.Joke_category);
        }

    }
}
