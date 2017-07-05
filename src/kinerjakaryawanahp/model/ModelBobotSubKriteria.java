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
public class ModelBobotSubKriteria {
    private ModelKriteria kriteria;
    private ModelSubKriteria subkriteria1;
    private ModelSubKriteria subkriteria2;
    private double bobot_subkriteria;
    
    public void setKriteria(ModelKriteria kriteria){
        this.kriteria = kriteria;
    }
    
    public ModelKriteria getKriteria(){
        return kriteria;
    }
    
    public void setSubKriteria1(ModelSubKriteria subkriteria1){
        this.subkriteria1 = subkriteria1;
    }
    
    public ModelSubKriteria getSubKriteria1(){
        return subkriteria1;
    }
    
    public void setSubKriteria2(ModelSubKriteria subkriteria2){
        this.subkriteria2 = subkriteria2;
    }
    
    public ModelSubKriteria getSubKriteria2(){
        return subkriteria2;
    }
    
    public void setBobotSubKriteria(double bobot_subkriteria){
        this.bobot_subkriteria = bobot_subkriteria;
    }
    
    public double getBobotSubKriteria(){
        return bobot_subkriteria;
    }
}
