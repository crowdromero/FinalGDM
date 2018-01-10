/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;

/**
 *
 * @author ll
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FrmMenuPrincipal frame=new FrmMenuPrincipal();
        
        
        frame.setVisible(true);
        Dimension dim = frame.getToolkit().getScreenSize();
        frame.setLocationRelativeTo(frame);
        frame.setSize(dim);
        frame.setUndecorated(true);
    }
    
}
