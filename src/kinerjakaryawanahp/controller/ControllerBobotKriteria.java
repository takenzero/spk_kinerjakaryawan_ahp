/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.dao.DAOBobotKriteria;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.InterfaceBobotKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.model.ModelBobotKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelTabelBobotKriteria;
import kinerjakaryawanahp.view.ViewBobotKriteria;
/**
 *
 * @author taken
 */
public class ControllerBobotKriteria {
    ViewBobotKriteria frm;
    InterfaceKriteria in;
    InterfaceBobotKriteria in_bobot;
    List<ModelKriteria> list;
    List<ModelBobotKriteria> list_bobot;
    
    public ControllerBobotKriteria(ViewBobotKriteria frm){
        this.frm = frm;
        in = new DAOKriteria();
        in_bobot = new DAOBobotKriteria();
        list = in.getAllKriteria();
        list_bobot = in_bobot.getAllBobotKriteria();
        reset();
    }
    
    private void setKriteria(){
        frm.getCboKriteria1().setModel(new DefaultComboBoxModel(list.toArray()));
        frm.getCboKriteria2().setModel(new DefaultComboBoxModel(list.toArray()));
    }
    
    
    public void reset(){
        //list = in.getAllKriteria();
        setKriteria();
        frm.getCboBobotKriteria().setSelectedIndex(0);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list_bobot = in_bobot.getAllBobotKriteria();
        ModelTabelBobotKriteria mtk = new ModelTabelBobotKriteria(list_bobot);
        frm.getTblBobotKriteria().setModel(mtk);
    }
    /*
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
*/
}
