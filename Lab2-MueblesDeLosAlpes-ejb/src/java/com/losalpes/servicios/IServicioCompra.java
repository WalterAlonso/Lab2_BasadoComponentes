/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.CarroCompra;
import com.losalpes.bos.Compra;
import com.losalpes.bos.DetalleCarroCompra;
import java.util.List;

/**
 *
 * @author WALTER
 */
public interface IServicioCompra {
    
    public Compra agregarCompra(Compra compra);
    public List<Compra> darCompras();
    public int darNumeroOrden();
}