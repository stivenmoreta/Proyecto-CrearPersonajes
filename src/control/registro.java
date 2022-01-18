/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cuenta;

/**
 *
 * @author Equipo
 */
public class registro {

    public ArrayList<Cuenta> buscarPorId(int id) {
        ArrayList<Cuenta> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT*FROM CUENTA WHERE idUsuario =?";
            PreparedStatement bus = conexion.prepareStatement(query);
            bus.setInt(1, id);
            ResultSet rs = bus.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdUsuario(rs.getInt("idUsuario"));
                cuenta.setUsuario(rs.getString("usuario"));
                lista.add(cuenta);

            }

        } catch (Exception e) {
            System.out.println("Error al buscar por id" + e.getMessage());
        }

        return lista;
    }

    public boolean eliminarRegistro(int id) {

        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM CUENTA WHERE idUsuario=?";
            PreparedStatement del = conexion.prepareStatement(query);
            del.setInt(1, id);

            if (del.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
        }
        return false;

    }

    public ArrayList<Cuenta> listarTodos() {
        ArrayList<Cuenta> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT*FROM CUENTA";
            PreparedStatement bus = conexion.prepareStatement(query);
            ResultSet rs = bus.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdUsuario(rs.getInt("idUsuario"));
                cuenta.setUsuario(rs.getString("usuario"));
                lista.add(cuenta);

            }

        } catch (Exception e) {
            System.out.println("Error al listar todos" + e.getMessage());
        }

        return lista;
    }

    public boolean modificarCuenta(Cuenta cuenta) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE cuenta SET usuario=? "
                    + "WHERE idUsuario=?";
            PreparedStatement mod = conexion.prepareStatement(query);

            mod.setString(1, cuenta.getUsuario());
            mod.setInt(2, cuenta.getIdUsuario());
            if (mod.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return false;
    }
}
