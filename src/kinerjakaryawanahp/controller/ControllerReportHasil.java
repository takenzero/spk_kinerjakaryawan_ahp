/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kinerjakaryawanahp.view.ViewHasil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author taken
 */
public class ControllerReportHasil {
    ViewHasil frm;
    JasperReport jReport;
    JasperPrint jPrint;
    JasperDesign jDesign;
    String nama_file = "";
    Connection conn;

    public ControllerReportHasil(ViewHasil frm) {
        this.frm = frm;
        jDesign = new JasperDesign();
    }
    
    public void ShowReport() throws SQLException{
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/db_kinerjakaryawanahp", "root", "password*5");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerReportHasil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            nama_file = "src/kinerjakaryawanahp/report/ReportHasil.jrxml";
            File report = new File(nama_file);
            jDesign = JRXmlLoader.load(report);
            jReport = JasperCompileManager.compileReport(jDesign);
            jPrint = JasperFillManager.fillReport(jReport, null, conn);
            JasperViewer.viewReport(jPrint,false);
        } catch (JRException ex) {
            Logger.getLogger(ControllerReportHasil.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frm, "Gagal menampilkan laporan hasil","Gagal",0);
        }
    }
}
