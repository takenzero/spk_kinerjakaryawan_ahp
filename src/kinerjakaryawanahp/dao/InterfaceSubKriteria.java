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
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;

public interface InterfaceSubKriteria {
    public Boolean insert(ModelSubKriteria m);
    public Boolean update(ModelSubKriteria m);
    public Boolean delete(int id_kriteria);
    public List<ModelSubKriteria> getAllSubKriteria();
    public List<ModelSubKriteria> getSubKriteriaById(ModelKriteria m);
}
