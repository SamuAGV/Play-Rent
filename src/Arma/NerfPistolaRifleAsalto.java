/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

/**
 *
 * @author SPARTAN PC
 */
public class NerfPistolaRifleAsalto extends NerfPistolaRifle{
    private String Piezas;
    private int Tamano;
    private int Precio;

    public String getPiezas() {
        return Piezas;
    }

    public void setPiezas(String Piezas) {
        this.Piezas = Piezas;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int Tamano) {
        this.Tamano = Tamano;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
}
