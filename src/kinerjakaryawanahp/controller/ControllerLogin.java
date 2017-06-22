/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

/**
 *
 * @author TAKEN ZERO
 */
import javax.swing.JOptionPane;
import kinerjakaryawanahp.dao.DAOLogin;
import kinerjakaryawanahp.dao.InterfaceLogin;
import kinerjakaryawanahp.view.ViewLogin;
import kinerjakaryawanahp.view.ViewMain;

public class ControllerLogin {
    ViewLogin v;
    InterfaceLogin i;
    
    public ControllerLogin(ViewLogin v){
        this.v = v;
        i = new DAOLogin();
    }
    
    public void doLogin(){
        if((!v.getTxtUsername().getText().trim().isEmpty()) && (!v.getTxtPassword().getText().trim().isEmpty())){
            Boolean login = i.getLogin(v.getTxtUsername().getText().trim(), v.getTxtPassword().getText().trim());
            if(login){
                v.dispose();
                new ViewMain().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(v, "Username atau password SALAH","Info",2);
            }
        }else{
            JOptionPane.showMessageDialog(v, "Silahkan masukkan username dan password","Info",2);
        }
    }
}
