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
import kinerjakaryawanahp.view.ViewBobotKaryawan;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerBobotKaryawan {
    ViewBobotKaryawan frm;
    InterfaceKaryawan in;
    List<ModelKaryawan> list;
    
    public ControllerBobotKaryawan(ViewBobotKaryawan frm){
        this.frm = frm;
        reset();
        in = new DAOKaryawan();
        list = in.getAllKaryawan();
    }
    
    public void reset(){
        //frm.getTxtIdKaryawan().setText("");
        //frm.getTxtNama().setText("");
        frm.getTxtIdKaryawan().setEnabled(true);
        frm.getBtnTambah().setEnabled(true);
        frm.getBtnSimpan().setEnabled(false);
        frm.getBtnHapus().setEnabled(false);
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
        frm.getTblKaryawan().setModel(mtk);
    }
    
    public void isiField(int row){
        //frm.getTxtIdKaryawan().setText(list.get(row).getIdKaryawan());
        //frm.getTxtNama().setText(list.get(row).getNama());
        frm.getBtnTambah().setEnabled(false);
        frm.getBtnSimpan().setEnabled(true);
        frm.getBtnHapus().setEnabled(true);
    }
    
    public void insert(){
        ModelKaryawan mk = new ModelKaryawan();
        
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty() && !frm.getTxtNama().getText().trim().isEmpty()){
            //mk.setIdKaryawan(frm.getTxtIdKaryawan().getText().trim());
            //mk.setNama(frm.getTxtNama().getText().trim());
            if (in.insert(mk)){
                JOptionPane.showMessageDialog(frm, "Data karyawan berhasil ditambahkan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data karyawan gagal ditambahkan. Periksa kembali data yang diinput.","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id Karyawan dan Nama harus diisi","Info",2);
        }
    }
    
    public void update(){
        ModelKaryawan mk = new ModelKaryawan();
        
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty() && !frm.getTxtNama().getText().trim().isEmpty()){
            //mk.setIdKaryawan(frm.getTxtIdKaryawan().getText().trim());
            //mk.setNama(frm.getTxtNama().getText().trim());
            if (in.update(mk)){
                JOptionPane.showMessageDialog(frm, "Perubahan data karyawan berhasil disimpan","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Perubahan data karyawan gagal disimpan","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id Karyawan dan Nama harus diisi","Info",2);
        }
    }
    
    public void delete(){
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty()){
            if (in.delete(frm.getTxtIdKaryawan().getText().trim())){
                JOptionPane.showMessageDialog(frm, "Data karyawan berhasil dihapus.","Info",1);
            }else{
                JOptionPane.showMessageDialog(frm, "Data karyawan gagal dihapus","Info",0);
            }
        }else{
            JOptionPane.showMessageDialog(frm, "Id Karyawan harus diisi","Info",2);
        }
    }
}
