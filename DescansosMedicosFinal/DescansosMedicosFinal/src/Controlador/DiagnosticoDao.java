/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import static Controlador.EmpleadoDao.obtenerEmpleados;
import Modelo.Diagnostico;
import Modelo.Empleado;
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
public class DiagnosticoDao {
    
    public static List<Diagnostico> obtenerDiagnosticos() {
		
		Diagnostico diagnostico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Diagnostico> listadediagnostico = new ArrayList<Diagnostico>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_diagnostico;";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			diagnostico=new Diagnostico(rs.getInt(1), rs.getString(2), rs.getInt(3));
                        listadediagnostico.add(diagnostico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadediagnostico;
	
		
	}
    public static List<Diagnostico> obtenerDiagnosticos(String codigo) {
		
		Diagnostico diagnostico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Diagnostico> listadediagnostico = new ArrayList<Diagnostico>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_consultar_diagnosticoxcodigo(?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, codigo);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			diagnostico=new Diagnostico(rs.getInt(1), rs.getString(2), rs.getInt(3));
                        listadediagnostico.add(diagnostico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadediagnostico;
	
		
	}
    
    public static void llenarTablaDiagnostico(JTable tabla){
         
         String CabeceraListado[]= new String[]{"Codigo ", "Diagnostico","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Diagnostico x:obtenerDiagnosticos()) {
             if (x.getEstado()!=0) {
                Object fila[] = { x.getCodigo(), x.getDescripcion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getCodigo(), x.getDescripcion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
            
            
        }
        tabla.setModel(dtm);
     }
    
    //sp_consultar_diagnosticoxDescripcion
    public static List<Diagnostico> obtenerDiagnosticosxDescripcion(String descripcion) {
		
		Diagnostico diagnostico=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Diagnostico> listadediagnostico = new ArrayList<Diagnostico>();
		
		
        
		try {
			con = MySqlConection.getConection();
                        String sql="{call sp_consultar_diagnosticoxDescripcion(?)}";
                        ps=con.prepareCall(sql);
                        ps.setString(1, descripcion);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			diagnostico=new Diagnostico(rs.getInt(1), rs.getString(2), rs.getInt(3));
                        listadediagnostico.add(diagnostico);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadediagnostico;
	
		
	}
    
    public static void llenarTablaDiagnosticoxDescripcion(JTable tabla,String descripcion){
         
         String CabeceraListado[]= new String[]{"Codigo ", "Diagnostico","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Diagnostico x:obtenerDiagnosticosxDescripcion(descripcion)) {
            if (x.getEstado()!=0) {
                Object fila[] = { x.getCodigo(), x.getDescripcion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getCodigo(), x.getDescripcion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        tabla.setModel(dtm);
     }

    public static void llenarTablaDiagnosticoxCodigo(JTable jTable1, String codigo) {
        String CabeceraListado[]= new String[]{"Codigo ", "Diagnostico","Estado"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Diagnostico x:obtenerDiagnosticos(codigo)) {
            if (x.getEstado()!=0) {
                Object fila[] = { x.getCodigo(), x.getDescripcion(),"Activo"}; 
                dtm.addRow(fila);
             }else{
                 Object fila[] = { x.getCodigo(), x.getDescripcion(),"Inactivo"}; 
                 dtm.addRow(fila);
             }
        }
        jTable1.setModel(dtm);
    }
        
}
