/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author WALTER
 */
public class Compra {
     
    private FormaPago formaPago;
    private int numeroOrden;
    private int valor;    
    private java.util.Date fechaCompra;
    private List<DetalleCarroCompra> detalleCompra;

    private Cliente cliente;
  
    public Compra(FormaPago formaPago, int numeroOrden, int valor, java.util.Date fechaCompra, 
            List<DetalleCarroCompra> detalleCompra, Cliente cliente) {
        this.formaPago = formaPago;
        this.numeroOrden = numeroOrden;
        this.valor = valor;
        this.fechaCompra = fechaCompra;
        this.detalleCompra = detalleCompra;
        this.cliente = cliente;
    }
    public FormaPago getFormapago() {
        return formaPago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formaPago = formapago;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int NumeroOrden) {
        this.numeroOrden = NumeroOrden;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<DetalleCarroCompra> getDetalleCompra() {
        return detalleCompra;
    }
}
