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
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.ServicioCompraMock;
import com.losalpes.servicios.ServicioSeguridadMock;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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

    @ManagedProperty("#{compraBean}")
    private CompraBean compra;    

    public CompraBean getCompra() {
        return compra;
    }

    public void setCompra(CompraBean compra) {
        this.compra = compra;
    }
//
//    public CompraBean getCompra() {
//        return compra;
//    }
    private IServicioSeguridad usuarios;
    
    private int referencia;   
    private int valor;
    private String Descripcion;
    private FormaPago formaPago;
    private boolean mostrarSolicitarTarjetaCredito;   
    private boolean mostrarSolicitarPSE;
    private String mensajeResultadoCompra;
    
    /**
     * Creates a new instance of PagoBean
     */
    public PagoBean() {        
        usuarios = new ServicioSeguridadMock();
    }
    
     public int getReferencia() {        
        return compra.getCompra().darNumeroOrden();
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
        mensajeResultadoCompra = "";
        String user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USUARIO").toString();                 
       Usuario usuario = usuarios.darUsuario(user);
       this.formaPago= this.formaPago == null ? FormaPago.PSE : this.formaPago;
        Compra compraRealizada = new Compra(this.formaPago, referencia, valor, 
                new Date(), carroCompras.darItems(), usuario.getCliente());        
        compra.getCompra().agregarCompra(compraRealizada);        
        mensajeResultadoCompra = "La compra a sido exitosa.";
    }
    
    public CarroComprasBean getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(CarroComprasBean carroCompras) {
        this.carroCompras = carroCompras;
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
        this.formaPago = FormaPago.CREDITO;
        this.setMostrarSolicitarPSE(false);
        this.setMostrarSolicitarTarjetaCredito(true);
    }
    
    public void solicitarPSE(){        
        this.formaPago = FormaPago.PSE;
        this.setMostrarSolicitarTarjetaCredito(false);
        this.setMostrarSolicitarPSE(true);
    }
    
    public String getMensajeResultadoCompra() {
        return mensajeResultadoCompra;
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
    
    
    public String irAlCatalogo(){
        //TODO: Arreglar el mapeo hacia donde va
        return "CatalogoMuebles";
    }
}
