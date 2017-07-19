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
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelTampilHasil;
import kinerjakaryawanahp.model.ModelTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelTampilNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelValues;

/**
 *
 * @author taken
 */
public class DAOTampilNilaiKriteria implements InterfaceTampilNilaiKriteria{
    Connection conn;
    final String select_kriteria = "SELECT a.id_kriteria, a.nama_kriteria, b.nilai FROM tbl_kriteria a, tbl_nilaibobotkriteria b WHERE b.id_kriteria=a.id_kriteria";
    final String select_valueskriteria = "SELECT * FROM tbl_values WHERE flag=?";
    final String select_subkriteria = "SELECT a.id_kriteria, a.nama_kriteria, b.id_subkriteria, b.nama_subkriteria, c.nilai FROM tbl_kriteria a, tbl_subkriteria b, tbl_nilaibobotsubkriteria c WHERE b.id_kriteria=a.id_kriteria AND c.id_subkriteria=b.id_subkriteria AND b.id_kriteria=?";
    final String select_valuessubkriteria = "SELECT * FROM tbl_values WHERE flag=? AND id=?";
    final String select_hasil = "SELECT a.id_karyawan, a.nama AS nama_karyawan, b.nilai FROM tbl_karyawan a, tbl_hasil b WHERE b.id_karyawan=a.id_karyawan ORDER BY b.nilai DESC";
    
    public DAOTampilNilaiKriteria() {
        try {
            this.conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<ModelTampilNilaiKriteria> getAllNilaiBobotKriteria() {
        List<ModelTampilNilaiKriteria> list = new ArrayList<ModelTampilNilaiKriteria>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(select_kriteria);
            while(rs.next()){
                ModelTampilNilaiKriteria m = new ModelTampilNilaiKriteria();
                m.setIdKriteria(rs.getInt("id_kriteria"));
                m.setNamaKriteria(rs.getString("nama_kriteria"));
                m.setNilaiKriteria(rs.getDouble("nilai"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<ModelValues> getValuesKriteria() {
        List<ModelValues> list = new ArrayList<ModelValues>();
        try {
            PreparedStatement stm = conn.prepareStatement(select_valueskriteria);
            stm.setInt(1, 1);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                ModelValues m = new ModelValues();
                m.setMaxEigenValue(rs.getDouble("max_eigen_value"));
                m.setInconsistencyIndex(rs.getDouble("inconsistency_index"));
                m.setRandomInconsistency(rs.getDouble("random_inconsistency"));
                m.setInconsistencyRatio(rs.getDouble("inconsistency_ratio"));
                m.setFlag(rs.getInt("flag"));
                m.setId(rs.getInt("id"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<ModelTampilNilaiSubKriteria> getNilaiBobotSubKriteria(ModelKriteria m) {
        List<ModelTampilNilaiSubKriteria> list = new ArrayList<ModelTampilNilaiSubKriteria>();
        try {
            PreparedStatement stm = conn.prepareStatement(select_subkriteria);
            stm.setInt(1, m.getIdKriteria());
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                ModelTampilNilaiSubKriteria s = new ModelTampilNilaiSubKriteria();
                ModelKriteria k = new ModelKriteria();
                k.setIdKriteria(rs.getInt("id_kriteria"));
                k.setNamaKriteria(rs.getString("nama_kriteria"));
                s.setKriteria(k);
                s.setIdSubKriteria(rs.getInt("id_subkriteria"));
                s.setNamaSubKriteria(rs.getString("nama_subkriteria"));
                s.setNilaiSubKriteria(rs.getDouble("nilai"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<ModelValues> getValuesSubKriteria(ModelKriteria k) {
        List<ModelValues> list = new ArrayList<ModelValues>();
        try {
            PreparedStatement stm = conn.prepareStatement(select_valuessubkriteria);
            stm.setInt(1, 2);
            stm.setInt(2, k.getIdKriteria());
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                ModelValues m = new ModelValues();
                m.setMaxEigenValue(rs.getDouble("max_eigen_value"));
                m.setInconsistencyIndex(rs.getDouble("inconsistency_index"));
                m.setRandomInconsistency(rs.getDouble("random_inconsistency"));
                m.setInconsistencyRatio(rs.getDouble("inconsistency_ratio"));
                m.setFlag(rs.getInt("flag"));
                m.setId(rs.getInt("id"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<ModelTampilHasil> getHasil() {
        List<ModelTampilHasil> list = new ArrayList<ModelTampilHasil>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(select_hasil);
            while(rs.next()){
                ModelTampilHasil m = new ModelTampilHasil();
                m.setIdKaryawan(rs.getString("id_karyawan"));
                m.setNamaKaryawan(rs.getString("nama_karyawan"));
                m.setNilai(rs.getDouble("nilai"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTampilNilaiKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
