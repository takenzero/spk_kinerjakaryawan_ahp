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
public class ModelSubKriteria {
    private Integer id_subkriteria;
    private String nama_subkriteria;
    private ModelKriteria kriteria;
    
    public void setIdSubKriteria(int id_subkriteria){
        this.id_subkriteria = id_subkriteria;
    }
    
    public Integer getIdSubKriteria(){
        return id_subkriteria;
    }
    
    public void setNamaSubKriteria(String nama_subkriteria){
        this.nama_subkriteria = nama_subkriteria;
    }
    
    public String getNamaSubKriteria(){
        return nama_subkriteria;
    }
    
    public void setKriteria(ModelKriteria kriteria){
        this.kriteria = kriteria;
    }
    
    public ModelKriteria getKriteria(){
        return kriteria;
    }
}
