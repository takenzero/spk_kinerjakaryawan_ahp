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
import kinerjakaryawanahp.model.ModelBobotSubKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;
import kinerjakaryawanahp.model.ModelKriteria;

/**
 *
 * @author taken
 */
public class DAOBobotSubKriteria implements InterfaceBobotSubKriteria{
    Connection conn;
    final String insert = "INSERT INTO tbl_bobotsubkriteria (id_kriteria1, id_kriteria2, id_kriteria, bobot_kriteria) VALUES(?,?,?,?)";
    final String update = "UPDATE tbl_bobotsubkriteria SET id_subkriteria1=?, id_subkriteria2=?, bobot_subkriteria=? WHERE id_subkriteria1=? AND id_subkriteria2=? AND id_kriteria=?";
    final String delete = "DELETE FROM tbl_bobotsubkriteria WHERE id_subkriteria1=? AND id_subkriteria2=? AND id_kriteria=?";
    final String select = "SELECT k.id_kriteria AS id_kriteria, k.nama_kriteria AS nama_kriteria, s1.id_kriteria AS id_subkriteria1,s1.nama_subkriteria AS nama_subkriteria1,s2.id_subkriteria AS id_subkriteria2, s2.nama_subkriteria AS nama_subkriteria2, b.bobot_subkriteria AS bobot_subkriteria FROM tbl_kriteria k, tbl_subkriteria s1,tbl_bobotsubkriteria b LEFT JOIN tbl_subkriteria s2 ON b.id_subkriteria2=s2.id_subkriteria WHERE s1.id_subkriteria=b.id_subkriteria1 AND b.id_kriteria=k.id_kriteria ORDER BY k.id_kriteria, s1.id_subkriteria, s2.id_subkriteria ASC";
    final String cek_bobotkriteria = "SELECT * FROM tbl_bobotsubkriteria WHERE id_subkriteria1=? AND id_subkriteria2=? AND id_kriteria=?";
    
    public DAOBobotSubKriteria(){
        try {
            conn = KoneksiMySQL.connection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean insert(ModelBobotSubKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(insert);
            statement.setInt(1, m.getSubKriteria1().getIdSubKriteria());
            statement.setInt(2, m.getSubKriteria2().getIdSubKriteria());
            statement.setInt(3, m.getKriteria().getIdKriteria());
            statement.setDouble(4, m.getBobotSubKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(ModelBobotSubKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(update);
            statement.setInt(1, m.getSubKriteria1().getIdSubKriteria());
            statement.setInt(2, m.getSubKriteria2().getIdSubKriteria());
            statement.setDouble(3, m.getBobotSubKriteria());
            statement.setInt(4, m.getSubKriteria1().getIdSubKriteria());
            statement.setInt(5, m.getSubKriteria2().getIdSubKriteria());
            statement.setInt(6, m.getKriteria().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean delete(ModelBobotSubKriteria m) {
        try {
            PreparedStatement statement = conn.prepareStatement(delete);
            statement.setInt(1, m.getSubKriteria1().getIdSubKriteria());
            statement.setInt(2, m.getSubKriteria2().getIdSubKriteria());
            statement.setInt(3, m.getKriteria().getIdKriteria());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotSubKriteria> getAllBobotSubKriteria() {
        List<ModelBobotSubKriteria> list = null;
        try {
            list = new ArrayList<ModelBobotSubKriteria>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while(rs.next()){
                ModelKriteria mk = new ModelKriteria();
                mk.setIdKriteria(rs.getInt("id_kriteria"));
                mk.setNamaKriteria(rs.getString("nama_kriteria"));
                ModelBobotSubKriteria mb = new ModelBobotSubKriteria();
                ModelSubKriteria ms1 = new ModelSubKriteria();
                ModelSubKriteria ms2 = new ModelSubKriteria();
                ms1.setIdSubKriteria(rs.getInt("id_subkriteria1"));
                ms1.setNamaSubKriteria(rs.getString("nama_subkriteria1"));
                ms1.setKriteria(mk);
                ms2.setIdSubKriteria(rs.getInt("id_subkriteria2"));
                ms2.setNamaSubKriteria(rs.getString("nama_subkriteria2"));
                mb.setKriteria(mk);
                mb.setSubKriteria1(ms1);
                mb.setSubKriteria2(ms2);
                mb.setBobotSubKriteria(rs.getDouble("bobot_subkriteria"));
                list.add(mb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Boolean bobotIsExists(int id_subkriteria1, int id_subkriteria2, int id_kriteria) {
        try {
            PreparedStatement statement = conn.prepareStatement(cek_bobotkriteria);
            statement.setInt(1, id_subkriteria1);
            statement.setInt(2, id_subkriteria2);
            statement.setInt(3, id_kriteria);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBobotSubKriteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ModelBobotSubKriteria> getBobotSelectedSubKriteria(int id_kriteria1, int id_kriteria2, int id_kriteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}