/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

import java.util.List;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelTampilHasil;
import kinerjakaryawanahp.model.ModelTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelTampilNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelValues;

/**
 *
 * @author taken
 */
public interface InterfaceTampilNilaiKriteria {
    public List<ModelTampilNilaiKriteria> getAllNilaiBobotKriteria();
    public List<ModelValues> getValuesKriteria();
    public List<ModelTampilNilaiSubKriteria> getNilaiBobotSubKriteria(ModelKriteria m);
    public List<ModelValues> getValuesSubKriteria(ModelKriteria k);
    public List<ModelTampilHasil> getHasil();
}
