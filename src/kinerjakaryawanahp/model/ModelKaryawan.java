/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author taken
 */

public class ModelKaryawan {
   private String id_karyawan;
   private String nama;
   private Integer kelamin;
   private Integer agama;
   private String tempat;
   private Date tgl_lahir;
   private String alamat;
   private String no_telp;
   private String cari;
   private String str_kelamin;
   private String str_agama;
   private final String[] arr_kelamin = {"Laki-Laki","Perempuan"};
   private final String[] arr_agama = {"Islam","Katolik","Protestan","Hindu","Budha","Lain"};
   private final SimpleDateFormat format_tgl = new SimpleDateFormat("dd/MM/yyyy");
   
   public void setIdKaryawan(String id_karyawan){
       this.id_karyawan = id_karyawan;
   }
   
   public String getIdKaryawan(){
       return id_karyawan;
   }
   
   public void setNama(String nama){
       this.nama = nama;
   }
   
   public String getNama(){
       return nama;
   }
   
   public void setKelamin(Integer kelamin){
       this.kelamin = kelamin;
   }
   
   public Integer getKelamin(){
       return kelamin;
   }
   
   public void setAgama(Integer agama){
       this.agama = agama;
   }
   
   public Integer getAgama(){
       return agama;
   }
   
   public void setTempat(String tempat){
       this.tempat = tempat;
   }
   
   public String getTempat(){
       return tempat;
   }
   
   public void setTglLahir(Date tgl_lahir){
       this.tgl_lahir = tgl_lahir;
   }
   
   public String getTglLahir(){
       return format_tgl.format(tgl_lahir);
   }
   
   public Date getDateTglLahir(){
       return tgl_lahir;
   }
   
   public void setAlamat(String alamat){
       this.alamat = alamat;
   }
   
   public String getAlamat(){
       return alamat;
   }
   
   public void setNoTelp(String no_telp){
       this.no_telp = no_telp;
   }
   
   public String getNoTelp(){
       return no_telp;
   }
   
   public void setCari(String cari){
       this.cari = cari;
   }
   
   public String getCari(){
       return cari;
   }
   
   public void setStrKelamin(Integer kelamin){
       this.str_kelamin = arr_kelamin[kelamin-1];
   }
   
   public String getStrKelamin(){
       return str_kelamin;
   }
   
   public void setStrAgama(Integer agama){
       this.str_agama = arr_agama[agama-1];
   }
   
   public String getStrAgama(){
       return str_agama;
   }
}
