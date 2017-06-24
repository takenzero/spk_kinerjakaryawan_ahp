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

public interface InterfaceKriteria {
    public Boolean insert(ModelKriteria m);
    public Boolean update(ModelKriteria m);
    public Boolean delete(int id_kriteria);
    public List<ModelKriteria> getAllKriteria();
}
