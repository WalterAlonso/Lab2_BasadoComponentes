/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Ciudad;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.Departamento;
import com.losalpes.bos.Pais;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.ServicioClienteMock;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author waira2
 */
@Named(value = "adminClienteBean")
@ManagedBean
@ApplicationScoped
public class AdminClienteBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Representa un nuevo cliente a ingresar
     */
    private Cliente cliente;
    /**
     * Relación con la interfaz que provee los servicios necesarios del cliente.
     */
    private IServicioCliente clientes;

    public AdminClienteBean() {
        cliente = new Cliente();
        clientes=new ServicioClienteMock();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el objeto mueble
     *
     * @return cliente Objeto cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica el objeto cliente
     *
     * @param cliente Nuevo cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve una lista con todos los clientes del sistema
     *
     * @return muebles Muebles del sistema
     */
    public List<Cliente> getClientes() {

        return clientes.darClientes();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un nuevo mueble al sistema
     */
    public void agregarCliente() {
        clientes.agregarCliente(cliente);
        cliente = new Cliente();
    }
    
    
    /**
     * Agrega un nuevo mueble al sistema
     * @param cliente
     */
    public void eliminarCliente(Cliente cliente) {
        clientes.eliminarCliente(cliente);
}
    
    

    /**
     * Elimina la información del mueble
     */
    public void limpiar() {
        cliente = new Cliente();
    }

    /**
     * Devuelve los tipos de documento
     *
     * @return sitems Tipos de documentos en el sistema
     */
    public SelectItem[] getTiposDocumentos() {
        TipoDocumento[] tipos = TipoDocumento.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
   
     /**
     * Devuelve los tipos de documento
     *
     * @return sitems Tipos de documentos en el sistema
     */
    public SelectItem[] getPaises() {
        Pais[] tipos = Pais.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
    
    /**
     * Devuelve los tipos de documento
     *
     * @return sitems Tipos de documentos en el sistema
     */
    public SelectItem[] getDepartamentos() {
        Departamento[] tipos = Departamento.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
    
    /**
     * Devuelve los tipos de documento
     *
     * @return sitems Tipos de documentos en el sistema
     */
    public SelectItem[] getCiudades() {
        Ciudad[] tipos = Ciudad.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
}
