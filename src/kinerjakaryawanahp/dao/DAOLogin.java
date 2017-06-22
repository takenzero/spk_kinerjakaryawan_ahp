/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

/**
 *
 * @author TAKEN ZERO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kinerjakaryawanahp.koneksi.KoneksiMySQL;

public class DAOLogin implements InterfaceLogin{
    Connection connection;
    final String qLogin = "SELECT * FROM tbl_user WHERE username=? and password=?";
    
    public DAOLogin(){
        try {
            connection = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean getLogin(String usr, String psw){
        try{
            PreparedStatement st = connection.prepareStatement(qLogin);
            st.setString(1, usr);
            st.setString(2, psw);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch(SQLException ex){
            
        }
        return false;
    }
}
