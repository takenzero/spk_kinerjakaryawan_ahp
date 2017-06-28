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
        setItemsKriteria();
        reset();
    }
    
    private void setItemsKriteria(){
        frm.getCboKriteria1().setModel(new DefaultComboBoxModel(list.toArray()));
        frm.getCboKriteria2().setModel(new DefaultComboBoxModel(list.toArray()));
    }
    
    public void reset(){
        frm.getCboKriteria1().setSelectedIndex(0);
        frm.getCboKriteria2().setSelectedIndex(0);
        frm.getCboBobotKriteria().setSelectedIndex(0);
        frm.getCboBobotKriteria().setEnabled(false);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list_bobot = in_bobot.getAllBobotKriteria();
        ModelTabelBobotKriteria mtk = new ModelTabelBobotKriteria(list_bobot);
        frm.getTblBobotKriteria().setModel(mtk);
    }
    
    public void isiField(int row){
        setSelectedKriteria1(list_bobot.get(row).getKriteria1().getNamaKriteria());
        setSelectedKriteria2(list_bobot.get(row).getKriteria2().getNamaKriteria());
        frm.getCboBobotKriteria().setSelectedIndex(0);
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelBobotKriteria mb1 = new ModelBobotKriteria();
        ModelBobotKriteria mb2 = new ModelBobotKriteria();
        
        mb1.setKriteria1((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb1.setKriteria2((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb1.setBobotKriteria(Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        mb2.setKriteria1((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb2.setKriteria2((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb2.setBobotKriteria(1/Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        if (in_bobot.bobotIsExists(mb1.getKriteria1().getIdKriteria(), mb1.getKriteria2().getIdKriteria())){
            in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getKriteria1().getIdKriteria(), mb2.getKriteria2().getIdKriteria())){
            in_bobot.delete(mb2);
        }
        
        if(in_bobot.insert(mb1)){
            if (frm.getCboKriteria1().getSelectedItem().toString().equals(frm.getCboKriteria2().getSelectedItem().toString())){
                JOptionPane.showMessageDialog(frm, "Data bobot kriteria berhasil ditambahkan","Info",1);
            }else{
                if (in_bobot.insert(mb2)){
                    JOptionPane.showMessageDialog(frm, "Data bobot kriteria berhasil ditambahkan","Info",1);
                }else{
                    JOptionPane.showMessageDialog(frm, "Data bobot kriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
                }
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Data bobot kriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void update(){
        ModelBobotKriteria mb1 = new ModelBobotKriteria();
        ModelBobotKriteria mb2 = new ModelBobotKriteria();
        
        mb1.setKriteria1((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb1.setKriteria2((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb1.setBobotKriteria(Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        mb2.setKriteria1((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb2.setKriteria2((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb2.setBobotKriteria(1/Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        if (in_bobot.bobotIsExists(mb1.getKriteria1().getIdKriteria(), mb1.getKriteria2().getIdKriteria())){
            in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getKriteria1().getIdKriteria(), mb2.getKriteria2().getIdKriteria())){
            in_bobot.delete(mb2);
        }
        
        if(in_bobot.insert(mb1)){
            if (frm.getCboKriteria1().getSelectedItem().toString().equals(frm.getCboKriteria2().getSelectedItem().toString())){
                JOptionPane.showMessageDialog(frm, "perubahan data bobot kriteria berhasil disimpan","Info",1);
            }else{
                if (in_bobot.insert(mb2)){
                    JOptionPane.showMessageDialog(frm, "perubahan data bobot kriteria berhasil disimpan","Info",1);
                }else{
                    JOptionPane.showMessageDialog(frm, "Perubahan data bobot kriteria gagal disimpan. Periksa kembali data yang diinput.","Info",0);
                }
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Perubahan data bobot kriteria gagal disimpan. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void delete(){
        ModelBobotKriteria mb1 = new ModelBobotKriteria();
        ModelBobotKriteria mb2 = new ModelBobotKriteria();
        
        mb1.setKriteria1((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb1.setKriteria2((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb1.setBobotKriteria(Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        mb2.setKriteria1((ModelKriteria) frm.getCboKriteria2().getSelectedItem());
        mb2.setKriteria2((ModelKriteria) frm.getCboKriteria1().getSelectedItem());
        mb2.setBobotKriteria(1/Double.parseDouble(frm.getCboBobotKriteria().getSelectedItem().toString()));
        
        Boolean a = false;
        
        if (in_bobot.bobotIsExists(mb1.getKriteria1().getIdKriteria(), mb1.getKriteria2().getIdKriteria())){
            a = in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getKriteria1().getIdKriteria(), mb2.getKriteria2().getIdKriteria())){
            a = in_bobot.delete(mb2);
        }
        
        if (a){
            JOptionPane.showMessageDialog(frm, "Data bobot kriteria berhasil dihapus","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data bobot kriteria gagal dihapus","Info",0);
        }
    }

    private void setSelectedKriteria1(String value){
        String item;
        for(int i=0; i<frm.getCboKriteria1().getItemCount();i++){
            item = frm.getCboKriteria1().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboKriteria1().setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void setSelectedKriteria2(String value){
        String item;
        for(int i=0; i<frm.getCboKriteria2().getItemCount();i++){
            item = frm.getCboKriteria2().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboKriteria2().setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setEnabledBobot(){
        if (frm.getCboKriteria1().getSelectedItem().toString().equals(frm.getCboKriteria2().getSelectedItem().toString())){
            frm.getCboBobotKriteria().setSelectedIndex(0);
            frm.getCboBobotKriteria().setEnabled(false);
        }else{
            frm.getCboBobotKriteria().setSelectedIndex(2);
            frm.getCboBobotKriteria().setEnabled(true);
        }
    }
}
