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
    public void insert(ModelKaryawan m);
    
    public void update(ModelKaryawan m);
    
    public void delete(String id);
    
    public List<ModelKaryawan> getAllKaryawan();
    
    public List<ModelKaryawan> getCariKaryawan(String cari);
}
