package control;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cuenta;

public class controlCuenta {

    public boolean agregarCuenta(Cuenta cuenta) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO CUENTA (usuario,contraseña) VALUES (?,?)";

            PreparedStatement ins = conexion.prepareStatement(query);

            ins.setString(1, cuenta.getUsuario());
            ins.setString(2, cuenta.getContraseña());

            if (ins.executeUpdate() > 0) {
                return true;
            }
            ins.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;

    }

    public int iniciarSesion(String usuario, String contraseña) {

        int idUsuario = 0;
        try {

            Connection conexion = Conexion.getConexion();//conexion a la bbdd

            String query = "SELECT * FROM CUENTA WHERE usuario=? and contraseña=?"; //qr con que comparar

            
            PreparedStatement ins = conexion.prepareStatement(query);//qr-string
         
            ins.setString(1, usuario);
            ins.setString(2, contraseña);

            ResultSet rs = ins.executeQuery();

 
            while(rs.next()){
                idUsuario = rs.getInt("idUsuario");
            }
 
        } catch (Exception e) {
            System.out.println("Error al iniciar sesion " + e.getMessage());
        }
        return idUsuario;
    }
}
