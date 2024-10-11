/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author SPARTAN PC
 */
public class UsuarioClientePremium extends UsuarioCliente {
    private String Contrasena;
    private int Cuenta;

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getCuenta() {
        return Cuenta;
    }

    public void setCuenta(int Cuenta) {
        this.Cuenta = Cuenta;
    }
    
}
