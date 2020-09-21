package com.example.myapp.activitys.menu_top;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapp.clases.Usuarios;
import com.example.myapp.database.dataBCorta;
import com.example.myapp.fragments.ModifyFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {



    int id=0;
    Usuarios u;
    dataBCorta dbCorta;
    Intent x;
    //nom,ape,cor,pass,nac;
    private String nombre,apellido,correo,pass,nacimiento,usuario;
    //private String [] datos= new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dbCorta=new dataBCorta(this);
        u=dbCorta.getUsuarioID(id);

        nombre=u.getNombre();
        apellido=u.getApellido();
        correo=u.getCorreo();
        pass=u.getPass();
        nacimiento=u.getBorn();
        usuario=u.getUsuario();




    }


    //Getters de los datos
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }
    public String getPass(){
        return pass;
    }
    public String getNacimiento(){
        return nacimiento;
    }
    public String getUsuario(){return usuario;}


    /*public void onDataPass(String data) {
        Log.d("LOG","hello " + data);
        //Toast.makeText(this,"Pasó "+data,Toast.LENGTH_LONG).show();
    }*/

    public void ActualizarDatos(String actNombre,String actApe,String actNacim, String actCorreo,String actContra){

        u.setNombre(actNombre);
        u.setApellido(actApe);
        u.setCorreo(actCorreo);
        //u.setBorn(edBorn.getText().toString());
        u.setPass(actContra);

        if(u.isNull()){
            Toast.makeText(this,"Campos Vacíos",Toast.LENGTH_SHORT).show();
        }else if(dbCorta.UpdateUsuario(u)){

            Toast.makeText(this,"Modificación Exitosa "+u.getNombre(),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_SHORT).show();
        }

    }


}
