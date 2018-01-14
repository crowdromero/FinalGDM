/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class EmpleadoDao {
    
     public static List<Empleado> obtenerEmpleados() {
		
		Empleado empleado=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Empleado> listadeempleados = new ArrayList<Empleado>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Empleados";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			empleado=new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getDate(6), rs.getString(8), rs.getString(9), rs.getString(10));
        
                        listadeempleados.add(empleado);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadeempleados;
	
		
	}
     
     public static void llenarTablaEmpleado(JTable tabla){
         
         String CabeceraListado[]= new String[]{"Codigo Empleado", "Nombres","Apellidos","Nro Documento","Fecha de Nacimiento","Telefono","Correo"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Empleado x:obtenerEmpleados()) {
            Object fila[] = { x.getIdempleado(), x.getEmp_nombre(),x.getEmp_apellido(), x.getEmp_numero_doc(),x.getEmp_fecha_naciemiento(), x.getEmp_telefono(), x.getEmp_correo()};
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
     }
     
     public static List<Empleado> obtenerEmpleado(String apellido){
		Empleado empleado=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Empleado> listadeempleados = new ArrayList<Empleado>();
		
        
		try {
			
						
                    con = MySqlConection.getConection();
                    String sql="{call sp_consultar_EmpleadosxApellido(?)}";
                    ps=con.prepareCall(sql);
                    ps.setString(1, apellido);
                    rs=ps.executeQuery();
	        	
                    while(rs.next()) {
			empleado=new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getDate(6), rs.getString(8), rs.getString(9), rs.getString(10));
                        listadeempleados.add(empleado);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadeempleados;
    }
     
    public static void llenarTablaEmpleadoxapellido(JTable tabla,String apellido){
         
         String CabeceraListado[]= new String[]{"Codigo Empleado", "Nombres","Apellidos","Nro Documento","Fecha de Nacimiento","Telefono","Correo"};
         DefaultTableModel dtm=new DefaultTableModel(CabeceraListado, 0);
         for (Empleado x:obtenerEmpleado(apellido)) {
            Object fila[] = { x.getIdempleado(), x.getEmp_nombre(),x.getEmp_apellido(), x.getEmp_numero_doc(),x.getEmp_fecha_naciemiento(), x.getEmp_telefono(), x.getEmp_correo()};
            dtm.addRow(fila);
        }
        tabla.setModel(dtm);
     } 
     
     
     
    
}
