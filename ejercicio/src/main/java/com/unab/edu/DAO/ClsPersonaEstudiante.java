package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.ConexionBd.conexionBd;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsPersonaEstudiante {

    conexionBd cn = new conexionBd();
    Connection con = cn.RetornarConexion();

    public ArrayList<Estudiante> MostrarJoinEstudiantePersona() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("call SP_S_PEJoin()");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Estudiante es = new Estudiante();
                es.setId(rs.getInt("idestudiante"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNombre(rs.getString("nombre"));
                es.setUsu(rs.getString("USU"));
                es.setPass(rs.getString("PASS"));
                es.setNie(rs.getInt("NIE"));
                es.setIdPersona(rs.getInt("idpersona"));
                
                
                lista.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return lista;
    }
    
      public void AgregarEstudiantes(Estudiante Est) {
        try {
            CallableStatement Statement = con.prepareCall("call SP_I_Estudiante(?,?,?,?)");
            Statement.setInt("EMatricula", Est.getMatricula());
            Statement.setString("EUsuario", Est.getUsu());
            Statement.setString("EPassword", Est.getPass());
            Statement.setInt("ENie", Est.getNie());
            Statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
      
      public void BorrarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = con.prepareCall("call SP_D_Estudiante(?)");

            Statement.setInt("PIdPersonas", Est.getIdPersona());

            Statement.execute();
            JOptionPane.showMessageDialog(null, "Datos Eliminados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
      
      public void ActualizarEstudiantes(Estudiante Estudiante) {
       try {
            CallableStatement Statement = con.prepareCall("call SP_U_Estudiante(?,?,?,?,?)");
            Statement.setInt("EIdEstudiante", Estudiante.getId());
            Statement.setInt("EMatricula", Estudiante.getMatricula());
            Statement.setString("EUsuario", Estudiante.getUsu());
            Statement.setString("EPassword", Estudiante.getPass());
            Statement.setInt("ENie", Estudiante.getNie());
            Statement.execute();
            con.close();;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
