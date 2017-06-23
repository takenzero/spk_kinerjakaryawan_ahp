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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import kinerjakaryawanahp.dao.DAOKaryawan;
import kinerjakaryawanahp.dao.InterfaceKaryawan;
import kinerjakaryawanahp.model.ModelKaryawan;
import kinerjakaryawanahp.model.ModelTabelKaryawan;
import kinerjakaryawanahp.view.ViewKaryawan;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerKaryawan {
    ViewKaryawan frm;
    InterfaceKaryawan in;
    List<ModelKaryawan> list;
    
    public ControllerKaryawan(ViewKaryawan frm){
        this.frm = frm;
        in = new DAOKaryawan();
        list = in.getAllKaryawan();
    }
    
    public void reset(){
        frm.getTxtIdKaryawan().setText("");
        frm.getTxtNama().setText("");
        frm.getCboKelamin().setSelectedIndex(0);
        frm.getCboAgama().setSelectedIndex(0);
        frm.getTxtTempat().setText("");
        frm.getTxtTanggal().setText("");
        frm.getTxtAlamat().setText("");
        frm.getTxtNoTelp().setText("");
    }
    
    public void isiTable(){
        list = in.getAllKaryawan();
        ModelTabelKaryawan mtk = new ModelTabelKaryawan(list);
        frm.getTblKaryawan().setModel(mtk);
    }
    
    public void isiField(int row){
        frm.getTxtIdKaryawan().setText(list.get(row).getIdKaryawan());
        frm.getTxtNama().setText(list.get(row).getNama());
        frm.getCboKelamin().setSelectedItem(list.get(row).getStrKelamin());
        frm.getCboAgama().setSelectedItem(list.get(row).getStrAgama());
        frm.getTxtTempat().setText(list.get(row).getTempat());
        frm.getTxtTanggal().setText(list.get(row).getTglLahir());
        frm.getTxtAlamat().setText(list.get(row).getAlamat());
        frm.getTxtNoTelp().setText(list.get(row).getNoTelp());
    }
    
    public void insert() throws ParseException{
        ModelKaryawan mk = new ModelKaryawan();
        
        if (!frm.getTxtIdKaryawan().getText().trim().isEmpty() && !frm.getTxtNama().getText().trim().isEmpty()){
            mk.setIdKaryawan(frm.getTxtIdKaryawan().getText().trim());
            mk.setNama(frm.getTxtNama().getText().trim());
            mk.setKelamin(frm.getCboKelamin().getSelectedIndex());
            mk.setAgama(frm.getCboAgama().getSelectedIndex());
            mk.setTempat(frm.getTxtTempat().getText().trim());
            mk.setTglLahir((Date) new SimpleDateFormat("dd/MM/yyyy").parse(frm.getTxtTanggal().getText()));
            mk.setAlamat(frm.getTxtAlamat().getText().trim());
            mk.setNoTelp(frm.getTxtNoTelp().getText().trim());
        }else{
            JOptionPane.showMessageDialog(frm, "Id Karyawan dan Nama harus diisi","Info",2);
        }
    }
    
}