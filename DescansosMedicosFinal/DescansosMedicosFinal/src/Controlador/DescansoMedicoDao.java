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
import Modelo.Correo;
import Modelo.Descanso_medico;
import Modelo.ListadoDescansoMedico;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class DescansoMedicoDao{
	
	public static void RegistrarDM(Descanso_medico nuevoDM){
		// Establecer conexión con la base de datos
		
		Connection con=null;
		PreparedStatement pst=null;
		//call sp_nuevo_descanso_medico(1000001,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);
		
		try {
			con = MySqlConection.getConection();
			String sql="{call sp_nuevo_descanso_medico((?),(?),(?),(?),(?),(?),(?),(?),(?),(?))}";
                        pst=con.prepareCall(sql);
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
                        pst.executeQuery();
			
			
			// pst.executeUpdate();
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
				 ldm=new ListadoDescansoMedico(rs.getInt(1),
                                                               rs.getString(2), rs.getString(3), 
                                                               rs.getString(4),  rs.getString(5),  
                                                               rs.getString(6),  rs.getString(7),  
                                                               rs.getString(8),  rs.getString(9),  
                                                               rs.getString(10),  rs.getString(11),  
                                                               rs.getString(12),  rs.getString(13),  
                                                               rs.getInt(14));
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
		
	}
	
	public static List<ListadoDescansoMedico> obtenerDescansosMedicosPorFecha(String dm_fechaincio,String dm_fechafin){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
		try {			
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medico_porfecha(?,?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, dm_fechaincio);
                        ps.setString(2, dm_fechafin);
                        rs=ps.executeQuery();
            
                        while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1),
                                                               rs.getString(2), rs.getString(3), 
                                                               rs.getString(4),  rs.getString(5),  
                                                               rs.getString(6),  rs.getString(7),  
                                                               rs.getString(8),  rs.getString(9),  
                                                               rs.getString(10),  rs.getString(11),  
                                                               rs.getString(12),  rs.getString(13),  
                                                               rs.getInt(14));
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
	}
        
        public static List<ListadoDescansoMedico> obtenerDescansosMedicosxEmpleado(String codigo){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
		try {			
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medicoxEmpleado(?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1,codigo);
                        rs=ps.executeQuery();
            
                        while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1),
                                                               rs.getString(2), rs.getString(3), 
                                                               rs.getString(4),  rs.getString(5),  
                                                               rs.getString(6),  rs.getString(7),  
                                                               rs.getString(8),  rs.getString(9),  
                                                               rs.getString(10),  rs.getString(11),  
                                                               rs.getString(12),  rs.getString(13),  
                                                               rs.getInt(14));
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
	}
	
	public static List<ListadoDescansoMedico> obtenerDescansosMedicoDetalleDias(String codigo){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
        
		try {
			
						
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medico_diastotalesxpersona(?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1,codigo);
                        rs=ps.executeQuery();
                        System.out.println("hasta aqui");
	        
            
                        while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4));
				 listadedm.add(ldm);
			 }
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		
		
		return listadedm;
	}
	
        public static List<ListadoDescansoMedico> obtenerDescansosMedicosxMotivo(int licencia,int diagnostico){
		ListadoDescansoMedico ldm=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<ListadoDescansoMedico> listadedm = new ArrayList<ListadoDescansoMedico>();
		
		try {			
			con = MySqlConection.getConection();
			
			String sql="{call sp_consultar_descanso_medicoxMotivo(?,?)}";
                        ps=con.prepareCall(sql);
                        ps.setInt(1,licencia);
                        ps.setInt(2,diagnostico);
                        rs=ps.executeQuery();
            
                        while(rs.next()) {
				 ldm=new ListadoDescansoMedico(rs.getInt(1),
                                                               rs.getString(2), rs.getString(3), 
                                                               rs.getString(4),  rs.getString(5),  
                                                               rs.getString(6),  rs.getString(7),  
                                                               rs.getString(8),  rs.getString(9),  
                                                               rs.getString(10),  rs.getString(11),  
                                                               rs.getString(12),  rs.getString(13),  
                                                               rs.getInt(14));
				 listadedm.add(ldm);
			 }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadedm;
	}
        
        
        public static void llenarTablaDescansoMedico(JTable tabla){
         
         String CabeceraListado[]= new String[]{"Nro","Codigo","Nombre","Apellido","Fecha Inicio","Fecha Final","Licencia","Diagnostico","Observaciones","CMP","Medico","RUC","Centro Medico","Duracion"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (ListadoDescansoMedico x:obtenerDescansosMedicos()) {
               Object fila[] = { x.getIddescansomedico(),x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getDm_fechaincio(),x.getDm_fechafin(),
                                 x.getDm_tipolicencia(),x.getDiag_descripcion(),x.getDm_observaciones(),x.getDm_medico(),x.getMed_nombres(),x.getRuccem(),x.getCem_nombre(),x.getCantDias()}; 
                dtm.addRow(fila);
             
            
            
        }
        tabla.setModel(dtm);
     }

    public static void llenarTablaDescansoMedicoxFechas(JTable jTable1, String dm_fechaincio, String dm_fechafin) {
        String CabeceraListado[]= new String[]{"Nro","Codigo","Nombre","Apellido","Fecha Inicio","Fecha Final","Licencia","Diagnostico","Observaciones","CMP","Medico","RUC","Centro Medico","Duracion"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (ListadoDescansoMedico x:obtenerDescansosMedicosPorFecha(dm_fechaincio,dm_fechafin)) {
               Object fila[] = { x.getIddescansomedico(),x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getDm_fechaincio(),x.getDm_fechafin(),
                                 x.getDm_tipolicencia(),x.getDiag_descripcion(),x.getDm_observaciones(),x.getDm_medico(),x.getMed_nombres(),x.getRuccem(),x.getCem_nombre(),x.getCantDias()}; 
                dtm.addRow(fila);
             
        }
        jTable1.setModel(dtm);
        
        
        
    }

    public static void llenarTablaDescansoMedicoxEmpleado(JTable jTable1, String text) {
        String CabeceraListado[]= new String[]{"Nro","Codigo","Nombre","Apellido","Fecha Inicio","Fecha Final","Licencia","Diagnostico","Observaciones","CMP","Medico","RUC","Centro Medico","Duracion"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (ListadoDescansoMedico x:obtenerDescansosMedicosxEmpleado(text)) {
               Object fila[] = { x.getIddescansomedico(),x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getDm_fechaincio(),x.getDm_fechafin(),
                                 x.getDm_tipolicencia(),x.getDiag_descripcion(),x.getDm_observaciones(),x.getDm_medico(),x.getMed_nombres(),x.getRuccem(),x.getCem_nombre(),x.getCantDias()}; 
                dtm.addRow(fila);
        }
        jTable1.setModel(dtm);
    }

    public static void llenarTablaDescansoMedicoxLicencia(JTable jTable1, int licencia,int diagnostico) {
        String CabeceraListado[]= new String[]{"Nro","Codigo","Nombre","Apellido","Fecha Inicio","Fecha Final","Licencia","Diagnostico","Observaciones","CMP","Medico","RUC","Centro Medico","Duracion"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (ListadoDescansoMedico x:obtenerDescansosMedicosxMotivo(licencia,diagnostico)) {
               Object fila[] = { x.getIddescansomedico(),x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getDm_fechaincio(),x.getDm_fechafin(),
                                 x.getDm_tipolicencia(),x.getDiag_descripcion(),x.getDm_observaciones(),x.getDm_medico(),x.getMed_nombres(),x.getRuccem(),x.getCem_nombre(),x.getCantDias()}; 
                dtm.addRow(fila);
        }
        jTable1.setModel(dtm);
    }
    
    public static void llenarTablaDescansoMedicoxDiasAcumulados(JTable jTable1,String empleado) {
        String CabeceraListado[]= new String[]{"Codigo","Nombre","Apellido","Dias Acumulados"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (ListadoDescansoMedico x:obtenerDescansosMedicoDetalleDias(empleado)) {
               Object fila[] = { x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getCantDias()}; 
                dtm.addRow(fila);
        }
        jTable1.setModel(dtm);
    }

    public static void alerta1(String codigo) {
        	
	for (ListadoDescansoMedico x:obtenerDescansosMedicoDetalleDias(codigo)) {
		Object fila[] = { x.getDm_idempleado(),x.getEmp_nombre(),x.getEmp_apellido(),x.getCantDias()}; 
			
		System.out.println("Intentando enviar Correo");
						
		if (x.getCantDias()>CorrreoDao.obtenerCorreo().get(0).getDias()) {
                	JOptionPane.showMessageDialog(null, "El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(0).getDias() +"dias acumulados");
                        EnviarMail.EnvioCorreo(CorrreoDao.obtenerCorreo().get(0).getCorreo(),"Alerta de registro bajo Subsidio","El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(0).getDias() +"dias acumulados");
		}else if (x.getCantDias()>CorrreoDao.obtenerCorreo().get(1).getDias()) {
                	JOptionPane.showMessageDialog(null, "El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(1).getDias() +"dias acumulados");
                        EnviarMail.EnvioCorreo(CorrreoDao.obtenerCorreo().get(1).getCorreo(),"Alerta de registro bajo Subsidio","El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(1).getDias() +"dias acumulados");
		}else if (x.getCantDias()>CorrreoDao.obtenerCorreo().get(2).getDias()) {
                	JOptionPane.showMessageDialog(null, "El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(2).getDias() +"dias acumulados");
                        EnviarMail.EnvioCorreo(CorrreoDao.obtenerCorreo().get(2).getCorreo(),"Alerta de registro bajo Subsidio","El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(2).getDias() +"dias acumulados");
		}else if (x.getCantDias()>CorrreoDao.obtenerCorreo().get(3).getDias()) {
                	JOptionPane.showMessageDialog(null, "El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(3).getDias() +"dias acumulados");
                        EnviarMail.EnvioCorreo(CorrreoDao.obtenerCorreo().get(3).getCorreo(),"Alerta de registro bajo Subsidio","El trabajador  "+x.getEmp_nombre()+" "+x.getEmp_apellido()+"ha superado los"+ CorrreoDao.obtenerCorreo().get(3).getDias() +"dias acumulados");
		} 
	}
		
    }
	
}

