/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author waira2
 */
@Named(value = "adminHomeBean")
@Dependent
public class AdminHomeBean {

    /**
     * Creates a new instance of AdminHomeBean
     */
    public AdminHomeBean() {
    }

    public String irAdminCliente() {
        return "adminCliente";
    }

    public String irAdminCatalogo() {
        return "adminCatalogo";
    }
    
    public String irAdminReportes() {
        return "reportes";
    }
}
