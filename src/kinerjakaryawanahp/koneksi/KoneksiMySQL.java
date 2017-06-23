/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.koneksi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TAKEN ZERO
 */
public class KoneksiMySQL {
    static Connection con;
    
    public static Connection connection() throws SQLException{
        if (con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_kinerjakaryawanahp");
            data.setUser("root");
            data.setPassword("password*5");
            try{
                con = data.getConnection();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return con;
    }
}
