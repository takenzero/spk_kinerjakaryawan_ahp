/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.koneksi.KoneksiMySQL;
/**
 *
 * @author taken
 */
public class DAOKriteria implements InterfaceKriteria{
    Connection connection;
    final String insert = "INSERT INTO tbl_kriteria (nama_kriteria) VALUES(?)";
    final String update = "UPDATE tbl_kriteria SET nama_kriteria=? WHERE id_kriteria=?";
    final String delete = "DELETE FROM tbl_kriteria WHERE id_kriteria=?";
    final String select = "SELECT * from tbl_kriteria";
    final String select_id = "SELECT * tbl_kriteria WHERE id_kriteria=?";
    
    public DAOKriteria(){
        try {
            connection = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelKriteria m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, m.getNamaKriteria());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean update(ModelKriteria m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getNamaKriteria());
            statement.setInt(2, m.getIdKriteria());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean delete(int id_kriteria){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id_kriteria);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<ModelKriteria> getAllKriteria(){
        List<ModelKriteria> list = null;
        try{
            list = new ArrayList<ModelKriteria>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModelKriteria mk = new ModelKriteria();
                mk.setIdKriteria(rs.getInt("id_kriteria"));
                mk.setNamaKriteria(rs.getString("nama_kriteria"));
                list.add(mk);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ModelKriteria getKriteriaBaseOnID(int id_kriteria) {
        ModelKriteria mk = new ModelKriteria();
        try{
            PreparedStatement st = connection.prepareStatement(select_id);
            st.setInt(1, id_kriteria);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                mk.setIdKriteria(rs.getInt("id_kriteria"));
                mk.setNamaKriteria(rs.getString("nama_kriteria"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return mk;
    }
}