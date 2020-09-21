package com.example.myapp.activitys;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.clases.Usuarios;
import com.example.myapp.constants.utilidades;
import com.example.myapp.database.ConexionSQLite;
import com.example.myapp.database.dataBCorta;

import java.util.Calendar;
import java.util.Random;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Elementos
    LinearLayout car_registro;
    TextView tvdate;
    ImageView back;
    EditText name,lastname, email,pass1, pass2,user;
    Button registrarse;
    DatePickerDialog.OnDateSetListener setListener;
    dataBCorta db;


    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_register);


        tvdate=(TextView) findViewById(R.id.date_born);
        name=(EditText)findViewById(R.id.name);
        lastname=(EditText)findViewById(R.id.lastname);
        user= (EditText)findViewById(R.id.usuario);
        email=(EditText)findViewById(R.id.email);
        pass1=(EditText)findViewById(R.id.pass1);
        pass2=(EditText)findViewById(R.id.pass2);

        registrarse=findViewById(R.id.startregis);
        back=findViewById(R.id.back);



        registrarse.setOnClickListener(this);
        back.setOnClickListener(this);
        db= new dataBCorta(this);


        //base de datos
        //ConexionSQLite conect = new ConexionSQLite(this,"usuarios_db",null,1);


        //Fecha
        Calendar C= Calendar.getInstance();
        final int vDay=C.get(Calendar.DAY_OF_MONTH);
        final int vMonth=C.get(Calendar.MONTH);
        final int vYear=C.get(Calendar.YEAR);

        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,vYear,vMonth,vDay);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date= dayOfMonth+"/"+month+"/"+year;
                tvdate.setText(date);

            }
        };

        //Fecha Para editText, mostrando calendario
/*
        editText.setOnclickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        String date= vDay+"/"+vMonth+"/"+vYear;
                        editText.setText(date);
                    }
                },vYear,vMonth,vDay);
                datePickerDialog.show();

            }
        });
*/


    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.startregis:

                Usuarios u = new Usuarios();
                u.setUsuario(user.getText().toString());
                u.setNombre(name.getText().toString());
                u.setApellido(lastname.getText().toString());
                u.setCorreo(email.getText().toString());
                u.setBorn(tvdate.getText().toString());
                u.setPass(pass1.getText().toString());

                //falta hacer que las dos contraseñas sean iguales
                String p1=pass1.getText().toString();
                String p2=pass2.getText().toString();

                if(u.isNull()){
                    Toast.makeText(this,"Campos Vacíos",Toast.LENGTH_SHORT).show();
                }else if(!passIguales(p1,p2)){
                    Toast.makeText(this,"Las contraseñas son distintas.",Toast.LENGTH_SHORT).show();
                }
                else if(db.insertarUsuario(u)){
                    Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                    i = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.back:
                i = new Intent(v.getContext(), LoginActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.terms_register:
                break;
        }


    }

    private boolean passIguales(String p1, String p2) {
        if(p1.equals(p2)){
            return true;
        }else{
            return false;
        }
    }

    /*
    private void esperando(int tiempo,final View v) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        },tiempo);

    }


    //Funciones de validación
    private boolean pass(){
        boolean res;
        if(info[4].equals(ps2)){
            res=true;
        }else{
            res=false;
        }

        return res;
    }


    private boolean datoscompletos() {
        boolean res=true;
        int i=0;
        while(i<info.length){
            if(info[i].length()==0){
                i=6;
                res=false;
            }else {
                i++;
            }
        }
        return res;
    }*/

    //ConexionSQLite
    /*private void registrarUsuarios(){
        ConexionSQLite conect = new ConexionSQLite(this,"usuarios_db",null,1);
        SQLiteDatabase db = conect.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(utilidades.Cam_ID,random.toString());
        values.put(utilidades.Cam_NOMBRE,name.getText().toString());
        values.put(utilidades.Cam_APELLIDO,lastname.getText().toString());
        values.put(utilidades.Cam_CORREO,email.getText().toString());
        values.put(utilidades.Cam_BORN,tvdate.getText().toString());
        values.put(utilidades.Cam_PASS,pass1.getText().toString());

        //insertando los datos
        Long idResultante = db.insert(utilidades.TABLA_USUARIO,utilidades.Cam_ID,values);
        Toast.makeText(getApplicationContext(),"Id registro: "+idResultante,Toast.LENGTH_LONG).show();
        db.close();

    }*/

    /*private void registrarUsuarioSql() {
        ConexionSQLite conect = new ConexionSQLite(this,"usuarios_db",null,1);
        SQLiteDatabase db = conect.getWritableDatabase();

        String insert="INSERT INTO "+utilidades.TABLA_USUARIO
                +" ( "
                +utilidades.Cam_ID+","+utilidades.Cam_NOMBRE+","+utilidades.Cam_APELLIDO+","+utilidades.Cam_CORREO+","
                +utilidades.Cam_BORN+","+utilidades.Cam_PASS+")"+
                "VALUES('"+random.toString()+"','"+name.getText().toString()+"','"+lastname.getText().toString()+"','"+email.getText().toString()+
                "','"+tvdate.getText().toString()+"','"+pass1.getText().toString()+"')";

        db.execSQL(insert);
        db.close();
    }*/


    /*tvdate=(TextView) findViewById(R.id.date_born);
    name=(EditText)findViewById(R.id.name);
    lastname=(EditText)findViewById(R.id.lastname);
    email=(EditText)findViewById(R.id.email);
    pass1=(EditText)findViewById(R.id.pass1);
    pass2=(EditText)findViewById(R.id.pass2);*/
}
