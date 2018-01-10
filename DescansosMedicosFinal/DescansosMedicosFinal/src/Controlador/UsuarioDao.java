/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Conexion.MySqlConection;
import Modelo.Usuario;
import gui.FrmMenuPrincipal;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class UsuarioDao {
		
	public static Usuario obtenerUsuario(Usuario usu) {
		Usuario usuario=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con = MySqlConection.getConection();
			String sql="select * from usuario where usu_codigo=? and usu_contraseña=?";
			 pst=con.prepareStatement(sql);
			 pst.setString(1, usu.getUsu_codigo());
			 pst.setString(2, usu.getUsu_contraseña());
			 rs=pst.executeQuery();
			 while(rs.next()) {
				 usuario=new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
			 }
		} catch (Exception e) {
			System.out.println("error al obtener usuario");
		}
		
		
		return usuario;
	}
        
        public static void ingresar(String usuario,String contraseña) {
		
		UsuarioDao usuariodao=new UsuarioDao();
		
		Usuario usu=new Usuario();
		usu.setUsu_codigo(usuario);
		usu.setUsu_contraseña(contraseña);
		
		Usuario usu1=UsuarioDao.obtenerUsuario(usu);
		
		if(usu1!=null) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			                       
                        FrmMenuPrincipal frame=new FrmMenuPrincipal();
        
        
                        frame.setVisible(true);
                        Dimension dim = frame.getToolkit().getScreenSize();
                        frame.setLocationRelativeTo(frame);
                        frame.setSize(dim);
                        frame.setUndecorated(true);
                        
			
		}else {
			JOptionPane.showMessageDialog(null, "Datos Invalidos","Error",JOptionPane.ERROR_MESSAGE);
		}
        }
	
}