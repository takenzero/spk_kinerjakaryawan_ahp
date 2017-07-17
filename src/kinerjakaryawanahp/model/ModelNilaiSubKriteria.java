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
public class ModelNilaiSubKriteria {
    Integer id_subkriteria;
    Integer id_kriteria;
    Double nilai_subkriteria;
    
    public void setIdSubKriteria(int id_subkriteria){
        this.id_subkriteria = id_subkriteria;
    }
    
    public Integer getIdSubKriteria(){
        return id_subkriteria;
    }
    
    public void setIdKriteria(int id_kriteria){
        this.id_kriteria = id_kriteria;
    }
    
    public Integer getIdKriteria(){
        return id_kriteria;
    }
    
    public void setNilaiSubKriteria(Double nilai_subkriteria){
        this.nilai_subkriteria = nilai_subkriteria;
    }
    
    public Double getNilaiSubKriteria(){
        return nilai_subkriteria;
    }
}
