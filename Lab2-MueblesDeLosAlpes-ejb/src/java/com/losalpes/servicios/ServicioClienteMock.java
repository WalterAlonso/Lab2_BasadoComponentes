/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoMueble;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author waira2
 */
public class ServicioClienteMock implements IServicioCliente {

     //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los muebles del sistema
     */
    private ArrayList<Cliente> clientes;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioClienteMock()
    {

        //Inicializa el arreglo de los muebles
        clientes =new ArrayList<Cliente>();

        //Agrega los muebles del sistema
        clientes.add(new Cliente(TipoDocumento.Cedula, "102445126", "Pepito Perez", "4313022", "3154242542", "DG 85 82 28", "Bogota", "Ingeniero", "pepito@yahoo.com"));
    }
    
    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> darClientes() {
        return clientes;
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteEncontrado = bucarCliente(cliente.getNumeroDocumento());
       return clienteEncontrado;
    }
    
    private Cliente bucarCliente(String numeroDocumento) {
        for(int e = 0;e<clientes.size();e++){
            if(clientes.get(e).getNumeroDocumento()==numeroDocumento){
                return clientes.get(e);
            }
        }
        return null;
    }
}
