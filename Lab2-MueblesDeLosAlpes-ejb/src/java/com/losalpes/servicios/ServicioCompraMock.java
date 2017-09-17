/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Ciudad;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Departamento;
import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.bos.FormaPago;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.Pais;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoMueble;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WALTER
 */
public class ServicioCompraMock implements IServicioCompra {
    
    private static int generadorNumeroOrden = 6;
     /**
     * Arreglo con los muebles del sistema
     */
    private ArrayList<Compra> compras;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioCompraMock()
    {
        //Inicializa el arreglo de los muebles
        compras=new ArrayList<Compra>();
        
        Cliente cliente = new Cliente(TipoDocumento.Cedula, "102445126", "Pepito Perez", "4313022", "3154242542", "DG 85 82 28", Pais.Colombia, Departamento.Bogota, Ciudad.Bogota, "Ingeniero", "pepito@yahoo.com");
        
        Mueble muebleUno = new Mueble("RF2","Silla moderna","Lo último en la moda de interiores. Esta silla le brindará la comodidad e innovación que busca",TipoMueble.Interior);
        Mueble muebleDos = new Mueble("RF3","Mesa de jardín","Una bella mesa para comidas y reuniones al aire libre.",TipoMueble.Exterior);
        
        DetalleCarroCompra detalleUno = new DetalleCarroCompra(muebleUno, 2);
        DetalleCarroCompra detalleDos = new DetalleCarroCompra(muebleDos, 1);
        
        List<DetalleCarroCompra> listDetalleUno = new ArrayList<>();
        listDetalleUno.add(detalleUno);
        List<DetalleCarroCompra> listDetalleDos = new ArrayList<>();
        listDetalleUno.add(detalleUno); 
        listDetalleUno.add(detalleDos); 
                
        //Agrega los muebles del sistema
        compras.add(new Compra(FormaPago.CREDITO, 1, 5000, new Date(2016,01,12),  listDetalleUno, cliente));
        compras.add(new Compra(FormaPago.PSE, 2, 10000, new Date(2016,07,12),  listDetalleDos, cliente));        
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    @Override
    public Compra agregarCompra(Compra compra)    
    {
        compra.setNumeroOrden(generadorNumeroOrden);
        compras.add(compra);
        generadorNumeroOrden ++;
        return compra;
    }

    /**
     * Devuelve los muebles del sistema
     * @return muebles Arreglo con todos los muebles del sistema
     */
    @Override
    public List<Compra> darCompras()
    {
        return compras;
    }
}
