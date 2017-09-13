/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import java.util.List;

/**
 *
 * @author waira2
 */
public interface IServicioCliente {
    
    public void agregarCliente(Cliente cliente);

    public List<Cliente> darClientes();
    
    public void eliminarCliente(Cliente cliente);
    
    public Cliente actualizarCliente(Cliente cliente);
}
