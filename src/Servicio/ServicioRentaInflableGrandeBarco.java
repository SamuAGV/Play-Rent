/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author SPARTAN PC
 */
public class ServicioRentaInflableGrandeBarco extends ServicioRentaInflableGrande {
    private String Color;
    private String diseno;
    private int Medidas;

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getDiseno() {
        return diseno;
    }

    public void setDiseno(String diseno) {
        this.diseno = diseno;
    }

    public int getMedidas() {
        return Medidas;
    }

    public void setMedidas(int Medidas) {
        this.Medidas = Medidas;
    }
            
}
