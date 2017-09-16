/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.CarroCompra;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.DetalleCarroCompra;
import java.util.ArrayList;

/**
 *
 * @author WALTER
 */
public class ServicioCarroCompraMock implements IServicioCarroCompra {
 
    private CarroCompra carroCompra;
      
    public ServicioCarroCompraMock() {
        carroCompra = new CarroCompra();
    }
    
    public void agregarItem(DetalleCarroCompra item){
        carroCompra.getMuebles().add(item);
    } 
    
    public CarroCompra darCarroCompras() {
        return carroCompra;
    }
    
    public int darPrecioTotal() {
        int precio = 0;
        for (DetalleCarroCompra item : carroCompra.getMuebles()) {
            precio += item.getCantidad()* item.getMueble().getPrecio();
        }
        return precio;
    }
}
