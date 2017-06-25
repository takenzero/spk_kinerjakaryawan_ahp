/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.dao.DAOSubKriteria;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.dao.InterfaceSubKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;
import kinerjakaryawanahp.model.ModelTabelSubKriteria;
import kinerjakaryawanahp.view.ViewSubKriteria;
/**
 *
 * @author taken
 */
public class ControllerSubKriteria {
    ViewSubKriteria frm;
    InterfaceSubKriteria in;
    InterfaceKriteria in_kriteria;
    List<ModelSubKriteria> list;
    List<ModelKriteria> list_kriteria;
    
    public ControllerSubKriteria(ViewSubKriteria frm){
        this.frm = frm;
        in_kriteria = new DAOKriteria();
        list_kriteria = in_kriteria.getAllKriteria();
        in = new DAOSubKriteria();
        list = in.getAllSubKriteria();
        setKriteria(list_kriteria);
        reset();
    }
    
    private void setKriteria(List<ModelKriteria> list_kriteria){
        JOptionPane.showMessageDialog(frm, list_kriteria.toString(),"Info",2);
        //frm.getCboKriteria().setModel(new DefaultComboBoxModel(list_kriteria.toArray()));
    }
    
    public void reset(){
        frm.getTxtIdSubKriteria().setText("");
        frm.getTxtNamaSubKriteria().setText("");
        frm.getCboKriteria().setSelectedIndex(0);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list = in.getAllSubKriteria();
        ModelTabelSubKriteria mtk = new ModelTabelSubKriteria(list);
        frm.getTblSubKriteria().setModel(mtk);
    }
    
    public void isiField(int row){
        frm.getTxtIdSubKriteria().setText(list.get(row).getIdSubKriteria().toString());
        frm.getTxtNamaSubKriteria().setText(list.get(row).getNamaSubKriteria());
        frm.getCboKriteria().setSelectedItem(list.get(row).getKriteria().getNamaKriteria());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelSubKriteria mk = new ModelSubKriteria();
        
        if(!frm.getTxtNamaSubKriteria().getText().trim().isEmpty()){
            mk.setNamaSubKriteria(frm.getTxtNamaSubKriteria().getText().trim());
            mk.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
            if(in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data subkriteria berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data subkriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama subKriteria harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelSubKriteria mk = new ModelSubKriteria();
        
        if(!frm.getTxtNamaSubKriteria().getText().trim().isEmpty()){
            mk.setIdSubKriteria(Integer.parseInt(frm.getTxtIdSubKriteria().getText().trim()));
            mk.setNamaSubKriteria(frm.getTxtNamaSubKriteria().getText().trim());
            mk.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
            if(in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data subkriteria berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data subkriteria gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama subkriteria harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (in.delete(Integer.parseInt(frm.getTxtIdSubKriteria().getText().trim()))){
            JOptionPane.showMessageDialog(frm, "Data subkriteria berhasil dihapus.","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data subkriteria gagal dihapus","Info",0);
        }
    }
}
