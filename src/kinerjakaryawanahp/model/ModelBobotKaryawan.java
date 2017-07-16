/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.model;

/**
 *
 * @author taken
 */
public class ModelBobotKaryawan {
    private ModelKaryawan karyawan;
    private ModelKriteria kriteria;
    private ModelSubKriteria subkriteria;
    
    public void setKaryawan(ModelKaryawan karyawan){
        this.karyawan = karyawan;
    }
    
    public ModelKaryawan getKaryawan(){
        return karyawan;
    }
    
    public void setKriteria(ModelKriteria kriteria){
        this.kriteria = kriteria;
    }
    
    public ModelKriteria getKriteria(){
        return kriteria;
    }
    
    public void setSubKriteria(ModelSubKriteria subkriteria){
        this.subkriteria = subkriteria;
    }
    
    public ModelSubKriteria getSubKriteria(){
        return subkriteria;
    }
    
}
