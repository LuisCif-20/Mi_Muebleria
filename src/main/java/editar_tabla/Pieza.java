/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editar_tabla;

import conexion_db.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.CRUD;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nroda
 */
public class Pieza implements CRUD {

    private String tipo;
    private double costo;
    private int existencias;
    private String nuevoTipo;
    private double nuevoCosto;
    private int nuevaCantidad;
    Conexion conectar;

    public Pieza(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
        conectar = new Conexion();
    }

    public Pieza(String tipo, double costo,String nuevoTipo, double nuevocosto, int nuevaCantidad) {
        conectar = new Conexion();
        this.costo = costo;
        this.tipo = tipo;
        this.nuevaCantidad = nuevaCantidad;
        this.nuevoCosto = nuevocosto;
        this.nuevoTipo = nuevoTipo;
    }


    @Override
    public String update() {
        boolean existe = this.buscarElemento(tipo, costo);
        if (existe) {
            
        }
        return "No existe el archivo a actualizar";
    }
    
    //Verifica los campos vacion

    //Regresa los datos almacenados
    @Override
    public String read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Elimina un elemento de la tabla que exista 
    @Override
    public String delete() {
        boolean existe = this.buscarElemento(tipo, costo);
        if (existe) {
            String query = "DELETE FROM pieza WHERE tipo = '" + tipo + "' AND costo = " + costo;
            try {
                Statement eliminar = conectar.getConectar().createStatement();
                eliminar.executeLargeUpdate(query);
                eliminar.close();
                conectar.cerrarConexion();
                return "Se ha eliminado la pieza de tipo:" + tipo + ", con costo de: " + costo;
            } catch (SQLException ex) {
                Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "No se puede eliminar la pieza ya que no se encontro";
    }
    //Crea un elemento en la tabla y si ya existe aumenta la cantidad
    @Override
    public String create() {
        boolean existe = this.buscarElemento(tipo, costo);
        if (!existe) {
            try {
                PreparedStatement insertar = conectar.getConectar().prepareStatement("INSERT INTO pieza(tipo,costo,cantidad) VALUES(?,?,?)");
                insertar.setString(1, tipo);
                insertar.setDouble(2, costo);
                insertar.setInt(3, 0);
                insertar.executeUpdate();
                insertar.close();
                conectar.cerrarConexion();
                return "Pieza agregada con exito";
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int cantidad = this.regresarDatoCantidad();
        String query = "UPDATE pieza SET cantidad=" + cantidad + " WHERE tipo = '" + tipo + "' AND costo =" + costo;
        Statement actualizar;
        try {
            actualizar = conectar.getConectar().createStatement();
            actualizar.executeUpdate(query);
            actualizar.close();
            conectar.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Ha aumentado la cantidad de la pieza " + tipo + " con costo " + costo;

    }
    //Regresa las existencias de una pieza en particular
    public int regresarDatoCantidad() {
        int cantidad = 0;
        String query = "SELECT * FROM pieza";
        Statement resultado;
        try {
            resultado = conectar.getConectar().createStatement();
            ResultSet result = resultado.executeQuery(query);
            while (result.next()) {
                if (tipo.equalsIgnoreCase(result.getString(1)) && costo == result.getDouble(2)) {
                    cantidad = result.getInt(3) + 1;
                    result.close();
                    resultado.close();
                    return cantidad;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }
    //Busca y valida si un elemente existe
    public boolean buscarElemento(String tipo, double costo) {
        Statement resultado;
        try {
            resultado = conectar.getConectar().createStatement();
            try ( ResultSet result = resultado.executeQuery("SELECT * FROM pieza")) {
                while (result.next()) {
                    if (tipo.equalsIgnoreCase(result.getString(1)) && costo == result.getDouble(2)) {
                        result.close();
                        resultado.close();
                        return true;

                    }
                }
            }
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Getter y Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
