/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.bos;

/**
 * Clase que representa la información de un mueble en el sistema
 */
public class Mueble
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private String referencia;

    /**
     * Nombre del mueble.
     */
    private String nombre;

    /**
     * Descripción del mueble.
     */
    private String descripcion;

    /**
     * Tipo de mueble.
     */
    private TipoMueble tipo;
  
    /**
     * Indica si el mueble fue seleccionado
     */
    private boolean seleccion;

    private Material material;
    
    private Dimension dimension;
    
    private Color color;
    
    private int peso;
    
    private int precio;
    
    private int cantidad;
    
    private String foto;
   
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public Mueble() 
    {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param referencia Referencia del mueble
     * @param nombre Nombre del mueble
     * @param descripcion Descripión del mueble
     * @param tipo Tipo de mueble
     */
    public Mueble(String referencia, String nombre, String descripcion, TipoMueble tipo)
    {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    public Mueble(String referencia, String nombre, String descripcion, TipoMueble tipo,
            Material material, Dimension dimension, Color color, int peso, int precio, int cantidad,
            String foto)
    {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.material = material;
        this.dimension = dimension;
        this.color = color;
        this.peso = peso;
        this.precio = precio;
        this.cantidad = cantidad;
        this.foto = foto;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la descripción del mueble
     * @return descripcion Descripción del mueble
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripción del mueble
     * @param descripcion Nueva descripción del mueble
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre del mueble
     * @return nombre Nombre del mueble
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Modifica el nombre del mueble
     * @param nombre Nuevo nombre del mueble
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Devuelve la referencia del mueble
     * @return referencia Referencia del mueble
     */
    public String getReferencia()
    {
        return referencia;
    }

    /**
     * Modifica la referencia del mueble
     * @param referencia Nueva referencia del mueble
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * Devuelve el tipo de mueble
     * @return tipo Tipo de mueble
     */
    public TipoMueble getTipo()
    {
        return tipo;
    }

    /**
     * Modifica el tipo de mueble
     * @param tipo Nuevo tipo de mueble
     */
    public void setTipo(TipoMueble tipo)
    {
        this.tipo = tipo;
    }

    /**
     * Devuelve el estado de selección del mueble
     * @return seleccion Verdadero o falso
     */
    public boolean isSeleccion()
    {
        return seleccion;
    }

    /**
     * Cambia el estado de selección de un mueble
     * @param seleccion Nuevo estado de selección
     */
    public void setSeleccion(boolean seleccion)
    {
        this.seleccion = seleccion;
    }

  public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }   
}
