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
    Connection conn;
    final String INSERT = "INSERT INTO tbl_karyawan(id_karyawan, nama, kelamin, agama, tempat, tgl_lahir, alamat, no_telp) VALUES(?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE tbl_karyawan SET nama=?, kelamin=?, agama=?, tempat=?, tgl_lahir=?, alamat=?, no_telp=? WHERE id_karyawan=?";
    final String DELETE = "DELETE from tbl_karyawan WHERE id_karyawan=?";
    final String SELECT = "SELECT * FROM tbl_karyawan";
    final String SEARCH = "SELECT * FROM tbl_karyawan WHERE nama like ? OR id_karyawan=?";
    
    public DAOKaryawan(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelKaryawan m){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(INSERT);
            statement.setString(1, m.getIdKaryawan());
            statement.setString(2, m.getNama());
            statement.setInt(3, m.getKelamin());
            statement.setInt(4, m.getAgama());
            statement.setString(5, m.getTempat());
            statement.setDate(6, new java.sql.Date(m.getTglLahir().getTime()));
            statement.setString(7, m.getAlamat());
            statement.setString(8, m.getNoTelp());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public Boolean update(ModelKaryawan m){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, m.getNama());
            statement.setInt(2, m.getKelamin());
            statement.setInt(3, m.getAgama());
            statement.setString(4, m.getTempat());
            statement.setDate(5, new java.sql.Date(m.getTglLahir().getTime()));
            statement.setString(6, m.getAlamat());
            statement.setString(7, m.getNoTelp());
            statement.setString(8, m.getIdKaryawan());
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public Boolean delete(String id){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement(DELETE);
            statement.setString(1, id);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public List<ModelKaryawan> getAllKaryawan(){
        List<ModelKaryawan> list = null;
        try {
            list = new ArrayList<ModelKaryawan>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT);
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
            PreparedStatement st = conn.prepareStatement(SEARCH);
            st.setString(1, "%" + cari + "%");
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