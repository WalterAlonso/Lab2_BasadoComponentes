/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Banco;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Departamento;
import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.bos.FormaPago;
import com.losalpes.bos.Usuario;
import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.ServicioCompraMock;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author WALTER
 */
@Named(value = "pagoBean")
@ManagedBean
public class PagoBean {

    @ManagedProperty("#{carroComprasBean}")
    private CarroComprasBean carroCompras;

    @ManagedProperty("#{loginBean}")
    private LoginBean logguedUser;
    
    private IServicioCompra compra;
    
    private int referencia;   
    private int valor;
    private String Descripcion;
    private FormaPago formaPago;
    private boolean mostrarSolicitarTarjetaCredito;   
    private boolean mostrarSolicitarPSE;
    
    /**
     * Creates a new instance of PagoBean
     */
    public PagoBean() {
        compra = new ServicioCompraMock();
    }
    
     public int getReferencia() {
        return compra.darNumeroOrden();
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getValor() {
        return carroCompras.darPrecioTotal();
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        int cantidadLibros = carroCompras.darItems().size();
        String descripcionMuebles = cantidadLibros + " muebles (";        
        for (DetalleCarroCompra item : carroCompras.darItems()) {
            descripcionMuebles += "referencia: "+item.getMueble().getReferencia()+ ", nombre: " +
                    item.getMueble().getNombre();
        }
        descripcionMuebles +=")";        
        return descripcionMuebles;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
       
    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    
    public void pagar(){
       Usuario usuario = logguedUser.getLoggedUser();        
        Compra compraRealizada = new Compra(FormaPago.CREDITO, referencia, valor, 
                new Date(), carroCompras.darItems(), usuario.getCliente());
        compra.agregarCompra(compraRealizada);
        //MOstrar el popup
    }
    
    public CarroComprasBean getCarroCompras() {
        return carroCompras;
    }

    public LoginBean getLogguedUser() {
        return logguedUser;
    }  
   
    public void setCarroCompras(CarroComprasBean carroCompras) {
        this.carroCompras = carroCompras;
    }

    public void setLogguedUser(LoginBean logguedUser) {
        this.logguedUser = logguedUser;
    }
    
    public boolean isMostrarSolicitarTarjetaCredito() {
        return mostrarSolicitarTarjetaCredito;
    }

    public void setMostrarSolicitarTarjetaCredito(boolean solicitarTarjetaCredito) {
        this.mostrarSolicitarTarjetaCredito = solicitarTarjetaCredito;
    }

    public boolean isMostrarSolicitarPSE() {
        return mostrarSolicitarPSE;
    }

    public void setMostrarSolicitarPSE(boolean solicitarPSE) {
        this.mostrarSolicitarPSE = solicitarPSE;
    }   
    
    public void solicitarTarjetaCredito(){
        this.setMostrarSolicitarPSE(false);
        this.setMostrarSolicitarTarjetaCredito(true);
    }
    
    public void solicitarPSE(){        
        this.setMostrarSolicitarTarjetaCredito(false);
        this.setMostrarSolicitarPSE(true);
    }
    
    public SelectItem[] getMeses() {
        SelectItem[] sitems = new SelectItem[12];
        for (int i = 1; i <= sitems.length; i++) {
            sitems[i-1] = new SelectItem(i);
        }
        return sitems;
    }
    
    public SelectItem[] getAnios() {
        SelectItem[] sitems = new SelectItem[10];
        int anioInicial = 17;
        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(i+anioInicial);
        }
        return sitems;
    }
    
    public SelectItem[] getBancos() {
        Banco[] tipos = Banco.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
}
