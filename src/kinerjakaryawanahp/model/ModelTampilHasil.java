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
public class ModelTampilHasil {
    private String id_karyawan;
    private String nama_karyawan;
    private Double nilai;
    
    public void setIdKaryawan(String id_karyawan){
        this.id_karyawan = id_karyawan;
    }
    
    public String getIdKaryawan(){
        return id_karyawan;
    }
    
    public void setNamaKaryawan(String nama_karyawan){
        this.nama_karyawan = nama_karyawan;
    }
    
    public String getNamaKaryawan(){
        return nama_karyawan;
    }
    
    public void setNilai(Double nilai){
        this.nilai = nilai;
    }
    
    public Double getNilai(){
        return nilai;
    }
}
