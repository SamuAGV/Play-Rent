/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juguete;

/**
 *
 * @author SPARTAN PC
 */
public class JugueteAlmacenadoLote extends JugueteAlmacenado {
    private String Marca;
    private int Lote;
    private int Cantidad;

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int Lote) {
        this.Lote = Lote;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}
