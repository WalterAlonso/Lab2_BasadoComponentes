/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

/**
 *
 * @author waira2
 */
public class Cliente {

    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String telefonoResidencia;
    private String celular;
    private String direccion;
    private Pais pais;
    private Departamento departamento;
    private Ciudad ciudad;
    private String profesion;
    private String email;

    private CarroCompra carroCompra;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------   
    public Cliente() {

    }

    public Cliente(TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String telefonoResidencia,
            String celular, String direccion,Pais pais, Departamento departamento, Ciudad ciudad, String profesion, String email) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.telefonoResidencia = telefonoResidencia;
        this.celular = celular;
        this.direccion = direccion;
        this.pais = pais;
        this.departamento = departamento;        
        this.ciudad = ciudad;
        this.profesion = profesion;
        this.email = email;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public CarroCompra getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(CarroCompra carroCompra) {
        this.carroCompra = carroCompra;
    }
}
