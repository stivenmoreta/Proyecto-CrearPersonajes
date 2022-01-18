package modelo;

public class Cuenta {

    private int idUsuario;
    private String usuario;
    private String contraseña;


    public Cuenta() {
        this.idUsuario = 0;
        this.usuario = "sin nombre";
        this.contraseña = "sin contraseña";

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



}
