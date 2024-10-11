/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Digital;

/**
 *
 * @author SPARTAN PC
 */
public class RentaConsolaXbox extends RentaConsola{
    private String Modelo;
    private int Serie;

    public String getMoselo() {
        return Modelo;
    }

    public void setMoselo(String Moselo) {
        this.Modelo = Moselo;
    }

    public int getSerie() {
        return Serie;
    }

    public void setSerie(int Serie) {
        this.Serie = Serie;
    }
}
