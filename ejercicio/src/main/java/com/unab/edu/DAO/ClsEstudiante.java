package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.ConexionBd.conexionBd;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ClsEstudiante {

    conexionBd cn = new conexionBd();
    Connection con = cn.RetornarConexion();

    public boolean LoguinEstudiante(String usuario, String Pass) {
        ArrayList<Estudiante> ListaUsuarios = new ArrayList<>();
        ArrayList<Estudiante> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = con.prepareCall("call SP_S_LOGUIESTUDIANTE(?,?)");

            st.setString("pusuario", usuario);
            st.setString("ppass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(rs.getNString("USU"));
                es.setPass(rs.getNString("PASS"));
                ListaUsuarios.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsu();
                passdebasededatos = iterador.getPass();

            }

            if (usuariodebasedatos != null && passdebasededatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                    return true;
                }
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
     public void ActualizarPersonas(Estudiante est) {
       try {
            CallableStatement Statement = con.prepareCall("call SP_U_Estudiante(?,?,?,?,?)");
            Statement.setInt("EIdEstudiante", est.getId());
            Statement.setInt("EMatricula", est.getMatricula());
            Statement.setString("EUsuario", est.getUsu());
            Statement.setString("EPassword", est.getPass());
            Statement.setInt("ENie", est.getNie());
            Statement.execute();
            con.close();;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
