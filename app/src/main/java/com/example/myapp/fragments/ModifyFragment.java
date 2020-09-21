package com.example.myapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapp.R;
import com.example.myapp.activitys.LoginActivity;
import com.example.myapp.activitys.menu_top.SettingActivity;
import com.example.myapp.clases.Usuarios;
import com.example.myapp.database.dataBCorta;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.zip.Inflater;

public class ModifyFragment extends Fragment implements View.OnClickListener  {

    int id;

    TextView usuario;
    TextInputEditText edNombre,edApellido,edCorreo,edContrasena,edBorn;
    MaterialButton edActualizar;
    ImageView atras;

    dataBCorta db;
    //OnDataPass dataPasser;

    //private String nombre,apellido,correo,pass,nacimiento;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_modify, container, false);

        edNombre=v.findViewById(R.id.edNombre);
        edApellido=v.findViewById(R.id.edApellido);
        edCorreo=v.findViewById(R.id.edCorreo);
        edBorn=v.findViewById(R.id.edNacimiento);
        edContrasena=v.findViewById(R.id.edContrasena);
        edActualizar=v.findViewById(R.id.edGuardar);
        usuario=v.findViewById(R.id.Usuario);

        SettingActivity Setting_Activity = (SettingActivity) getActivity();

        edNombre.setText(Setting_Activity.getNombre());
        edNombre.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
        edApellido.setText(Setting_Activity.getApellido());
        edApellido.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
        edContrasena.setText(Setting_Activity.getPass());
        edContrasena.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
        edCorreo.setText(Setting_Activity.getCorreo());
        edCorreo.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);
        usuario.setText(Setting_Activity.getUsuario());
        edBorn.setEnabled(false);
        edBorn.setTextAlignment(v.TEXT_ALIGNMENT_CENTER);

        //edBorn.setText(S_Activity.getNacimiento());

        edActualizar.setOnClickListener(this);




        return v;

    }

    public void onViewCreated(@NonNull View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edGuardar:

                ((SettingActivity) getActivity()).ActualizarDatos(edNombre.getText().toString(),edApellido.getText().toString(),
                        edBorn.getText().toString(),edCorreo.getText().toString(),edContrasena.getText().toString());
                ((SettingActivity) getActivity()).finish();
                break;

            default:
                break;
        }
    }




/*
    public interface OnDataPass {
        public void onDataPass(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }
    public void passData(String data) {
        dataPasser.onDataPass(data);
    }*/

    //Comunicación entre

}
