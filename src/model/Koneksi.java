/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muhtar
 */
public class Koneksi {

    private Connection con;
    private Statement stm;

    public Koneksi(String user, String pass, String db) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + db;
        con = DriverManager.getConnection(url, user, pass);
        stm = con.createStatement();
    }

    public void execute(String sql) throws SQLException {
        this.stm.executeUpdate(sql);
    }

    public ResultSet getResult(String sql) throws SQLException {
        return stm.executeQuery(sql);
    }

    public Connection getConnection() {
        return con;
    }

}
