/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author SPARTAN PC
 */
public class ServicioRentaInflableGrande extends ServicioRentaInflable {
    private String Color;
    private int Tamano;
    private int Costo;

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int Tamano) {
        this.Tamano = Tamano;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
}
