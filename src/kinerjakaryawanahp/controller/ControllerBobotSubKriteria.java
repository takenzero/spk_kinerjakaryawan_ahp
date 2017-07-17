/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.dao.DAOBobotSubKriteria;
import kinerjakaryawanahp.dao.DAOKriteria;
import kinerjakaryawanahp.dao.DAOSubKriteria;
import kinerjakaryawanahp.dao.InterfaceBobotSubKriteria;
import kinerjakaryawanahp.dao.InterfaceKriteria;
import kinerjakaryawanahp.dao.InterfaceSubKriteria;
import kinerjakaryawanahp.model.ModelBobotSubKriteria;
import kinerjakaryawanahp.model.ModelKriteria;
import kinerjakaryawanahp.model.ModelSubKriteria;
import kinerjakaryawanahp.model.ModelTabelBobotSubKriteria;
import kinerjakaryawanahp.view.ViewBobotSubKriteria;
/**
 *
 * @author taken
 */
public class ControllerBobotSubKriteria {
    ViewBobotSubKriteria frm;
    InterfaceKriteria in_k;
    InterfaceSubKriteria in;
    InterfaceBobotSubKriteria in_bobot;
    List<ModelKriteria> list_k;
    List<ModelSubKriteria> list;
    List<ModelBobotSubKriteria> list_bobot;
    
    public ControllerBobotSubKriteria(ViewBobotSubKriteria frm){
        this.frm = frm;
        in_k = new DAOKriteria();
        in = new DAOSubKriteria();
        in_bobot = new DAOBobotSubKriteria();
        list_k = in_k.getAllKriteria();
        //list = in.getAllSubKriteria();
        list_bobot = in_bobot.getAllBobotSubKriteria();
        setItemsKriteria();
        reset();
    }
    
    private void setItemsKriteria(){
        frm.getCboKriteria().setModel(new DefaultComboBoxModel(list_k.toArray()));
        setItemsSubKriteria();
    }
    
    public void setItemsSubKriteria(){
        ModelKriteria k = (ModelKriteria) frm.getCboKriteria().getSelectedItem();
        
        list = in.getSubKriteriaByKriteria(k);
        
        frm.getCboSubKriteria1().setModel(new DefaultComboBoxModel(list.toArray()));
        frm.getCboSubKriteria2().setModel(new DefaultComboBoxModel(list.toArray()));
    }
    
    public void reset(){
        frm.getCboSubKriteria1().setSelectedIndex(0);
        frm.getCboSubKriteria2().setSelectedIndex(0);
        frm.getCboKriteria().setSelectedIndex(0);
        frm.getCboBobotSubKriteria().setSelectedIndex(0);
        frm.getCboKriteria().setEnabled(true);
        frm.getCboBobotSubKriteria().setEnabled(false);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
        setItemsKriteria();
    }
    
    public void isiTable(){
        list_bobot = in_bobot.getAllBobotSubKriteria();
        ModelTabelBobotSubKriteria mtk = new ModelTabelBobotSubKriteria(list_bobot);
        frm.getTblBobotSubKriteria().setModel(mtk);
    }
    
    public void isiField(int row){
        setSelectedKriteria(list_bobot.get(row).getKriteria().getNamaKriteria());
        setSelectedSubKriteria1(list_bobot.get(row).getSubKriteria1().getNamaSubKriteria());
        setSelectedSubKriteria2(list_bobot.get(row).getSubKriteria2().getNamaSubKriteria());
        frm.getCboBobotSubKriteria().setSelectedIndex(0);
        frm.getCboKriteria().setEnabled(false);
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelBobotSubKriteria mb1 = new ModelBobotSubKriteria();
        ModelBobotSubKriteria mb2 = new ModelBobotSubKriteria();
        
        mb1.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb1.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb1.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb1.setBobotSubKriteria(Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        mb2.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb2.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb2.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb2.setBobotSubKriteria(1/Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        if (in_bobot.bobotIsExists(mb1.getSubKriteria1().getIdSubKriteria(), mb1.getSubKriteria2().getIdSubKriteria(), mb1.getKriteria().getIdKriteria())){
            in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getSubKriteria1().getIdSubKriteria(), mb2.getSubKriteria2().getIdSubKriteria(), mb2.getKriteria().getIdKriteria())){
            in_bobot.delete(mb2);
        }
        
        if(in_bobot.insert(mb1)){
            if (frm.getCboSubKriteria1().getSelectedItem().toString().equals(frm.getCboSubKriteria2().getSelectedItem().toString())){
                JOptionPane.showMessageDialog(frm, "Data bobot subkriteria berhasil ditambahkan","Info",1);
            }else{
                if (in_bobot.insert(mb2)){
                    JOptionPane.showMessageDialog(frm, "Data bobot subkriteria berhasil ditambahkan","Info",1);
                }else{
                    JOptionPane.showMessageDialog(frm, "Data bobot subkriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
                }
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Data bobot kriteria gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void update(){
        ModelBobotSubKriteria mb1 = new ModelBobotSubKriteria();
        ModelBobotSubKriteria mb2 = new ModelBobotSubKriteria();
        
        mb1.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb1.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb1.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb1.setBobotSubKriteria(Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        mb2.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb2.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb2.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb2.setBobotSubKriteria(1/Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        if (in_bobot.bobotIsExists(mb1.getSubKriteria1().getIdSubKriteria(), mb1.getSubKriteria2().getIdSubKriteria(), mb1.getKriteria().getIdKriteria())){
            in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getSubKriteria1().getIdSubKriteria(), mb2.getSubKriteria2().getIdSubKriteria(), mb2.getKriteria().getIdKriteria())){
            in_bobot.delete(mb2);
        }
        
        if(in_bobot.insert(mb1)){
            if (frm.getCboSubKriteria1().getSelectedItem().toString().equals(frm.getCboSubKriteria2().getSelectedItem().toString())){
                JOptionPane.showMessageDialog(frm, "Perubahan data bobot subkriteria berhasil disimpan","Info",1);
            }else{
                if (in_bobot.insert(mb2)){
                    JOptionPane.showMessageDialog(frm, "Perubahan data bobot subkriteria berhasil disimpan","Info",1);
                }else{
                    JOptionPane.showMessageDialog(frm, "Perubahan data bobot subkriteria gagal disimpan. Periksa kembali data yang diinput.","Info",0);
                }
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Perubahan data bobot subkriteria gagal disimpan. Periksa kembali data yang diinput.","Info",0);
        }
    }
    
    public void delete(){
        ModelBobotSubKriteria mb1 = new ModelBobotSubKriteria();
        ModelBobotSubKriteria mb2 = new ModelBobotSubKriteria();
        
        mb1.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb1.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb1.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb1.setBobotSubKriteria(Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        mb2.setSubKriteria1((ModelSubKriteria) frm.getCboSubKriteria2().getSelectedItem());
        mb2.setSubKriteria2((ModelSubKriteria) frm.getCboSubKriteria1().getSelectedItem());
        mb2.setKriteria((ModelKriteria) frm.getCboKriteria().getSelectedItem());
        mb2.setBobotSubKriteria(1/Double.parseDouble(frm.getCboBobotSubKriteria().getSelectedItem().toString()));
        
        Boolean a = false;
        
        if (in_bobot.bobotIsExists(mb1.getSubKriteria1().getIdSubKriteria(), mb1.getSubKriteria2().getIdSubKriteria(), mb1.getKriteria().getIdKriteria())){
            a = in_bobot.delete(mb1);
        }
        
        if (in_bobot.bobotIsExists(mb2.getSubKriteria1().getIdSubKriteria(), mb2.getSubKriteria2().getIdSubKriteria(), mb2.getKriteria().getIdKriteria())){
            a = in_bobot.delete(mb2);
        }
        
        if (a){
            JOptionPane.showMessageDialog(frm, "Data bobot subkriteria berhasil dihapus","Info",1);
        }else{
            JOptionPane.showMessageDialog(frm, "Data bobot subkriteria gagal dihapus","Info",0);
        }
    }
       
    private void setSelectedKriteria(String value){
        String item;
        for(int i=0; i<frm.getCboKriteria().getItemCount();i++){
            item = frm.getCboKriteria().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboKriteria().setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void setSelectedSubKriteria1(String value){
        String item;
        for(int i=0; i<frm.getCboSubKriteria1().getItemCount();i++){
            item = frm.getCboSubKriteria1().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboSubKriteria1().setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void setSelectedSubKriteria2(String value){
        String item;
        for(int i=0; i<frm.getCboSubKriteria2().getItemCount();i++){
            item = frm.getCboSubKriteria2().getItemAt(i).toString();
            if (item.equals(value)){
                frm.getCboSubKriteria2().setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setEnabledBobot(){
        if (frm.getCboSubKriteria1().getSelectedItem().toString().equals(frm.getCboSubKriteria2().getSelectedItem().toString())){
            frm.getCboBobotSubKriteria().setSelectedIndex(0);
            frm.getCboBobotSubKriteria().setEnabled(false);
        }else{
            frm.getCboBobotSubKriteria().setSelectedIndex(2);
            frm.getCboBobotSubKriteria().setEnabled(true);
        }
    }
}