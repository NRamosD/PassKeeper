package com.example.myapp.clases;

public class Usuarios {

    private Integer id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private String born;
    private String pass;

    @Override
    public String toString() {
        return "usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", born='" + born + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public Usuarios() {

    }

    public Usuarios(String nombre, String apellido, String usuario, String correo, String born, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.born = born;
        this.pass = pass;
    }

    public boolean isNull(){
        if(nombre.equals("") || usuario.equals("") || apellido.equals("") || correo.equals("") || born.equals("") || pass.equals("")){
            return true;
        }else{
            return false;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
