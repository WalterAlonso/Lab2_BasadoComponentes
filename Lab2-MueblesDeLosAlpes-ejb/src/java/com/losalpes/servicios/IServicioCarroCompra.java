/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.CarroCompra;
import com.losalpes.bos.DetalleCarroCompra;

/**
 *
 * @author WALTER
 */
public interface IServicioCarroCompra {
    
    public void agregarItem(DetalleCarroCompra item); 
    
    public CarroCompra darCarroCompras(); 
    
    public int darPrecioTotal();
}