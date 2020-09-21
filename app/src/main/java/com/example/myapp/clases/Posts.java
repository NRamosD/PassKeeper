package com.example.myapp.clases;

public class Posts {
    private String nombre;
    private int fotoUsuario;
    private String escrito;
    private String key;
    private int fotoPost;
    private Boolean is_connected;

    public Posts(String nombre1, int fotoUsuario1, String escrito1, String key, Boolean is_connected,int fotoPost1) {
        this.nombre=nombre1;
        this.fotoUsuario=fotoUsuario1;
        this.escrito=escrito1;
        this.key = key;
        this.fotoPost=fotoPost1;
        this.is_connected = is_connected;
    }

    //conectado
    public Boolean getIs_connected() {
        return is_connected;
    }

    public void setIs_connected(Boolean is_connected) {
        this.is_connected = is_connected;
    }
    //clave Usuario
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    //nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //foto Usuario
    public int getFoto() {
        return fotoUsuario;
    }

    public void setFoto(int fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    //Escrito
    public String getEscrito() {
        return escrito;
    }

    public void setEscrito(String escrito) {
        this.escrito = escrito;
    }
    //foto Post
    public int getFotoPost() {
        return fotoPost;
    }

    public void setFotoPost(int fotoPost) {
        this.fotoPost = fotoPost;
    }

}
