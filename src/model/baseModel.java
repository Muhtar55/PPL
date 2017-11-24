/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Muhtar
 */
public class baseModel {

    private Koneksi kon;

    public baseModel() throws SQLException {
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public boolean execute(String query) throws SQLException {
        try {
            kon.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
