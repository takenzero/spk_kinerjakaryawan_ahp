/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.DAOTampilNilaiKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.dao.InterfaceTampilNilaiKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelTabelTampilNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelTampilNilaiSubKriteria;
import kinerjakaryawanahp.model.ModelValues;
import kinerjakaryawanahp.view.ViewNilaiBobot;
/**
 *
 * @author taken
 */
public class ControllerTampilNilaiSubKriteria {
    ViewNilaiBobot frm;
    InterfaceTampilNilaiKriteria in;
    List<ModelTampilNilaiSubKriteria> list_nilai;
    InterfaceKriteria in_kriteria;
    List<ModelKriteria> list_kriteria;
    ModelKriteria kriteria;
    ModelValues mv;
    DecimalFormat df;
    
    public ControllerTampilNilaiSubKriteria(ViewNilaiBobot frm){
        this.frm = frm;
        in_kriteria = new DAOKriteria();
        list_kriteria = in_kriteria.getAllKriteria();
        setKriteria(list_kriteria);
        kriteria = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        in = new DAOTampilNilaiKriteria();
        list_nilai = in.getNilaiBobotSubKriteria(kriteria);
        mv = in.getValuesSubKriteria(kriteria).get(0);
        df = new DecimalFormat("#.##");
    }
    
    public void isiTable(){
        kriteria = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        list_nilai = in.getNilaiBobotSubKriteria(kriteria);
        ModelTabelTampilNilaiSubKriteria mtk = new ModelTabelTampilNilaiSubKriteria(list_nilai);
        frm.getTblNilaiSubKriteria().setModel(mtk);
        setTableColumnSize();
    }
    
    public void isiField(){
        mv = in.getValuesSubKriteria(kriteria).get(0);
        frm.getTxtMaxEigenValueSubKriteria().setText(df.format(mv.getMaxEigenValue()));
        frm.getTxtInconsistencyIndexSubKriteria().setText(df.format(mv.getInconsistencyIndex()));
        frm.getTxtRandomInconsistencySubKriteria().setText(df.format(mv.getRandomInconsistency()));
        frm.getTxtInconsistencyRatioSubKriteria().setText(df.format(mv.getInconsistencyRatio()));
    }
    
    private void setKriteria(List<ModelKriteria> list_kriteria){
        frm.getCboKriteria().setModel(new DefaultComboBoxModel(list_kriteria.toArray()));
        frm.getCboKriteria().setSelectedIndex(0);
    }
    
    public void setTableColumnSize(){
        JTable tbl = frm.getTblNilaiKriteria();
        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(50);
    }
}
