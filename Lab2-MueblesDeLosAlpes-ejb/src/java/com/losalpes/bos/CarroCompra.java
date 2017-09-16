/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WALTER
 */
public class CarroCompra {
    private List<DetalleCarroCompra> muebles;    
    
    public CarroCompra() {
        muebles = new ArrayList<DetalleCarroCompra>();
    }
    
    public List<DetalleCarroCompra> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<DetalleCarroCompra> muebles) {
        this.muebles = muebles;
    }
}
