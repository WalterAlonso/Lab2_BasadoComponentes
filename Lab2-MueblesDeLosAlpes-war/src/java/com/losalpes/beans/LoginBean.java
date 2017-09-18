/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ LoginBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.excepciones.AutenticacionException;
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.ServicioSeguridadMock;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Managed bean encargado de la autenticación en el sistema
 *
 */
@Named(value = "loginBean")
@SessionScoped
@ManagedBean
public class LoginBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Contraseña del usuario
     */
    private String contraseña;

    /**
     * Relación con la interfaz adecuada para la autenticación de usuarios
     */
    private IServicioSeguridad servicio;

    /**
     * Determina si existe error o no
     */
    private boolean error;
    
//    public String getFrom() {
//        return from;
//    }
// 
//    public void setFrom(String from) {
//        this.from = from;
//    }
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase
     */
    public LoginBean() {
        error = false;
        servicio = new ServicioSeguridadMock();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Realiza la autenticación de un usuario que desea entrar al sistema
     *
     * @return tipoUsuario Devuelve el tipo de usuario
     */
    public String login() throws ServletException, IOException {        
        try {
            Usuario user = servicio.login(usuario, contraseña);
            if (user == null) {
                return "";
            }
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("USUARIO", usuario);                 
            if (user.getTipo() == TipoUsuario.ADMINISTRADOR) {                
                return "adminHome";
            } else {                
//                 if(from != null){
//                    FacesContext.getCurrentInstance().getExternalContext().redirect(from);
//                }
                return "resumenCompra";
            }
        } catch (AutenticacionException ex) {
            error = true;
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public void logout() throws ServletException, IOException{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        request.logout();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index");
    }
 
    public Usuario getLoggedUser(){
        String user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USUARIO").toString();         
        //if(request.getUserPrincipal() != null) {
            //String name = request.getUserPrincipal().getName();
            return servicio.darUsuario(user);        
    } 
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el nombre del usuario
     *
     * @return usuario Nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Modifica el nombre del usuario
     *
     * @param usuario Nuevo nombre del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la contraseña del usuario
     *
     * @return contraseña Contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Modifica la contraseña de un usuario
     *
     * @param contraseña Nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Devuelve el estado de la autenticación (si es error o no)
     *
     * @return error Estado de autenticación
     */
    public boolean isError() {
        return error;
    }

    /**
     * Modifica el estado de error
     *
     * @param error Nuevo estado
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Cierra el panel de error
     */
    public void cerrarPanelError() {
        error = false;
    }
}
