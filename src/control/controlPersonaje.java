package control;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cuenta;
import modelo.Personaje;

public class controlPersonaje {

    public boolean crearPersonaje(Personaje personaje) {
        try {

            Connection conexion = Conexion.getConexion();

            String query = "INSERT INTO PERSONAJE (idUsuarioCuenta,nickName,vida,mana,nivel,raza,descripccion) values (?,?,?,?,?,?,?)";

            PreparedStatement ins = conexion.prepareStatement(query);

            ins.setInt(1, personaje.getIdUsuarioCuenta());
            ins.setString(2, personaje.getNickName());
            ins.setInt(3, personaje.getVida());
            ins.setInt(4, personaje.getMana());
            ins.setInt(5, personaje.getNivel());
            ins.setString(6, personaje.getRaza());
            ins.setString(7, personaje.getDescripccion());

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

    public ArrayList<Personaje> buscarPersonajes(int id) {
        ArrayList<Personaje> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT nickName,vida,mana,nivel,raza FROM CUENTA  "
                    + "JOIN PERSONAJE on ( idUsuario=idUsuarioCuenta) where  idUsuario=?";
            PreparedStatement bus = conexion.prepareStatement(query);
            bus.setInt(1, id);
            ResultSet rs = bus.executeQuery();

            while (rs.next()) {
                Personaje personaje = new Personaje();

                personaje.setNickName(rs.getString("nickName"));
                personaje.setVida(rs.getInt("vida"));
                personaje.setMana(rs.getInt("mana"));
                personaje.setNivel(rs.getInt("nivel"));
                personaje.setRaza(rs.getString("raza"));

                lista.add(personaje);
            }

        } catch (Exception e) {
            System.out.println("Error, al buscar por id " + e.getMessage());
        }

        return lista;

    }

    public boolean eliminarPersonaje(String nickName) {

        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM PERSONAJE WHERE nickName=?";
            PreparedStatement del = conexion.prepareStatement(query);
            del.setString(1, nickName);

            if (del.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
        }
        return false;

    }

}
