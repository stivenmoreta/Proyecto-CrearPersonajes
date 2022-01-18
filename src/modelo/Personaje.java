package modelo;

public class Personaje {

    private String nickName;
    private int vida;
    private int mana;
    private int nivel;
    private String raza;
    private String descripccion;
    private int idUsuarioCuenta;

    public Personaje() {

        this.nickName = "sin nick";
        this.vida = 0;
        this.mana = 0;
        this.nivel = 0;
        this.raza = "sin raza";
        this.descripccion = "sin descripccion";
        this.idUsuarioCuenta = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public int getIdUsuarioCuenta() {
        return idUsuarioCuenta;
    }

    public void setIdUsuarioCuenta(int idUsuarioCuenta) {
        this.idUsuarioCuenta = idUsuarioCuenta;
    }

}
