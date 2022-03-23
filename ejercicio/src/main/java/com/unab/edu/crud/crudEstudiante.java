package com.unab.edu.crud;

import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.DAO.ClsPersona;
import com.unab.edu.DAO.ClsPersonaEstudiante;
import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.Entidades.Persona;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class crudEstudiante extends javax.swing.JFrame {

    String valueMember[];
    int contador = 1;

    void DisplayMember() {
        DefaultComboBoxModel cbdefault = new DefaultComboBoxModel();
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        valueMember = new String[Personas.size() + 1];
        String filas[] = new String[3];
        cbdefault.addElement("");
        for (var iterador : Personas) {
            filas[0] = String.valueOf(iterador.getIdPersona());
            filas[1] = iterador.getNombre();
            valueMember[contador] = filas[0];
            cbdefault.addElement(filas[1]);
            contador++;
        }
        cbPersonas.setModel(cbdefault);
    }

    public crudEstudiante() {
        initComponents();
        MostrarTablaEstudiante();
//        MostrarDatos();
        DisplayMember();

    }

    void MostrarTablaEstudiante() {
        String Titulos[] = {"IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE PERSONA", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel df = new DefaultTableModel(null, Titulos);
        ClsPersonaEstudiante ClsJoinPE = new ClsPersonaEstudiante();
        var MostrarJoinEstudiantePersona = ClsJoinPE.MostrarJoinEstudiantePersona();
        String filas[] = new String[8];

        for (var iterador : MostrarJoinEstudiantePersona) {
            filas[0] = String.valueOf(iterador.getId());
            filas[1] = String.valueOf(iterador.getMatricula());
            filas[2] = String.valueOf(iterador.getIdPersona());
            filas[3] = iterador.getNombre();
            filas[4] = iterador.getUsu();
            filas[5] = iterador.getPass();
            filas[6] = String.valueOf(iterador.getNie());
            df.addRow(filas);
        }
        tbEstudiante.setModel(df);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMostrarDatos = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtNIE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbPersonas = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEstudiante);

        tbMostrarDatos.addTab("Vista de Datos", jScrollPane1);

        jLabel1.setText("ID Estudiante");

        jLabel2.setText("Matricula");

        jLabel3.setText("ID");

        jLabel4.setText("Usuario");

        jLabel5.setText("Password");

        jLabel6.setText("NIE");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cbPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonasActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(117, 117, 117)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(txtPassword)
                        .addComponent(txtNIE)
                        .addComponent(jLabel3)
                        .addComponent(txtUsuario)
                        .addComponent(txtID)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(cbPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(103, 103, 103)
                .addComponent(btnEliminar)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        tbMostrarDatos.addTab("Datos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMostrarDatos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            ClsPersonaEstudiante Estudiantes = new ClsPersonaEstudiante();
            Estudiante Estudiante = new Estudiante();
            Estudiante.setId(Integer.parseInt(valueMember[cbPersonas.getSelectedIndex()]));
            Estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
            Estudiante.setUsu(txtUsuario.getText());
            Estudiante.setPass(txtPassword.getText());
            Estudiante.setNie(Integer.parseInt(txtNIE.getText()));
            Estudiantes.AgregarEstudiantes(Estudiante);
            if (txtID.getText().isEmpty()) {
                Estudiantes.AgregarEstudiantes(Estudiante);
            } else {
                Estudiante.setId(Integer.parseInt(txtID.getText()));
                Estudiantes.ActualizarEstudiantes(Estudiante);
            }
            MostrarTablaEstudiante();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, verifique los datos");
        }
        btnNuevo.doClick();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            ClsPersonaEstudiante Estudiantes = new ClsPersonaEstudiante();
            Estudiante Estudiante = new Estudiante();
            Estudiantes.BorrarEstudiante(Estudiante);
            MostrarTablaEstudiante();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, verifique los datos");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tbEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstudianteMouseClicked
        tbMostrarDatos.setSelectedIndex(tbMostrarDatos.indexOfComponent(jPanel1));
        int fila = tbEstudiante.getSelectedRow();
        String ID = String.valueOf(tbEstudiante.getValueAt(fila, 0));
        String matricula = String.valueOf(tbEstudiante.getValueAt(fila, 1));
        String IdPersona = String.valueOf(tbEstudiante.getValueAt(fila, 2));
        String nombre = String.valueOf(tbEstudiante.getValueAt(fila, 3));
        String usuario = String.valueOf(tbEstudiante.getValueAt(fila, 4));
        String pass = String.valueOf(tbEstudiante.getValueAt(fila, 5));
        String nie = String.valueOf(tbEstudiante.getValueAt(fila, 6));

        txtMatricula.setText(matricula);
        txtID.setText(IdPersona);
        txtUsuario.setText(usuario);
        txtPassword.setText(pass);
        txtNIE.setText(nie);

        int seleccionadordeVista = 0;
        for (var it : valueMember) {

            if (IdPersona.equals(it)) {
                cbPersonas.setSelectedIndex(seleccionadordeVista);
            }
            seleccionadordeVista += 1;
        }
    }//GEN-LAST:event_tbEstudianteMouseClicked

    private void cbPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPersonasActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtID.setText("");
        cbPersonas.setSelectedIndex(0);
        txtMatricula.setText("");
        txtNIE.setText("");
        txtPassword.setText("");
        txtUsuario.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEstudiante;
    private javax.swing.JTabbedPane tbMostrarDatos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNIE;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
