/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package play.rent.Juguete;

/**
 *
 * @author Usuario
 */
public class JugueteEducativoElectronico extends JugueteEducativo{
    
     private String TecnologiaUtilizada;
    private String Seguridad;

    public String getTecnologiaUtilizada() {
        return TecnologiaUtilizada;
    }

    public void setTecnologiaUtilizada(String TecUt) {
        this.TecnologiaUtilizada = TecUt;
    }

    public String getSeguridad() {
        return Seguridad;
    }

    public void setSeguridad(String Seg) {
        this.Seguridad = Seg;
    }
}
