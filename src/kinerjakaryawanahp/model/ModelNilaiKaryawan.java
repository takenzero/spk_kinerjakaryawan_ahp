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
public class ModelNilaiKaryawan {
    public String id_karyawan;
    public Double nilai_karyawan;
    
    public void setIdKaryawan(String id_karyawan){
        this.id_karyawan = id_karyawan;
    }
    
    public String getIdKaryawan(){
        return id_karyawan;
    }
    
    public void setNilaiKaryawan(Double nilai_karyawan){
        this.nilai_karyawan = nilai_karyawan;
    }
    
    public Double getNilaiKaryawan(){
        return nilai_karyawan;
    }
}
