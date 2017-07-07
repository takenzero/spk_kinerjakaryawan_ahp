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
import kinerjakaryawanahp.model.ModelKaryawan;

public interface InterfaceKaryawan {
    public Boolean insert(ModelKaryawan m);
    
    public Boolean update(ModelKaryawan m);
    
    public Boolean delete(String id);
    
    public List<ModelKaryawan> getAllKaryawan();
    
    public List<ModelKaryawan> getCariKaryawan(String cari);
}
