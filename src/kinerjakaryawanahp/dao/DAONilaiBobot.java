/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import kinerjakaryawanahp.koneksi.KoneksiMySQL;
import kinerjakaryawanahp.model.ModelNilaiKaryawan;
import kinerjakaryawanahp.model.ModelNilaiKriteria;
import kinerjakaryawanahp.model.ModelNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelValues;

/**
 *
 * @author taken
 */
public class DAONilaiBobot implements InterfaceNilaiBobot{
    Connection conn;
    final String insertKriteria = "INSERT INTO tbl_nilaibobotkriteria (id_kriteria, nilai) VALUES(?,?)";
    final String insertSubKriteria = "INSERT INTO tbl_nilaibobotsubkriteria (id_subkriteria, id_kriteria, nilai) VALUES(?,?,?)";
    final String insertKaryawan = "INSERT INTO tbl_hasil (id_karyawan, nilai) VALUES(?,?)";
    final String insertValues = "INSERT INTO tbl_values(max_eigen_value,inconsistency_index,random_inconsistency,inconsistency_ratio,flag,id) VALUES(?,?,?,?,?,?)";
    final String clearNilaiKriteria = "DELETE FROM tbl_nilaibobotkriteria";
    final String clearNilaiSubKriteria = "DELETE FROM tbl_nilaibobotsubkriteria";
    final String clearNilaiKaryawan = "DELETE FROM tbl_hasil";
    
    public DAONilaiBobot() {
        try {
            this.conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @Override
    public Boolean insertNilaiKriteria(ModelNilaiKriteria kriteria) {
        try {
            PreparedStatement statement = conn.prepareStatement(insertKriteria);
            statement.setInt(1, kriteria.getIdKriteria());
            statement.setDouble(2, kriteria.getNilaiKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean insertNilaiSubKriteria(ModelNilaiSubKriteria subkriteria) {
        try {
            PreparedStatement statement = conn.prepareStatement(insertSubKriteria);
            statement.setInt(1, subkriteria.getIdSubKriteria());
            statement.setInt(2, subkriteria.getIdKriteria());
            statement.setDouble(3, subkriteria.getNilaiSubKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean insertNilaiKaryawan(ModelNilaiKaryawan karyawan) {
        try {
            PreparedStatement statement = conn.prepareStatement(insertKaryawan);
            statement.setString(1, karyawan.getIdKaryawan());
            statement.setDouble(2, karyawan.getNilaiKaryawan());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void clearTable() {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(clearNilaiKriteria);
            stm.executeUpdate(clearNilaiSubKriteria);
            stm.executeUpdate(clearNilaiKaryawan);
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Boolean insertValues(ModelValues values) {
        try {
            PreparedStatement statement = conn.prepareStatement(insertValues);
            statement.setDouble(1, values.getMaxEigenValue());
            statement.setDouble(2, values.getInconsistencyIndex());
            statement.setDouble(3, values.getRandomInconsistency());
            statement.setDouble(4, values.getInconsistencyRatio());
            statement.setInt(5, values.getFlag());
            statement.setInt(6, values.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAONilaiBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
