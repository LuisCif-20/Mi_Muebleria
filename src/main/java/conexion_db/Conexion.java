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
    private final String USER = "root";
    private final String PASSWORD = "nbpjxd2";
    private Connection conectar = null;

    public Conexion() {
        this.conectarDB();
    }

    public void conectarDB() {
        if (conectar == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conectar = DriverManager.getConnection(URL, USER, PASSWORD);
                JOptionPane.showMessageDialog(null, "Se ha conectado exitosamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado la base de datos");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay una conexion abierta, cierrala e intente de nuevo");
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
