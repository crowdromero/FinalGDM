/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.MySqlConection;
import Modelo.TipoLicencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;


public class TipoLicenciaDao {
    
    public static List<TipoLicencia> obtenerTipoLicencias() {
		
		TipoLicencia licencias=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		List<TipoLicencia> listadelicencias = new ArrayList<TipoLicencia>();
		
		
        
		try {
			con = MySqlConection.getConection();
			String sql="call sp_consultar_licencias";
                        ps=con.prepareCall(sql);
                        rs=ps.executeQuery();
	        
            
                    while(rs.next()) {
			licencias=new TipoLicencia(rs.getInt(1), rs.getString(2), rs.getInt(3));
                        listadelicencias.add(licencias);
                    }
            
		} catch (Exception e) {
			System.out.println("error al obtener los Registros");
		}
		return listadelicencias;
	
		
	}
    
       
    public static void llenarCombo(JComboBox cboTipo_licencia) {
        cboTipo_licencia.removeAllItems();
        
        cboTipo_licencia.addItem("Escoja una opcion");
        for (TipoLicencia x:obtenerTipoLicencias()) {
            cboTipo_licencia.addItem(x.getDes_tip_licencia());
        }
        
    }
}
