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

/**
 *
 * @author crist
 */
public class comprobanteCita {
    
    public void mostrarComprobante(String fecha, String hora, int consultorio){
        int idCita = 0;
        String nombre = "";
        String especialidad = "";
        
        conexion conectar = new conexion();
        Statement st = conectar.Conectar();
        try{
            String consulta = "select c.idCita, u.nombre+' '+u.paterno+' '+u.materno AS 'Paciente', e.especialidad, CONVERT(VARCHAR, c.fecha, 23) AS 'Fecha', CONVERT(VARCHAR, c.horaCita, 108) AS 'Hora', c.consultorio from Cita c join Medico m on c.idMed=m.idMed join Paciente p on c.idPac=p.idPac join Usuario u on p.email=u.email join Especialidad e on m.idEspecialidad=e.idEspecialidad where c.consultorio=" + consultorio + " and c.fecha='" + fecha + "' and c.horaCita='" + hora + "'";
            ResultSet rs = st.executeQuery(consulta);
            //ResultSet rs = st.executeQuery("select c.idCita, u.nombre+' '+u.paterno+' '+u.materno AS 'Paciente', e.especialidad, CONVERT(VARCHAR, c.fecha, 23) AS 'Fecha', CONVERT(VARCHAR, c.horaCita, 108) AS 'Hora', c.consultorio from Cita c join Medico m on c.idMed=m.idMed join Paciente p on c.idPac=p.idPac join Usuario u on p.email=u.email join Especialidad e on m.idEspecialidad=e.idEspecialidad where c.consultorio=2 and c.fecha='2024-01-31' and c.horaCita='07:00'");
            while(rs.next()) {
                idCita = rs.getInt("idCita");
                nombre = rs.getString("Paciente");
                especialidad = rs.getString("especialidad");
                fecha = rs.getString("Fecha");
                hora = rs.getString("Hora");
                consultorio = rs.getInt("consultorio");
                JOptionPane.showConfirmDialog(null, "La cita con el folio "+idCita+" del paciente "+nombre+" para la especialidad de "+especialidad+" será en "+fecha+" a las "+hora+" en el consultorio "+consultorio);   
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
