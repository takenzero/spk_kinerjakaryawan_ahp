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
import java.util.Date;
import kinerjakaryawanahp.dao.DAOKaryawan;
import kinerjakaryawanahp.dao.InterfaceKaryawan;
import kinerjakaryawanahp.model.ModelKaryawan;
import kinerjakaryawanahp.model.ModelTabelKaryawan;
import kinerjakaryawanahp.view.ViewSelectKaryawan;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerSelectKaryawan {
    ViewSelectKaryawan frm;
    InterfaceKaryawan in;
    List<ModelKaryawan> list;
    
    public ControllerSelectKaryawan(ViewSelectKaryawan frm){
        this.frm = frm;
        in = new DAOKaryawan();
        list = in.getAllKaryawan();
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
        frm.getTblKaryawan().setModel(mtk);
    }
    
    public void isiField(int row){
        /*frm.getTxtIdKaryawan().setText(list.get(row).getIdKaryawan());
        frm.getTxtNama().setText(list.get(row).getNama());
        frm.getCboKelamin().setSelectedItem(list.get(row).getStrKelamin());
        frm.getCboAgama().setSelectedItem(list.get(row).getStrAgama());
        frm.getTxtTempat().setText(list.get(row).getTempat());
        frm.getDteTanggal().setDate(list.get(row).getTglLahir());
        frm.getTxtAlamat().setText(list.get(row).getAlamat());
        frm.getTxtNoTelp().setText(list.get(row).getNoTelp());*/
        ModelKaryawan a = list.get(row);
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
}
