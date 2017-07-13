/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

/**
 *
 * @author taken
 */
import java.util.List;
import kinerjakaryawanahp.model.ModelBobotKaryawan;
import kinerjakaryawanahp.model.ModelBobotSubKriteria;

public interface InterfaceBobotKaryawan {
    public Boolean insert(ModelBobotKaryawan m);
    public Boolean update(ModelBobotKaryawan m);
    public Boolean delete(ModelBobotKaryawan m);
    public List<ModelBobotSubKriteria> getAllBobotKaryawan(int id_karyawan);
    public Boolean bobotIsExists(int id_karyawan, int id_kriteria, int id_subkriteria);
    //public List<ModelBobotSubKriteria> getBobotSelectedSubKriteria(int id_subkriteria1, int id_subkriteria2, int id_kriteria);
}
