package com.example.myapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.adapters.PostAdapter;
import com.example.myapp.clases.Posts;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rvUsPass;
    private ArrayList<Posts> posts ;
    public final int touch =1;
    PostAdapter postAdapter;
    MaterialButton add;


    //Para comunicarme con el activity
    OnHeadlineSelectedListener callback;
    public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }


    public HomeFragment() {
    }

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vist= inflater.inflate(R.layout.fragment_home,container,false);
        posts = new ArrayList<>();
        rvUsPass = vist.findViewById(R.id.rView);
        rvUsPass.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        fillList();

        postAdapter = new PostAdapter(getContext(),posts);
        rvUsPass.setAdapter(postAdapter);



        add = (MaterialButton) vist.findViewById(R.id.ADD);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeAddFragment fr=new HomeAddFragment();
                //fr.setArguments(bn);
                //mando lo que necesito al activity
                callback.onArticleSelected(touch);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor,fr)
                        .addToBackStack(null)
                        .commit();
                
            }
        });


        return vist;
    }

    private void fillList() {
        posts.add(new Posts("Gabi",R.drawable.rasta,"Este es el primer Post","1",true,R.drawable.mario));
        posts.add(new Posts("Ramos",R.drawable.rasta,"Este es el segundo Post","1",true,R.drawable.mario));
        posts.add(new Posts("Nixon",R.drawable.rasta,"Este es el tercer Post","1",true,R.drawable.mario));
        posts.add(new Posts("Dueñas",R.drawable.rasta,"Este es el cuarto Post","1",true,R.drawable.mario));
        posts.add(new Posts("Nix",R.drawable.rasta,"Este es el quinto Post","1",true,R.drawable.mario));
    }


}
