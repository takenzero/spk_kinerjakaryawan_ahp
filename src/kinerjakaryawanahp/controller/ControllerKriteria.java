/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.util.List;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelTabelKriteria;
import kinerjakaryawanahp.view.ViewKriteria;
/**
 *
 * @author taken
 */
public class ControllerKriteria {
    ViewKriteria frm;
    InterfaceKriteria in;
    List<ModelKriteria> list;
    
    public ControllerKriteria(ViewKriteria frm){
        this.frm = frm;
        reset();
        in = new DAOKriteria();
        list = in.getAllKriteria();
    }
    
    public void reset(){
        frm.getTxtIdKriteria().setText("");
        frm.getTxtNamaKriteria().setText("");
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list = in.getAllKriteria();
        ModelTabelKriteria mtk = new ModelTabelKriteria(list);
        frm.getTblKriteria().setModel(mtk);
    }
    
    public void isiField(int row){
        frm.getTxtIdKriteria().setText(list.get(row).getIdKriteria().toString());
        frm.getTxtNamaKriteria().setText(list.get(row).getNamaKriteria());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelKriteria mk = new ModelKriteria();
        
        if(!frm.getTxtNamaKriteria().getText().trim().isEmpty()){
            mk.setNamaKriteria(frm.getTxtNamaKriteria().getText().trim());
            if(in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data kriteria berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data kriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama Kriteria harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelKriteria mk = new ModelKriteria();
        
        if(!frm.getTxtNamaKriteria().getText().trim().isEmpty()){
            mk.setIdKriteria(Integer.parseInt(frm.getTxtIdKriteria().getText().trim()));
            mk.setNamaKriteria(frm.getTxtNamaKriteria().getText().trim());
            if(in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data kriteria berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data kriteria gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Nama Kriteria harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (in.delete(Integer.parseInt(frm.getTxtIdKriteria().getText().trim()))){
            JOptionPane.showMessageDialog(frm, "Data kriteria berhasil dihapus.","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data kriteria gagal dihapus","Info",0);
        }
    }
}
