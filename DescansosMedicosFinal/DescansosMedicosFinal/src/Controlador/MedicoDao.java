/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import Modelo.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xen
 */
public class MedicoDao {
    
    public static List<Medico> obtenerMedicos() {
		
		Medico medico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Medico> listademedicos = new ArrayList<Medico>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Medico";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			medico=new Medico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        
                        listademedicos.add(medico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listademedicos;
	
		
	}
    public static List<Medico> obtenerMedicosxCMP(String cmp ) {
		
		Medico medico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Medico> listademedicos = new ArrayList<Medico>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_MedicoxCMP(?)";
                        ps=con.prepareCall(sql);
                        ps.setString(1, cmp);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			medico=new Medico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        
                        listademedicos.add(medico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listademedicos;
	
		
	}
    
    public static List<Medico> obtenerMedicosxRazonSocial(String nombre,String apellidos ) {
		
		Medico medico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Medico> listademedicos = new ArrayList<Medico>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Medicoxnombreoapellido(?,?)";
                        ps=con.prepareCall(sql);
                        ps.setString(1, nombre);
                        ps.setString(2, apellidos);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			medico=new Medico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        
                        listademedicos.add(medico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listademedicos;
	
		
	}
    
    public static void llenarTablaMedico(JTable tabla){
         
         String CabeceraListado[]= new String[]{"CMP ", "Nombre","Apellido","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Medico x:obtenerMedicos()) {
             if (x.getMed_activo()!=0) {
                Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
     
    public static void llenarTablaMedicoxCMP(JTable tabla,String cmp){
         
         String CabeceraListado[]= new String[]{"CMP ", "Nombre","Apellido","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Medico x:obtenerMedicosxCMP(cmp)) {
             if (x.getMed_activo()!=0) {
                Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
    
    public static void llenarTablamedicoxnombre(JTable tabla,String nombre,String apellido){
         
         String CabeceraListado[]= new String[]{"CMP ", "Nombre","Apellido","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Medico x:obtenerMedicosxRazonSocial(nombre,apellido)) {
             if (x.getMed_activo()!=0) {
                Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getIdmedico(), x.getEd_nombres(),x.getMed_apellidos(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
    
}
