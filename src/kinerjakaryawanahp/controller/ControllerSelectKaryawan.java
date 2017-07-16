/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

/**
 *
 * @author taken
 */
import kinerjakaryawanahp.dao.DAOKaryawan;
import kinerjakaryawanahp.dao.InterfaceKaryawan;
import kinerjakaryawanahp.model.ModelKaryawan;
import kinerjakaryawanahp.model.ModelTabelKaryawan;
import kinerjakaryawanahp.view.ViewSelectKaryawan;
import java.util.List;
import kinerjakaryawanahp.view.ViewBobotKaryawan;

public class ControllerSelectKaryawan {
    ViewSelectKaryawan frm;
    InterfaceKaryawan in;
    List<ModelKaryawan> list;
    ModelKaryawan karyawan;
    
    public ControllerSelectKaryawan(ViewSelectKaryawan frm){
        this.frm = frm;
        in = new DAOKaryawan();
        list = in.getAllKaryawan();
        karyawan = new ModelKaryawan();
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
        frm.getTblKaryawan().setModel(mtk);
    }
    
    public void isiField(int row){
        karyawan = list.get(row);
    }
    
    public void cari(){
        if (!frm.getTxtCari().getText().trim().isEmpty()){
            list = in.getCariKaryawan(frm.getTxtCari().getText().trim());
            ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
            frm.getTblKaryawan().setModel(mtk);
        }else{
            list = in.getAllKaryawan();
            ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
            frm.getTblKaryawan().setModel(mtk);
        }
    }
    
    public void showBobotKaryawan(){
        this.frm.dispose();
        new ViewBobotKaryawan(karyawan).setVisible(true);
    }
}
