/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.dao;

import java.util.List;
import kinerjakaryawanahp.model.ModelNilaiKaryawan;
import kinerjakaryawanahp.model.ModelNilaiKriteria;
import kinerjakaryawanahp.model.ModelNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelValues;

/**
 *
 * @author taken
 */
public interface InterfaceNilaiBobot {
    public Boolean insertNilaiKriteria(ModelNilaiKriteria kriteria);
    public Boolean insertNilaiSubKriteria(ModelNilaiSubKriteria subkriteria);
    public Boolean insertNilaiKaryawan(ModelNilaiKaryawan karyawan);
    public Boolean insertValues(ModelValues values);
    public List<ModelNilaiKaryawan> getNilaiKaryawan();
    public void clearTable();
}
