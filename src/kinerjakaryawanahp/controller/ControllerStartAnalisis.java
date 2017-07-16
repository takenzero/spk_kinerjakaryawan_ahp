/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import Jama.Matrix;
import java.text.DecimalFormat;
import java.util.List;
import kinerjakaryawanahp.ahpprocess.ProcessAHP;
import kinerjakaryawanahp.dao.DAOBobotKriteria;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.InterfaceBobotKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.model.ModelBobotKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.view.ViewMain;

/**
 *
 * @author taken
 */
public class ControllerStartAnalisis {
    ViewMain frm;
    
    public ControllerStartAnalisis(ViewMain frm){
        this.frm = frm;
        ProcessKriteria();
    }
    
    private void ProcessKriteria(){
        InterfaceKriteria in_kriteria = new DAOKriteria();
        List<ModelKriteria> kriteria = in_kriteria.getAllKriteria();
        
        ProcessAHP processAHP = new ProcessAHP(kriteria.size());
        
        for (int i=0; i<kriteria.size(); i++){
            for(int j=i+1; j<kriteria.size(); j++){
                int id_kriteria_1 = kriteria.get(i).getIdKriteria();
                int id_kriteria_2 = kriteria.get(j).getIdKriteria();
                
                InterfaceBobotKriteria in_bobotkriteria = new DAOBobotKriteria();
                List<ModelBobotKriteria> bobot_kriteria = in_bobotkriteria.getBobotSelectedKriteria(id_kriteria_1, id_kriteria_2);
                
                if (in_bobotkriteria.bobotIsExists(id_kriteria_1, id_kriteria_2)){
                    processAHP.set(i, j, bobot_kriteria.get(0).getBobotKriteria());
                }else{
                    processAHP.set(i, j, 1);
                }
            }
        }
        
        processAHP.print();
        
        Matrix W = processAHP.getWeight();
        //DecimalFormat df = new DecimalFormat("#.##");
        //System.out.println(df.format(W.get(1, 0)));
        //W.print(processAHP.getSize(),2);
        for (int i=0; i<kriteria.size(); i++){
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(kriteria.get(i).getNamaKriteria()+" : "+df.format(W.get(i, 0)));
            //System.out.println(df.format(W.get(i, 0)));
        }
        
    }
}
