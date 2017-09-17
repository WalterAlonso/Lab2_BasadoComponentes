/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.CarroCompra;
import com.losalpes.bos.Color;
import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.bos.Dimension;
import com.losalpes.bos.Material;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author WALTER
 */
@Named(value = "carroComprasBean")
@ManagedBean
@SessionScoped
public class CarroComprasBean {

    private List<DetalleCarroCompra> carroCompra;

    public List<DetalleCarroCompra> getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(List<DetalleCarroCompra> carroCompra) {
        this.carroCompra = carroCompra;
    }
    
    /**
     * Creates a new instance of CarroComprasBean
     */
    public CarroComprasBean() {
        carroCompra = new ArrayList<>();
        
        //TODO: Borrarlo siguiente, es para testear:
        carroCompra.add(new DetalleCarroCompra(new Mueble("RF1","Silla clásica","Una confortable silla con estilo del siglo XIX.",TipoMueble.Interior, Material.Madera, new Dimension(0, 0, 0), Color.Caoba, 0, 5000, 2, "img/pag/silla.png"), 1));
    }
    
    public void agregarItem(DetalleCarroCompra item){
        carroCompra.add(item);
    } 
    
    public List<DetalleCarroCompra> darItems() {
        return carroCompra;
    }
    
    public int darPrecioTotal() {
        int precio = 0;
        for (DetalleCarroCompra item : carroCompra) {
            precio += item.getCantidad()* item.getMueble().getPrecio();
        }
        return precio;
    }
        
    /**
     * Envia a la pagina de resumen de la compra, cuando el usurio da clic a ir a pagar
     * @return 
     */
    public String irAlResumenCompra() {
        return "resumenCompra";
    }
    
    /**
     * Envia al usuario a pagar, en el cual se obtiene el metodo dfe pago y los datos 
     * del usuario
     * @return 
     */
    public String irAPagar() {
        return "pagar";
    }
    
}
