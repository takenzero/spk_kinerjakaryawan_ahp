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
public class ModelKriteria {
    private Integer id_kriteria;
    private String nama_kriteria;
    
    public void setIdKriteria(int id_kriteria){
        this.id_kriteria = id_kriteria;
    }
    
    public Integer getIdKriteria(){
        return id_kriteria;
    }
    
    public void setNamaKriteria(String nama_kriteria){
        this.nama_kriteria = nama_kriteria;
    }
    
    public String getNamaKriteria(){
        return nama_kriteria;
    }
    
    @Override
    public String toString(){
        return nama_kriteria;
    }
}
