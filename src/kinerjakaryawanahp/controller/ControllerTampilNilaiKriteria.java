/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import kinerjakaryawanahp.dao.DAOTampilNilaiKriteria;
import kinerjakaryawanahp.dao.InterfaceTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelTabelTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelValues;
import kinerjakaryawanahp.view.ViewNilaiBobot;
/**
 *
 * @author taken
 */
public class ControllerTampilNilaiKriteria {
    ViewNilaiBobot frm;
    InterfaceTampilNilaiKriteria in;
    List<ModelTampilNilaiKriteria> list_nilai;
    ModelValues mv;
    DecimalFormat df;
    
    public ControllerTampilNilaiKriteria(ViewNilaiBobot frm){
        this.frm = frm;
        in = new DAOTampilNilaiKriteria();
        list_nilai = in.getAllNilaiBobotKriteria();
        mv = in.getValuesKriteria().get(0);
        df = new DecimalFormat("#.##");
    }
    
    public void isiTable(){
        list_nilai = in.getAllNilaiBobotKriteria();
        ModelTabelTampilNilaiKriteria mtk = new ModelTabelTampilNilaiKriteria(list_nilai);
        frm.getTblNilaiKriteria().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(){
        mv = in.getValuesKriteria().get(0);
        frm.getTxtMaxEigenValueKriteria().setText(df.format(mv.getMaxEigenValue()));
        frm.getTxtInconsistencyIndexKriteria().setText(df.format(mv.getInconsistencyIndex()));
        frm.getTxtRandomInconsistencyKriteria().setText(df.format(mv.getRandomInconsistency()));
        frm.getTxtInconsistencyRatioKriteria().setText(df.format(mv.getInconsistencyRatio()));
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblNilaiKriteria();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(50);
    }
}
