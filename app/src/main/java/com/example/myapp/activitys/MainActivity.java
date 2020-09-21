package com.example.myapp.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.activitys.menu_top.SettingActivity;
import com.example.myapp.clases.Usuarios;
import com.example.myapp.database.dataBCorta;
import com.example.myapp.fragments.HomeAddFragment;
import com.example.myapp.fragments.HomeFragment;
import com.example.myapp.fragments.MiniappsFragment;
import com.example.myapp.fragments.OrganizadorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnHeadlineSelectedListener {

    int id=0;
    Usuarios u;
    dataBCorta dbCorta;

    String nom;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dbCorta=new dataBCorta(this);
        u=dbCorta.getUsuarioID(id);

        nom=u.getNombre();
        Toast.makeText(this,"El nombre: "+nom,Toast.LENGTH_LONG).show();

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNav);


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_page, new HomeFragment()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.inicio:
                        fragment = new HomeFragment();
                        break;
                    case R.id.organizate:
                        fragment = new OrganizadorFragment();
                        break;
                    case R.id.confi:
                        fragment =new MiniappsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_page,fragment).commit();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.action_settings:
                try{
                    i=new Intent(this, SettingActivity.class);
                    i.putExtra("Id",id);
                    startActivity(i);
                }catch (Exception e){
                    Log.e("Tag",e.getMessage());
                    Toast.makeText(this,"Algo salió mal:\n"+e,Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.action_logout:
                i=new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            //controlo la el backpress del fragment
            bottomNavigationView.setVisibility(View.VISIBLE);
            getSupportFragmentManager().popBackStack();
        }
        //super.onBackPressed();
    }


    @Override
    public void onArticleSelected(int touch) {
        bottomNavigationView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof HomeFragment) {
            HomeFragment homeFragment = (HomeFragment) fragment;
            homeFragment.setOnHeadlineSelectedListener(this);
        }

        //super.onAttachFragment(fragment);
    }
}
