/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.excepciones;

/**
 *
 * @author WALTER
 */
public class ClienteExistenteException extends Exception {
    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public ClienteExistenteException( String mensaje ){
        super( mensaje );
    }
}
