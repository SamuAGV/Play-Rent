/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

/**
 *
 * @author SPARTAN PC
 */
public class EmpleadoGestionAlmacenDis extends EmpleadoGestionAlmacen {
    private String Nombre;
    private String Productos;
    private int Cantidad;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getProductos() {
        return Productos;
    }

    public void setProductos(String Productos) {
        this.Productos = Productos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}
