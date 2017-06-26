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
import kinerjakaryawanahp.model.ModelSubKriteria;
import kinerjakaryawanahp.koneksi.KoneksiMySQL;
import kinerjakaryawanahp.model.ModelKriteria;
/**
 *
 * @author taken
 */
public class DAOSubKriteria implements InterfaceSubKriteria{
    Connection connection;
    final String insert = "INSERT INTO tbl_subkriteria (nama_subkriteria,id_kriteria) VALUES(?,?)";
    final String update = "UPDATE tbl_subkriteria SET nama_subkriteria=?, id_kriteria=? WHERE id_subkriteria=?";
    final String delete = "DELETE FROM tbl_subkriteria WHERE id_subkriteria=?";
    final String select = "SELECT a.id_subkriteria, a.nama_subkriteria, b.id_kriteria, b.nama_kriteria from tbl_subkriteria a, tbl_kriteria b WHERE a.id_kriteria=b.id_kriteria";
    final String select_id = "SELECT a.id_subkriteria, a.nama_subkriteria, b.id_kriteria, b.nama_kriteria from tbl_subkriteria a, tbl_kriteria b WHERE a.id_kriteria=b.id_kriteria AND id_subkriteria=?";
    
    public DAOSubKriteria(){
        try {
            connection = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelSubKriteria m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, m.getNamaSubKriteria());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean update(ModelSubKriteria m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getNamaSubKriteria());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.setInt(3, m.getIdSubKriteria());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean delete(int id_subkriteria){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id_subkriteria);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<ModelSubKriteria> getAllSubKriteria(){
        List<ModelSubKriteria> list = null;
        try{
            list = new ArrayList<ModelSubKriteria>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModelSubKriteria mk = new ModelSubKriteria();
                ModelKriteria kriteria = new ModelKriteria();
                mk.setIdSubKriteria(rs.getInt("id_subkriteria"));
                mk.setNamaSubKriteria(rs.getString("nama_subkriteria"));
                kriteria.setIdKriteria(rs.getInt("id_kriteria"));
                kriteria.setNamaKriteria(rs.getString("nama_kriteria"));
                mk.setKriteria(kriteria);
                list.add(mk);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ModelSubKriteria getSubKriteriaBaseOnID(int id_subkriteria) {
        ModelSubKriteria mk = new ModelSubKriteria();
        ModelKriteria kriteria = new ModelKriteria();
        try{
            PreparedStatement st = connection.prepareStatement(select_id);
            st.setInt(1, id_subkriteria);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                mk.setIdSubKriteria(rs.getInt("id_subkriteria"));
                mk.setNamaSubKriteria(rs.getString("nama_subkriteria"));
                kriteria.setIdKriteria(rs.getInt("id_kriteria"));
                kriteria.setNamaKriteria(rs.getString("nama_kriteria"));
                mk.setKriteria(kriteria);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return mk;
    }
}