/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nroda
 */
public class Buscador_Id {

    private final String usuario;
    private final String contrasenia;
    private int cargo = 0;
    private final String orden_mysql = "SELECT * FROM usuario";
    Conexion conexion;

    public Buscador_Id(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        conexion = new Conexion();
    }

    public int existeId() {
        Statement resultado;
        try {
            resultado = conexion.getConectar().createStatement();
            try (ResultSet result = resultado.executeQuery(orden_mysql)) {
                while (result.next()) {
                    if (this.usuario.equals(result.getString(1)) && this.contrasenia.equals(result.getString(2))) {
                        cargo = result.getInt(3);
                        result.close();
                        resultado.close();
                        conexion.cerrarConexion();
                        return cargo;
                        
                    }
                }
            }
            resultado.close();
            conexion.cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_Id.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
