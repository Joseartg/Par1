package com.unab.edu.DAO;
import com.unab.edu.Entidades.Persona;
import com.unab.edu.ConexionBd.conexionBd;
import java.sql.CallableStatement;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ClsPersona {

    conexionBd claseConectar = new conexionBd();
    Connection conectar = claseConectar.RetornarConexion();

    public ArrayList<Persona> MostrarPersona() {
        ArrayList<Persona> Personas = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_Persona()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                persona.setSexo(resultadoDeConsulta.getString("Sexo"));
                persona.setFecha(resultadoDeConsulta.getDate("Fecha"));
                Personas.add(persona);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Personas;
    }

    public void AgregarPersonas(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_Persona(?,?,?,?,?)");
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.setDate("PFecha", new java.sql.Date(Per.getFecha().getTime()));
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BorrarPersona(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_Persona(?)");

            Statement.setInt("PIdPersonas", Per.getIdPersona());

            Statement.execute();
            JOptionPane.showMessageDialog(null, "Datos Eliminados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void ActualizarPersonas(Persona Persona) {
       try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_Persona(?,?,?,?,?)");
            Statement.setInt("PIdPersona", Persona.getIdPersona());
            Statement.setString("PNombre", Persona.getNombre());
            Statement.setString("PApellido", Persona.getApellido());
            Statement.setInt("Pedad", Persona.getEdad());
            Statement.setString("Psexo", Persona.getSexo());
            Statement.execute();
            conectar.close();;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
