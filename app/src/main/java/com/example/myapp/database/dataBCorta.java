package com.example.myapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapp.clases.Usuarios;

import java.util.ArrayList;

public class dataBCorta {
    Context c;
    Usuarios u;
    ArrayList<Usuarios> lista;
    SQLiteDatabase sql;
    String baseDatos="BDUsuarios";
    String tabla="create table if not exists basedatosusuarios(id integer primary key autoincrement, usuario text, " +
            "nombre text, apellido text, correo text, born text, pass text)";

    public dataBCorta(Context c){
        this.c=c;
        sql = c.openOrCreateDatabase(baseDatos, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuarios();
    }

    public boolean insertarUsuario(Usuarios u){
        if(buscar(u.getUsuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("usuario",u.getUsuario());
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellido());
            cv.put("born",u.getBorn());
            cv.put("correo",u.getCorreo());
            cv.put("pass",u.getPass());
            return (sql.insert("basedatosusuarios",null, cv)>0);
        }else{
            //no se ingresó
            return false;
        }
    }

    public int buscar(String usu){
        int x=0;
        lista=selectUsuarios();
        for (Usuarios u:lista) {
            if(u.getUsuario().equals(u)){
                x=1;
            }
        }
        return x;
    }

    //retorna todos los usuarios que hay en la bd
    public ArrayList<Usuarios> selectUsuarios(){
        ArrayList<Usuarios>lista= new ArrayList<Usuarios>();

        Cursor cr= sql.rawQuery("select * from basedatosusuarios",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                Usuarios u= new Usuarios();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setNombre(cr.getString(2));
                u.setApellido(cr.getString(3));
                u.setCorreo(cr.getString(4));
                u.setBorn(cr.getString(5));
                u.setPass(cr.getString(6));
                lista.add(u);
            }while(cr.moveToNext());
        }

        return lista;
    }


    public int login(String u, String p){
        int a=0;

        Cursor cr= sql.rawQuery("select * from basedatosusuarios",null);
        if(cr!=null && cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u) && cr.getString(6).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());
        }
        return a;
    }

    public Usuarios getUsuario(String u, String p){
        lista=selectUsuarios();
        for (Usuarios usu:lista) {
            if(usu.getUsuario().equals(u) && usu.getPass().equals(p)){
                return usu;
            }
        }
        return null;
    }


    public Usuarios getUsuarioID(int id){
        lista=selectUsuarios();
        for (Usuarios usu:lista) {
            if(usu.getId()==id){
                return usu;
            }
        }
        return null;
    }

    public boolean UpdateUsuario(Usuarios u){
        ContentValues cv=new ContentValues();
        cv.put("usuario",u.getUsuario());
        cv.put("nombre",u.getNombre());
        cv.put("apellido",u.getApellido());
        cv.put("born",u.getBorn());
        cv.put("correo",u.getCorreo());
        cv.put("pass",u.getPass());
        return (sql.update("basedatosusuarios",cv,"id="+u.getId(),null)>0);

    }



}
