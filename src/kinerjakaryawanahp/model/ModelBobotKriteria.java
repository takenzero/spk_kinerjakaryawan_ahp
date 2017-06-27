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
public class ModelBobotKriteria {
    private ModelKriteria kriteria1;
    private ModelKriteria kriteria2;
    private double bobot_kriteria;
    
    public void setKriteria1(ModelKriteria kriteria1){
        this.kriteria1 = kriteria1;
    }
    
    public ModelKriteria getKriteria1(){
        return kriteria1;
    }
    
    public void setKriteria2(ModelKriteria kriteria2){
        this.kriteria2 = kriteria2;
    }
    
    public ModelKriteria getKriteria2(){
        return kriteria2;
    }
    
    public void setBobotKriteria(double bobot_kriteria){
        this.bobot_kriteria = bobot_kriteria;
    }
    
    public double getBobotKriteria(){
        return bobot_kriteria;
    }
}
