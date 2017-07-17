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
public class ModelNilaiKriteria {
    Integer id_kriteria;
    Double nilai_kriteria;
    
    public void setIdKriteria(int id_kriteria){
        this.id_kriteria = id_kriteria;
    }
    
    public Integer getIdKriteria(){
        return id_kriteria;
    }
    
    public void setNilaiKriteria(Double nilai_kriteria){
        this.nilai_kriteria = nilai_kriteria;
    }
    
    public Double getNilaiKriteria(){
        return nilai_kriteria;
    }
}
