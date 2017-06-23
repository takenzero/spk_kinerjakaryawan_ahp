/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kinerjakaryawanahp.view.ViewLogin;

/**
 *
 * @author TAKEN ZERO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
            
        }
        new ViewLogin().setVisible(true);
    }
    
}
