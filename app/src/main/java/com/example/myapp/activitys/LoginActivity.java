package com.example.myapp.activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import com.example.myapp.R;
import com.example.myapp.clases.Usuarios;
import com.example.myapp.constants.utilidades;
import com.example.myapp.database.ConexionSQLite;
import com.example.myapp.database.dataBCorta;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user,contrasena;
    ImageView imageView_statejoin;
    Button button_in;
    TextView regis;
    dataBCorta verificador;
    //ConexionSQLite conec;


   @Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       user = (EditText) findViewById(R.id.nombreUser);
       contrasena = (EditText) findViewById(R.id.contraUser);
       imageView_statejoin= (ImageView) findViewById(R.id.statejoin);
       button_in=(Button) findViewById(R.id.start);
       regis=(TextView)findViewById(R.id.register);

       verificador = new dataBCorta(this);
       //conec= new ConexionSQLite(getApplicationContext(),"usuarios_db",null,1);

       button_in.setOnClickListener(this);

       regis.setOnClickListener(this);
   }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.start:
                String u= user.getText().toString();
                String p= contrasena.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "Llene los campos para continuar.",Toast.LENGTH_LONG).show();
                }else if(verificador.login(u,p)==1){
                    Usuarios ux= verificador.getUsuario(u,p);
                    i = new Intent(v.getContext(), MainActivity.class);
                    i.putExtra("Id",ux.getId());
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrecta.",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.register:
                i=new Intent(v.getContext(), RegisterActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}



