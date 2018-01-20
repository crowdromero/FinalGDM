/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import Modelo.Correo;
import Modelo.Diagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xen
 */
public class CorrreoDao {
    public static List<Correo> obtenerCorreo() {
		
		Correo registro=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<Correo> listadecorreo = new ArrayList<Correo>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_Correos";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			registro=new Correo(rs.getInt(1), rs.getInt(2), rs.getString(3));
                        listadecorreo.add(registro);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadecorreo;
	
		
	}
    
}
