/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class verCitas extends javax.swing.JFrame {

    /**
     * Creates new form verCitas
     */
    private int idMed;
    
    public verCitas(int idMed) {
        initComponents();
        this.idMed = idMed;
    }

    private verCitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdMed(){
        return idMed;
    }
    
    public void setIdMed(int idMed){
        this.idMed = idMed;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCita = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        txtCita.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtCita.setText("Lista de Citas");

        jPanel2.setBackground(java.awt.Color.white);

        jButton1.setBackground(java.awt.Color.red);
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableCitas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Cita", "Nombre del Paciente", "Fecha", "Hora", "Consultorio", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tableCitas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton1)))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton1)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(570, Short.MAX_VALUE)
                .addComponent(txtCita)
                .addGap(509, 509, 509))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtCita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(verCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verCitas().setVisible(true);
            }
        });
    }
    
    public void mostrar(){
        String [] nombreColumnas = {"ID Cita","ID Médico","Nombre del Paciente","Precio","Fecha","Hora","Consultorio","Especialidad"};
        String [] registros = new String[8];
        DefaultTableModel modelo = new DefaultTableModel(null,nombreColumnas);
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();
        try{
            ResultSet rs = st.executeQuery("SELECT c.idCita, c.idMed, u.nombre+' '+u.paterno+' '+u.materno AS 'Paciente', c.precio, CONVERT(VARCHAR, c.fecha, 23) AS 'Fecha', CONVERT(VARCHAR, c.horaCita, 108) AS 'Hora', c.consultorio, e.especialidad FROM Cita c JOIN Paciente p ON c.idPac=p.idPac JOIN Usuario u ON p.email=u.email JOIN Medico m ON c.idMed=m.idMed JOIN Especialidad e ON m.idEspecialidad=e.idEspecialidad WHERE c.estadoCita=1");
            while(rs.next()){
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("idMed");
                registros[2] = rs.getString("Paciente");
                registros[3] = rs.getString("precio");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Hora");
                registros[6] = rs.getString("consultorio");
                registros[7] = rs.getString("especialidad");
                modelo.addRow(registros);
                txtCita.setText("Lista de Citas");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        tableCitas.setModel(modelo);
        //jScrollPane1.setViewportView(tableMedicos);
    }
    
    public void mostrarCitasDoctor(){
        String [] nombreColumnas = {"ID Cita","ID Médico","Nombre del Paciente","Precio","Fecha","Hora","Consultorio","Especialidad"};
        String [] registros = new String[8];
        DefaultTableModel modelo = new DefaultTableModel(null,nombreColumnas);
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();
        try{
            ResultSet rs = st.executeQuery("SELECT c.idCita, c.idMed, u.nombre+' '+u.paterno+' '+u.materno AS 'Paciente', c.precio, CONVERT(VARCHAR, c.fecha, 23) AS 'Fecha', CONVERT(VARCHAR, c.horaCita, 108) AS 'Hora', c.consultorio, e.especialidad FROM Cita c JOIN Paciente p ON c.idPac=p.idPac JOIN Usuario u ON p.email=u.email JOIN Medico m ON c.idMed=m.idMed JOIN Especialidad e ON m.idEspecialidad=e.idEspecialidad WHERE c.estadoCita=1 AND c.idMed="+getIdMed());
            while(rs.next()){
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("idMed");
                registros[2] = rs.getString("Paciente");
                registros[3] = rs.getString("precio");
                registros[4] = rs.getString("Fecha");
                registros[5] = rs.getString("Hora");
                registros[6] = rs.getString("consultorio");
                registros[7] = rs.getString("especialidad");
                modelo.addRow(registros);
                txtCita.setText("Citas por Atender");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        tableCitas.setModel(modelo);
        //jScrollPane1.setViewportView(tableMedicos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCitas;
    private javax.swing.JLabel txtCita;
    // End of variables declaration//GEN-END:variables
}
