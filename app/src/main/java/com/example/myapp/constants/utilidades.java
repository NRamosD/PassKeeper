package com.example.myapp.constants;

public class utilidades {

    //constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String Cam_ID="id";
    public static final String Cam_NOMBRE="nombre";
    public static final String Cam_APELLIDO="apellido";
    public static final String Cam_CORREO="correo";
    public static final String Cam_BORN="born";
    public static final String Cam_PASS="pass";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+"("+Cam_ID+" INTEGER," +
            " "+Cam_NOMBRE+" TEXT, "+Cam_APELLIDO+" TEXT, "+Cam_CORREO+" TEXT, "+Cam_BORN+" TEXT, "+Cam_PASS+" TEXT)";
}
