/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.ServicioCatalogoMock;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Juan Paz
 */
@Named(value = "homeBean")
@Dependent
public class HomeBean {

    private IServicioCatalogo catalogo;

    private List<DetalleCarroCompra> carroCompra;

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
        catalogo = new ServicioCatalogoMock();
    }

    public String irIndex() {
        return "index";
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     *
     * @return muebles Muebles del sistema
     */
    public List<Mueble> getMuebles() {
        return catalogo.darMuebles();
    }

    public void agregarItem(Mueble mueble) {
        DetalleCarroCompra item = new DetalleCarroCompra(mueble, 1);
        carroCompra.add(item);
    }
}
