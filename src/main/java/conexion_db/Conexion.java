/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nroda
 */
public final class Conexion {

    private final String URL = "jdbc:mysql://localhost:3306/mimuebleria";
    private final String USER = "jefe";
    private final String PASSWORD = "password";
    private Connection conectar = null;

    public Conexion() {
        this.conectarDB();
    }

    public void conectarDB() {
        if (conectar == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conectar = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }
    
    public void cerrarConexion(){
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public Connection getConectar() {
        return conectar;
    }

    public void setConectar(Connection conectar) {
        this.conectar = conectar;
    }

}
