package com.example.chanry.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new PostAdapter(this,postList);

        recyclerView.setAdapter(adapter);

        getData();
    }
    private void getData(){
        for(int i=0;i<50;i++){
            this.postList.add(new Post(
                    R.drawable.cat,"___Cat___","phnom penh","Text messaging is most often used between private mobile phone users, as a substitute for voice calls in situations.",
                    "100 11k",R.drawable.butterfly
            ));
        }
        adapter.setPosts(this.postList);
    }
}
