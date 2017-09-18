/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.ServicioCompraMock;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author WALTER
 */
@Named(value = "compraBean")
@ApplicationScoped
public class CompraBean {

    private IServicioCompra compra;

    public IServicioCompra getCompra() {
        return compra;
    }
    /**
     * Creates a new instance of CompraBean
     */
    public CompraBean() {
        compra = new ServicioCompraMock();
    }
    
}
