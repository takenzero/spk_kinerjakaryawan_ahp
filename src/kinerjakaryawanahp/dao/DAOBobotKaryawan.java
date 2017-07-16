/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kinerjakaryawanahp.koneksi.KoneksiMySQL;
import java.sql.PreparedStatement;
import java.util.List;
import kinerjakaryawanahp.model.ModelBobotKaryawan;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;

/**
 *
 * @author taken
 */
public class DAOBobotKaryawan implements InterfaceBobotKaryawan{
    Connection conn;
    final String insert = "INSERT INTO tbl_bobotkaryawan  (id_karyawan,id_kriteria,id_subkriteria) VALUES(?,?,?)";
    final String update = "UPDATE tbl_bobotkaryawan SET id_kriteria=?, id_subkriteria=? WHERE id_karyawan=?";
    final String delete = "DELETE FROM tbl_bobotkaryawan WHERE id_karyawan=? AND id_kriteria=?";
    final String select = "SELECT a.id_kriteria, a.nama_kriteria, b.id_subkriteria, b.nama_subkriteria FROM tbl_kriteria a, tbl_subkriteria b, tbl_bobotkaryawan c WHERE c.id_kriteria=a.id_kriteria AND c.id_subkriteria=b.id_subkriteria AND c.id_karyawan=? ORDER BY b.id_kriteria";
    final String cek_isexists = "SELECT * FROM tbl_bobotkaryawan WHERE id_karyawan=? AND id_kriteria=?";
    
    public DAOBobotKaryawan(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Boolean insert(ModelBobotKaryawan m) {
        try {
            PreparedStatement statement = conn.prepareStatement(insert);
            statement.setString(1, m.getKaryawan().getIdKaryawan());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.setInt(3, m.getSubKriteria().getIdSubKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(ModelBobotKaryawan m) {
        try {
            PreparedStatement statement = conn.prepareStatement(update);
            statement.setInt(1, m.getKriteria().getIdKriteria());
            statement.setInt(2, m.getSubKriteria().getIdSubKriteria());
            statement.setString(3, m.getKaryawan().getIdKaryawan());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean delete(ModelBobotKaryawan m) {
        try {
            PreparedStatement statement = conn.prepareStatement(delete);
            statement.setString(1, m.getKaryawan().getIdKaryawan());
            statement.setInt(2, m.getKriteria().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotKaryawan> getAllBobotKaryawan(String id_karyawan) {
        List<ModelBobotKaryawan> list = null;
        try {
            list = new ArrayList<ModelBobotKaryawan>();
            PreparedStatement statement = conn.prepareStatement(select);
            statement.setString(1, id_karyawan);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ModelKriteria kriteria = new ModelKriteria();
                ModelSubKriteria subkriteria = new ModelSubKriteria();
                ModelBobotKaryawan karyawan = new ModelBobotKaryawan();
                kriteria.setIdKriteria(rs.getInt("id_kriteria"));
                kriteria.setNamaKriteria(rs.getString("nama_kriteria"));
                subkriteria.setIdSubKriteria(rs.getInt("id_subkriteria"));
                subkriteria.setNamaSubKriteria(rs.getString("nama_subkriteria"));
                subkriteria.setKriteria(kriteria);
                karyawan.setKriteria(kriteria);
                karyawan.setSubKriteria(subkriteria);
                list.add(karyawan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Boolean bobotIsExists(String id_karyawan, int id_kriteria) {
        try {
            PreparedStatement statement = conn.prepareStatement(cek_isexists);
            statement.setString(1, id_karyawan);
            statement.setInt(2, id_kriteria);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}