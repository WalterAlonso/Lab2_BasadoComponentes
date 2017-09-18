/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioSeguridad.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.bos.Ciudad;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.Departamento;
import com.losalpes.bos.DetalleCarroCompra;
import com.losalpes.bos.Pais;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.excepciones.AutenticacionException;
import java.util.ArrayList;

/**
 * Clase que se encarga de la autenticación de un usuario en el sistema
 * 
 */
public class ServicioSeguridadMock implements IServicioSeguridad
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los usuarios del sistema
     */
    private ArrayList<Usuario> usuarios;

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     *
     */
    public ServicioSeguridadMock()
    {
        //Inicializa el arreglo que contiene los usuarios
        usuarios=new ArrayList<Usuario>();

        Usuario usuario = new Usuario("client","clientclient",TipoUsuario.CLIENTE);
        usuario.setCliente(new Cliente(TipoDocumento.Cedula, "102445126", "Pepito Perez", "4313022", "3154242542", "DG 85 82 28", Pais.Colombia, Departamento.Bogota, Ciudad.Bogota, "Ingeniero", "pepito@yahoo.com"));
        //Agrega usuarios al sistema
        usuarios.add(new Usuario("admin","adminadmin",TipoUsuario.ADMINISTRADOR));
        usuarios.add(usuario);

    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Registra el ingreso de un usuario al sistema.
     * @param nombre Login del usuario que quiere ingresar al sistema.
     * @param contraseña Contraseña del usuario que quiere ingresar al sistema.
     * @return usuario Retorna el objeto que contiene la información del usuario que ingreso al sistema.
     */
    @Override
    public Usuario login(String nombre, String contraseña) throws AutenticacionException
    {
        Usuario u=null;

        boolean termino=false;

        for (int i = 0; i < usuarios.size() && !termino; i++)
        {
            u=usuarios.get(i);

            if(u.getNombre().equals(nombre)&& u.getContraseña().equals(contraseña))
            {
               termino=true;
            }
            else if(i==usuarios.size()-1)
            {
                throw new AutenticacionException("Usuario Inválido");
            }
        }

        return u;
    }
    
    @Override
    public Usuario darUsuario(String nombreUsuario) {
         for (Usuario usuario : usuarios) {
            if(usuario.getNombre().equals(nombreUsuario))
                return usuario;
        }
        return null;    
    }
    
    @Override
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
}
