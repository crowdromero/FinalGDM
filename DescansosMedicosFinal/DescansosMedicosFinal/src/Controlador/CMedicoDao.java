/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import static Controlador.MedicoDao.obtenerMedicos;
import Modelo.Centro_Medico;
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
public class CMedicoDao {
    
    public static List<Centro_Medico> obtenerCentrosMedicos() {
		
		Centro_Medico cmedico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Centro_Medico> listadecm = new ArrayList<Centro_Medico>();
		
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Centros_Medicos";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			cmedico=new Centro_Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(8));
                        listadecm.add(cmedico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadecm;
	
		
	}
    
    public static List<Centro_Medico> obtenerCentrosMedicosxRuc(String ruc) {
		
		Centro_Medico cmedico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Centro_Medico> listadecm = new ArrayList<Centro_Medico>();
		
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Centros_MedicosxRUC(?)";
                        ps=con.prepareCall(sql);
                        ps.setString(1, ruc);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			cmedico=new Centro_Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(8));
                        listadecm.add(cmedico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadecm;
	
		
	}
    
    public static List<Centro_Medico> obtenerCentrosMedicosxRS(String rsocial) {
		
		Centro_Medico cmedico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Centro_Medico> listadecm = new ArrayList<Centro_Medico>();
		
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Centros_MedicosxRazonSocial(?)";
                        ps=con.prepareCall(sql);
                        ps.setString(1, rsocial);
                        rs=ps.executeQuery();
                        
                    while(rs.next()) {
			cmedico=new Centro_Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(8));
                        listadecm.add(cmedico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadecm;
		
	}
       
    public static void llenarTablaCMedico(JTable tabla){
         
         String CabeceraListado[]= new String[]{"RUC", "Razon Social","Direccion","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Centro_Medico x:obtenerCentrosMedicos()) {
             if (x.getCem_estado()!=0) {
                Object fila[] = { x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = {x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
    
    public static void llenarTablaCMedicoxRuc(JTable tabla,String ruc){
         
         String CabeceraListado[]= new String[]{"RUC", "Razon Social","Direccion","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Centro_Medico x:obtenerCentrosMedicosxRuc(ruc)) {
             if (x.getCem_estado()!=0) {
                Object fila[] = { x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = {x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
    
    public static void llenarTablaCMedicoxRS(JTable tabla,String rsocial){
         
         String CabeceraListado[]= new String[]{"RUC", "Razon Social","Direccion","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Centro_Medico x:obtenerCentrosMedicosxRS(rsocial)) {
             if (x.getCem_estado()!=0) {
                Object fila[] = { x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = {x.getCem_ruc(), x.getCem_nombre(),x.getCem_direccion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }
    
}
