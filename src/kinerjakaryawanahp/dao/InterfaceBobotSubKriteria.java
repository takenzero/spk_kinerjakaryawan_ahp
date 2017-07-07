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
import kinerjakaryawanahp.model.ModelBobotSubKriteria;

public interface InterfaceBobotSubKriteria {
    public Boolean insert(ModelBobotSubKriteria m);
    public Boolean update(ModelBobotSubKriteria m);
    public Boolean delete(ModelBobotSubKriteria m);
    public List<ModelBobotSubKriteria> getAllBobotSubKriteria();
    public Boolean bobotIsExists(int id_subkriteria1, int id_subkriteria2, int id_kriteria);
    public List<ModelBobotSubKriteria> getBobotSelectedSubKriteria(int id_subkriteria1, int id_subkriteria2, int id_kriteria);
}
