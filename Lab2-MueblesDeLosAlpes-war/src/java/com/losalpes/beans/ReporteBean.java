/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Compra;
import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.ServicioCompraMock;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author WALTER
 */
@Named(value = "reporteBean")
@ManagedBean
public class ReporteBean {

    private String numeroDocumento;
    private List<Compra> comprasCliente;

    @ManagedProperty("#{compraBean}")
    private CompraBean compra;  

    public CompraBean getCompra() {
        return compra;
    }

    public void setCompra(CompraBean compra) {
        this.compra = compra;
    }
     
    public List<Compra> getComprasCliente() {
        return comprasCliente;
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    /**
     * Creates a new instance of ReporteBean
     */
    public ReporteBean() {
    }
    
    public void buscarComprasCliente(){
        this.comprasCliente = new ArrayList<>();
        List<Compra> compras = compra.getCompra().darCompras();
         for (Compra item : compras) {
             if (item.getCliente() != null && item.getCliente().getNumeroDocumento().equals(numeroDocumento)){
                 this.comprasCliente.add(item);
             }
         }
    }
}
