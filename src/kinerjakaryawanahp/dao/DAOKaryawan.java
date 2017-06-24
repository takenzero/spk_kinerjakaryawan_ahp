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
import kinerjakaryawanahp.koneksi.KoneksiMySQL;
import kinerjakaryawanahp.model.ModelKaryawan;
/**
 *
 * @author taken
 */

public class DAOKaryawan implements InterfaceKaryawan{
    Connection connection;
    final String insert = "INSERT INTO tbl_karyawan(id_karyawan, nama, kelamin, agama, tempat, tgl_lahir, alamat, no_telp) VALUES(?,?,?,?,?,?,?,?)";
    final String update = "UPDATE tbl_karyawan SET nama=?, kelamin=?, agama=?, tempat=?, tgl_lahir=?, alamat=?, no_telp=? WHERE id_karyawan=?";
    final String delete = "DELETE from tbl_karyawan WHERE id_karyawan=?";
    final String select = "SELECT * FROM tbl_karyawan";
    final String search = "SELECT * FROM tbl_karyawan WHERE nama like ? OR id_karyawan=?";
    
    public DAOKaryawan(){
        try {
            connection = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(ModelKaryawan m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, m.getIdKaryawan());
            statement.setString(2, m.getNama());
            statement.setInt(3, m.getKelamin());
            statement.setInt(4, m.getAgama());
            statement.setString(5, m.getTempat());
            statement.setDate(6, new java.sql.Date(m.getTglLahir().getTime()));
            statement.setString(7, m.getAlamat());
            statement.setString(8, m.getNoTelp());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(ModelKaryawan m){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getNama());
            statement.setInt(2, m.getKelamin());
            statement.setInt(3, m.getAgama());
            statement.setString(4, m.getTempat());
            statement.setDate(5, new java.sql.Date(m.getTglLahir().getTime()));
            statement.setString(6, m.getAlamat());
            statement.setString(7, m.getNoTelp());
            statement.setString(8, m.getIdKaryawan());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String id){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<ModelKaryawan> getAllKaryawan(){
        List<ModelKaryawan> list = null;
        try {
            list = new ArrayList<ModelKaryawan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                ModelKaryawan mk = new ModelKaryawan();
                mk.setIdKaryawan(rs.getString("id_karyawan"));
                mk.setNama(rs.getString("nama"));
                mk.setStrKelamin(rs.getInt("kelamin"));
                mk.setStrAgama(rs.getInt("agama"));
                mk.setTempat(rs.getString("tempat"));
                mk.setTglLahir(rs.getDate("tgl_lahir"));
                mk.setAlamat(rs.getString("alamat"));
                mk.setNoTelp(rs.getString("no_telp"));
                list.add(mk);
                mk.setKelamin(rs.getInt("kelamin"));
                mk.setAgama(rs.getInt("agama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public List<ModelKaryawan> getCariKaryawan(String cari){
        List<ModelKaryawan> list = null;
        try {
            list = new ArrayList<ModelKaryawan>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1, "%"+cari+"%");
            st.setString(2, cari);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                ModelKaryawan mk = new ModelKaryawan();
                mk.setIdKaryawan(rs.getString("id_karyawan"));
                mk.setNama(rs.getString("nama"));
                mk.setStrKelamin(rs.getInt("kelamin"));
                mk.setStrAgama(rs.getInt("agama"));
                mk.setTempat(rs.getString("tempat"));
                mk.setTglLahir(rs.getDate("tgl_lahir"));
                mk.setAlamat(rs.getString("alamat"));
                mk.setNoTelp(rs.getString("no_telp"));
                list.add(mk);
                mk.setKelamin(rs.getInt("kelamin"));
                mk.setAgama(rs.getInt("agama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
