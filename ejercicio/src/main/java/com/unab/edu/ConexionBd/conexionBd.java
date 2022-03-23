package com.unab.edu.ConexionBd;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBd {
   static String bd = "clase1";
   static String login = "root";
   static String pass = "root";
   static String url = "jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC";
   Connection conexion =null; 
    public conexionBd(){
    
        try {
            conexion = DriverManager.getConnection(url, login, pass);
            
            System.out.println("Conectado a la Bd");
        } catch (Exception e) {
            System.out.println("Error de conexion"+e);
        }
    }
    public Connection RetornarConexion(){
    return conexion;
    }

}
