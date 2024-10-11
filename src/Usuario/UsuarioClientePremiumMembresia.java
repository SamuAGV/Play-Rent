/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author SPARTAN PC
 */
public class UsuarioClientePremiumMembresia extends UsuarioClientePremium {
    private String Nombre;
    private String Apellidos;
    private int contacto;
    private int NumMembresia;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getNumMembresia() {
        return NumMembresia;
    }

    public void setNumMembresia(int NumMembresia) {
        this.NumMembresia = NumMembresia;
    }
}
