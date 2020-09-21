package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.clases.Posts;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Posts> posts;

    public PostAdapter(Context c, ArrayList<Posts> posts1){
        context =c;
        posts =posts1;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.user.setText(posts.get(position).getNombre());
        holder.writting.setText(posts.get(position).getEscrito());
        holder.imgUser.setImageResource(posts.get(position).getFoto());
        holder.imgPost.setImageResource(posts.get(position).getFotoPost());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView user, writting;
        ImageView imgUser, imgPost;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            user=itemView.findViewById(R.id.nombreUserPost);
            writting=itemView.findViewById(R.id.writtingPost);
            imgUser=itemView.findViewById(R.id.userimgPost);
            imgPost=itemView.findViewById(R.id.imgPost);
        }
    }
}
