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
import kinerjakaryawanahp.model.ModelBobotKriteria;
import kinerjakaryawanahp.model.ModelKriteria;

/**
 *
 * @author taken
 */
public class DAOBobotKriteria implements InterfaceBobotKriteria{
    Connection conn;
    final String insert = "INSERT INTO tbl_bobotkriteria (id_kriteria1, id_kriteria2, bobot_kriteria) VALUES(?,?,?)";
    final String update = "UPDATE tbl_bobotkriteria SET id_kriteria1=?, id_kriteria2=?, bobot_kriteria=? WHERE id_kriteria1=? AND id_kriteria2=?";
    final String delete = "DELETE FROM tbl_bobotkriteria WHERE id_kriteria1=? AND id_kriteria2=?";
    final String select = "SELECT k1.id_kriteria AS id_kriteria1,k1.nama_kriteria AS nama_kriteria1,k2.id_kriteria AS id_kriteria2, k2.nama_kriteria AS nama_kriteria2, b.bobot_kriteria AS bobot_kriteria FROM tbl_kriteria k1,tbl_bobotkriteria b LEFT JOIN tbl_kriteria k2 ON b.id_kriteria2=k2.id_kriteria WHERE k1.id_kriteria=b.id_kriteria1 ORDER BY k1.id_kriteria, k2.id_kriteria ASC";
    final String cek_bobotkriteria = "SELECT * FROM tbl_bobotkriteria WHERE id_kriteria1=? AND id_kriteria2=?";
    final String selected_kriteria = "SELECT k1.id_kriteria AS id_kriteria1,k1.nama_kriteria AS nama_kriteria1,k2.id_kriteria AS id_kriteria2, k2.nama_kriteria AS nama_kriteria2, b.bobot_kriteria AS bobot_kriteria FROM tbl_kriteria k1,tbl_bobotkriteria b LEFT JOIN tbl_kriteria k2 ON b.id_kriteria2=k2.id_kriteria WHERE k1.id_kriteria=b.id_kriteria1 AND b.id_kriteria1=? AND b.id_kriteria2=? ORDER BY k1.id_kriteria, k2.id_kriteria ASC";
    
    public DAOBobotKriteria(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelBobotKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(insert);
            statement.setInt(1, m.getKriteria1().getIdKriteria());
            statement.setInt(2, m.getKriteria2().getIdKriteria());
            statement.setDouble(3, m.getBobotKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(ModelBobotKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(update);
            statement.setInt(1, m.getKriteria1().getIdKriteria());
            statement.setInt(2, m.getKriteria2().getIdKriteria());
            statement.setDouble(3, m.getBobotKriteria());
            statement.setInt(4, m.getKriteria1().getIdKriteria());
            statement.setInt(5, m.getKriteria2().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean delete(ModelBobotKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(delete);
            statement.setInt(1, m.getKriteria1().getIdKriteria());
            statement.setInt(2, m.getKriteria2().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotKriteria> getAllBobotKriteria() {
        List<ModelBobotKriteria> list = null;
        try {
            list = new ArrayList<ModelBobotKriteria>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while(rs.next()){
                ModelBobotKriteria mb = new ModelBobotKriteria();
                ModelKriteria mk1 = new ModelKriteria();
                ModelKriteria mk2 = new ModelKriteria();
                mk1.setIdKriteria(rs.getInt("id_kriteria1"));
                mk1.setNamaKriteria(rs.getString("nama_kriteria1"));
                mk2.setIdKriteria(rs.getInt("id_kriteria2"));
                mk2.setNamaKriteria(rs.getString("nama_kriteria2"));
                mb.setKriteria1(mk1);
                mb.setKriteria2(mk2);
                mb.setBobotKriteria(rs.getDouble("bobot_kriteria"));
                list.add(mb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Boolean bobotIsExists(int id_kriteria1, int id_kriteria2) {
        try {
            PreparedStatement statement = conn.prepareStatement(cek_bobotkriteria);
            statement.setInt(1, id_kriteria1);
            statement.setInt(2, id_kriteria2);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotKriteria> getBobotSelectedKriteria(int id_kriteria1, int id_kriteria2) {
        List<ModelBobotKriteria> list = null;
        try {
            list = new ArrayList<ModelBobotKriteria>();
            PreparedStatement stm = conn.prepareStatement(selected_kriteria);
            stm.setInt(1, id_kriteria1);
            stm.setInt(2, id_kriteria2);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                ModelBobotKriteria mb = new ModelBobotKriteria();
                ModelKriteria mk1 = new ModelKriteria();
                ModelKriteria mk2 = new ModelKriteria();
                mk1.setIdKriteria(rs.getInt("id_kriteria1"));
                mk1.setNamaKriteria(rs.getString("nama_kriteria1"));
                mk2.setIdKriteria(rs.getInt("id_kriteria2"));
                mk2.setNamaKriteria(rs.getString("nama_kriteria2"));
                mb.setKriteria1(mk1);
                mb.setKriteria2(mk2);
                mb.setBobotKriteria(rs.getDouble("bobot_kriteria"));
                list.add(mb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
