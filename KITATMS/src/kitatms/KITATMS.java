/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.sql.SQLException;

/**
 * @author adiza
 */
public class KITATMS {

    DBConnection con = new DBConnection();

    /**
     * ^
     *
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        KITATMS program = new KITATMS();
        program.start();
        //program.zamTest();
        //program.hadyaTest();
        //program.wahaTest();
    }

    public void start() throws SQLException {

        // TODO code application logic here
        System.out.println("Adi was here");
        DBWindow dbwindow = new DBWindow(con);
    }
}
