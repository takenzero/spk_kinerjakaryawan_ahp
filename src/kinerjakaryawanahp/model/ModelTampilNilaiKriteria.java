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
public class ModelTampilNilaiKriteria {
    private Integer id_kriteria;
    private String nama_kriteria;
    private Double nilai_kriteria;
    
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
    
    public void setNilaiKriteria(Double nilai_kriteria){
        this.nilai_kriteria = nilai_kriteria;
    }
    
    public Double getNilaiKriteria(){
        return nilai_kriteria;
    }
    
    @Override
    public String toString(){
        return nama_kriteria;
    }
}
