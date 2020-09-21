package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapp.R;
import com.google.android.material.button.MaterialButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingFragment extends Fragment{

    CircleImageView fotoPerfil;
    TextView name;
    MaterialButton modificar, eliminar;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_setting, container, false);

        view.findViewById(R.id.modificar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SettingFragment.this)
                        .navigate(R.id.action_Setting_to_Modify);
            }
        });

        view.findViewById(R.id.Eliminar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SettingFragment.this)
                        .navigate(R.id.action_Setting_to_Delete);
            }
        });

        return view;
    }

    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fotoPerfil=view.findViewById(R.id.profileImage);
        name=view.findViewById(R.id.nombreApellido);
        modificar=view.findViewById(R.id.modificar);
        eliminar=view.findViewById(R.id.Eliminar);



        //eliminar.setOnClickListener(this);
        //modificar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.modificar:
                NavHostFragment.findNavController(SettingFragment.this)
                        .navigate(R.id.action_Setting_to_Modify);
                break;
            case R.id.Eliminar:
                NavHostFragment.findNavController(SettingFragment.this)
                        .navigate(R.id.action_Setting_to_Delete);
                break;
            default:
                break;
        }
    }*/
}
