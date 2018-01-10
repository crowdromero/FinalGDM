/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexion.MySqlConection;
import Modelo.Descanso_medico;
import Modelo.ListadoDescansoMedico;





public class DescansoMedicoDao{
	
	public static void RegistrarDM(Descanso_medico nuevoDM){
		// Establecer conexión con la base de datos
		
		Connection con=null;
		PreparedStatement pst=null;
		
		
		try {
			con = MySqlConection.getConection();
			
			
			String insertTableSQL = "INSERT INTO DESCANSOMEDICO"+ " (iddescansomedico, dm_idempleado, dm_fechaincio, dm_fechafin, dm_tipolicencia,dm_diagnostico, dm_medico, dm_centromedico, dm_observaciones,dm_cant_dias) VALUES"+"(?,?,?,?,?,?,?,?,?,?)";
			 pst=con.prepareStatement(insertTableSQL);
			 pst.setInt(1, nuevoDM.getIddescansomedico());
			 pst.setString(2, nuevoDM.getDm_idempleado());
			 pst.setString(3,nuevoDM.getDm_fechaincio());
			 pst.setString(4,nuevoDM.getDm_fechafin());
			 pst.setInt(5, nuevoDM.getDm_tipolicencia());
			 pst.setInt(6,nuevoDM.getDm_diagnostico());
			 pst.setString(7,nuevoDM.getDm_medico());
			 pst.setInt(8, nuevoDM.getDm_centromedico());
			 pst.setString(9, nuevoDM.getDm_observaciones());
			 pst.setInt(10, nuevoDM.getDm_cantidaddias());
			 pst.executeUpdate();
			 System.out.println("Se añadio correctamente el Registro");
			 
		} catch (Exception e) {
			System.out.println("Error al insertar nuevo Descanso Medico");
		}
				
	    	
	    }
	
	public static List<ListadoDescansoMedico> obtenerDescansosMedicos() {
		
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_descanso_medico";
	        ps=con.prepareCall(sql);
	        rs=ps.executeQuery();
	        
            
            while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10),  rs.getString(11),  rs.getString(12),  rs.getString(13),  rs.getInt(14));
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
	
		
		/*ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
		try {
			con = MySqlConection.getConection();
			String sql="select dm.iddescansomedico,e.idempleado,e.emp_nombre,e.emp_apellido,dm.dm_fechaincio,dm_fechafin,dm.dm_tipolicencia,dm.dm_tipodescanso,ta.tate_descripcion,diag.diag_descripcion,med.idmedico,med_nombres,med_apellidos,cm.cem_nombre,dm.dm_observaciones " + 
					"from descansomedico as dm " + 
					"inner join empleado as e " + 
					"on dm.dm_idempleado=e.idempleado " + 
					"inner join diagnostico as diag " + 
					"on dm.dm_diagnostico=diag.iddiagnostico " + 
					"inner join `centro _medico` as cm " + 
					"on dm.dm_centromedico=cm.idcentro_medico " + 
					"inner join medico as med " + 
					"on dm.dm_medico=med.idmedico " + 
					"inner join tipo_atencion as ta " + 
					"on dm.dm_tipoatencion=ta.idtipo_atencion";
			 pst=con.prepareStatement(sql);
			 rs=pst.executeQuery();
			 while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10),  rs.getString(11),  rs.getString(12),  rs.getString(13),  rs.getString(14),  rs.getString(15));
				 listadedm.add(ldm);
			 }
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		
		
		return listadedm;*/
	}
	
	public static List<ListadoDescansoMedico> obtenerDescansosMedicosPorFecha(String fecha){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
        
		try {
			
						
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medico_porfecha(?)}";
	        ps=con.prepareCall(sql);
	        System.out.println("llegue aca 1");
	        ps.setString(1, fecha);
	        rs=ps.executeQuery();
	        System.out.println("llegue aca 2");
	        
            
            while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10),  rs.getString(11),  rs.getString(12),  rs.getString(13),  rs.getInt(14));
				 System.out.println("llegue aca 3");
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
	}
	
	public static List<ListadoDescansoMedico> obtenerDescansosMedicoDetalleDias(){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
        
		try {
			
						
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medico_diastotalesxpersona}";
	        ps=con.prepareCall(sql);
	        System.out.println("llegue aca 1");
	        rs=ps.executeQuery();
	        System.out.println("llegue aca 2");
	        
            
            while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10),  rs.getString(11),  rs.getString(12),  rs.getString(13),  rs.getInt(14));
				 System.out.println("llegue aca 3");
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		
		
		return listadedm;
	}
	
	
}

