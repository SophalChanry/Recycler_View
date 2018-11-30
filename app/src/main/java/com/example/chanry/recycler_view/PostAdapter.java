package com.example.chanry.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    List<Post> posts;
    Context context;
    public PostAdapter(Context context,List<Post> posts){
        this.posts=posts;
        this.context=context;
    }

    public void setPosts(List<Post> posts) {
        this.posts.addAll(posts) ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.post_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post=posts.get(i);
        viewHolder.imageProfile.setImageResource(post.getUserProfile());
        viewHolder.image.setImageResource(post.getImage());
        viewHolder.userName.setText(post.getUserName());
        viewHolder.content.setText(post.getContent());
        viewHolder.checkIn.setText(post.getCheckIn());

        viewHolder.onImageClick();
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageProfile,image,btnMenu,btnLike,btnComment,btnShare,btntelegram;
        TextView userName,content,checkIn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProfile=itemView.findViewById(R.id.image);
            image=itemView.findViewById(R.id.imageView);
            btnMenu=itemView.findViewById(R.id.btnmenu);
            btnLike=itemView.findViewById(R.id.like);
            btnComment=itemView.findViewById(R.id.command);
            btnShare=itemView.findViewById(R.id.share);
            btntelegram=itemView.findViewById(R.id.telegram);

            userName=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);
            checkIn=itemView.findViewById(R.id.text);
        }
        private void onImageClick(){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,MainActivity.class));
                }
            });
        }
    }
}
