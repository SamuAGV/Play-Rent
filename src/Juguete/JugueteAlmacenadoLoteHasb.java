/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juguete;

/**
 *
 * @author SPARTAN PC
 */
public class JugueteAlmacenadoLoteHasb extends JugueteAlmacenadoLote {
    private String Describcion;
    private int Cantidad;
    private int Modelo;

    public String getDescribcion() {
        return Describcion;
    }

    public void setDescribcion(String Describcion) {
        this.Describcion = Describcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }
}
