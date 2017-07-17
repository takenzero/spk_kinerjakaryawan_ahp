/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import Jama.Matrix;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.ahpprocess.ProcessAHP;
import kinerjakaryawanahp.dao.DAOBobotKriteria;
import kinerjakaryawanahp.dao.DAOBobotSubKriteria;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.DAONilaiBobot;
import kinerjakaryawanahp.dao.DAOSubKriteria;
import kinerjakaryawanahp.dao.InterfaceBobotKriteria;
import kinerjakaryawanahp.dao.InterfaceBobotSubKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.dao.InterfaceNilaiBobot;
import kinerjakaryawanahp.dao.InterfaceSubKriteria;
import kinerjakaryawanahp.model.ModelBobotKriteria;
import kinerjakaryawanahp.model.ModelBobotSubKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelNilaiKaryawan;
import kinerjakaryawanahp.model.ModelNilaiKriteria;
import kinerjakaryawanahp.model.ModelNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;
import kinerjakaryawanahp.model.ModelValues;
import kinerjakaryawanahp.view.ViewMain;

/**
 *
 * @author taken
 */
public class ControllerStartAnalisis {
    ViewMain frm;
    InterfaceNilaiBobot in_nilaibobot;
    final Integer FLAG_KRITERIA = 1;
    final Integer FLAG_SUBKRITERIA = 2;
    final Integer DEFAULT_ID = 0;
    
    public ControllerStartAnalisis(ViewMain frm){
        this.frm = frm;
        this.in_nilaibobot = new DAONilaiBobot();
        in_nilaibobot.clearTable();
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
        
        //processAHP.print();
        
        Matrix W = processAHP.getWeight();
        for (int i=0; i<kriteria.size(); i++){
            ModelNilaiKriteria mk = new ModelNilaiKriteria();
            mk.setIdKriteria(kriteria.get(i).getIdKriteria());
            mk.setNilaiKriteria(W.get(i, 0));
            
            in_nilaibobot.insertNilaiKriteria(mk);
            
            //DecimalFormat df = new DecimalFormat("#.##");
            //System.out.println(kriteria.get(i).getNamaKriteria()+" : "+df.format(W.get(i, 0)));
        }
        
        ModelValues values = new ModelValues();
        values.setMaxEigenValue(processAHP.getMaxEigenValue());
        values.setInconsistencyIndex(processAHP.getInconsistencyIndex());
        values.setRandomInconsistency(processAHP.getRandomInconsistency());
        values.setInconsistencyRatio(processAHP.getInconsistencyRatio());
        values.setFlag(FLAG_KRITERIA);
        values.setId(DEFAULT_ID);
        in_nilaibobot.insertValues(values);
        
        ProcessSubKriteria();
    }
    
    private void ProcessSubKriteria(){
        InterfaceKriteria in_kriteria = new DAOKriteria();
        InterfaceSubKriteria in_subkriteria = new DAOSubKriteria();
        List<ModelKriteria> kriteria = in_kriteria.getAllKriteria();
        List<ModelSubKriteria> subkriteria;
        
        for (int i=0; i<kriteria.size(); i++){
            subkriteria = in_subkriteria.getAllSubKriteria(kriteria.get(i).getIdKriteria());
            ProcessAHP processAHP = new ProcessAHP(subkriteria.size());
            
            int id_kriteria = kriteria.get(i).getIdKriteria();
            
            for (int j=0; j<subkriteria.size(); j++){
                for (int k=j+1; k<subkriteria.size(); k++){
                    int id_subkriteria1 = subkriteria.get(j).getIdSubKriteria();
                    int id_subkriteria2 = subkriteria.get(k).getIdSubKriteria();
                    
                    InterfaceBobotSubKriteria in_bobotsubkriteria = new DAOBobotSubKriteria();
                    List<ModelBobotSubKriteria> bobot_subkriteria = in_bobotsubkriteria.getBobotSelectedSubKriteria(id_subkriteria1, id_subkriteria2, id_kriteria);
                    
                    if (in_bobotsubkriteria.bobotIsExists(id_subkriteria1, id_subkriteria2, id_kriteria)){
                        processAHP.set(j, k, bobot_subkriteria.get(0).getBobotSubKriteria());
                    }else{
                        processAHP.set(j, k, 1);
                    }
                }
            }
            
            //processAHP.print();
            
            Matrix W = processAHP.getWeight();
            for (int j=0; j<subkriteria.size(); j++){
                ModelNilaiSubKriteria ms = new ModelNilaiSubKriteria();
                ms.setIdSubKriteria(subkriteria.get(j).getIdSubKriteria());
                ms.setIdKriteria(id_kriteria);
                ms.setNilaiSubKriteria(W.get(j, 0));
                
                in_nilaibobot.insertNilaiSubKriteria(ms);
                //DecimalFormat df = new DecimalFormat("#.##");
                //System.out.println(subkriteria.get(j).getNamaSubKriteria()+" : "+df.format(W.get(j, 0)));
            }
            
            ModelValues values = new ModelValues();
            values.setMaxEigenValue(processAHP.getMaxEigenValue());
            values.setInconsistencyIndex(processAHP.getInconsistencyIndex());
            values.setRandomInconsistency(processAHP.getRandomInconsistency());
            values.setInconsistencyRatio(processAHP.getInconsistencyRatio());
            values.setFlag(FLAG_SUBKRITERIA);
            values.setId(id_kriteria);
            in_nilaibobot.insertValues(values);
        }
        ProcessKaryawan();
    }
    
    private void ProcessKaryawan(){
        List<ModelNilaiKaryawan> list = in_nilaibobot.getNilaiKaryawan();
        
        for(int i=0; i<list.size(); i++){
            ModelNilaiKaryawan k = list.get(i);
            in_nilaibobot.insertNilaiKaryawan(k);
        }
        JOptionPane.showMessageDialog(frm, "Proses perhitungan nilai kinerja karyawan selesai.","Info",1);
    }
}
