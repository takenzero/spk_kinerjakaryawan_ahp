/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.model;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author taken
 */
public class ModelTabelTampilHasil extends AbstractTableModel{
    final String[] nama_kolom = {"No", "Id Karyawan", "Nama Karyawan", "Nilai"};
    List<ModelTampilHasil> list;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public ModelTabelTampilHasil(List<ModelTampilHasil> list){
        this.list = list;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public String getColumnName(int column){
        return nama_kolom[column];
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return row+1;
            case 1:
                return list.get(row).getIdKaryawan();
            case 2:
                return list.get(row).getNamaKaryawan();
            case 3:
                return df.format(list.get(row).getNilai());
            default:
                return null;
        }
    }
}
