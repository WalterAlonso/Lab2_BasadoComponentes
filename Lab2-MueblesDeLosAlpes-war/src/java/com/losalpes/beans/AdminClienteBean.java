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
import com.losalpes.bos.Usuario;
import com.losalpes.excepciones.ClienteExistenteException;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.ServicioClienteMock;
import com.losalpes.servicios.ServicioSeguridadMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * 
     */
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Relación con la interfaz que provee los servicios necesarios del cliente.
     */
    private IServicioCliente clientes;
    
    private IServicioSeguridad usuarios;
    /**
     * Variable para determinar si un botón se muestra o no
     */
    private boolean visible;

    public AdminClienteBean() {
        cliente = new Cliente();
        usuario = new Usuario();
        clientes = new ServicioClienteMock();
        usuarios = new ServicioSeguridadMock();
        visible = false;
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
     * @return clientes Clientes del sistema
     */
    public List<Cliente> getClientes() {

        return clientes.darClientes();
    }

    /**
     * Devuelve Variable para determinar si un botón se muestra o no
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un nuevo cliente al sistema
     */
    public void agregarCliente() throws ClienteExistenteException {
         try {
    
        clientes.agregarCliente(cliente);
        usuario.setCliente(cliente);
        usuario.setNombre(cliente.getNumeroDocumento());
        usuarios.agregarUsuario(usuario);
         } catch (ClienteExistenteException ex) {
            
        }
         cliente = new Cliente();
    }

    /**
     * Eliminar un cliente del sistema
     *
     * @param cliente
     */
    public void eliminarCliente(Cliente cliente) {
        clientes.eliminarCliente(cliente);
        cliente = new Cliente();
    }

    /**
     * Actualizar un cliente del sistema
     *
     * @param cliente
     */
    public void actualizarCliente() {
        clientes.actualizarCliente(cliente);
        cliente = new Cliente();
        visible = false;
    }

    /**
     * Actualizar un cliente del sistema
     *
     * @param cliente
     */
    public void verCliente(Cliente cliente) {
        this.cliente = cliente;
        visible = true;
    }

    /**
     * Buscar un cliente del sistema
     *
     */
    public void buscarCliente() {
        Cliente clienteB = clientes.buscarCliente(cliente.getNumeroDocumento());
        if (clienteB != null) {
            visible = true;
            cliente = clienteB;
        }

    }

    /**
     * Elimina la información del mueble
     */
    public void limpiar() {
        cliente = new Cliente();
        visible = false;
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
