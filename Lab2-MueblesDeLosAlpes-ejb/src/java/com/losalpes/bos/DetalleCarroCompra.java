/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

/**
 *
 * @author WALTER
 */
public class DetalleCarroCompra {
    private Mueble mueble;
   
    private int cantidad;
    
    public DetalleCarroCompra(Mueble mueble, int cantidad) {
        this.mueble = mueble;
        this.cantidad = cantidad;                
    }
    
    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getPrecio() {
        return this.mueble.getPrecio() * this.cantidad;
    }
}
