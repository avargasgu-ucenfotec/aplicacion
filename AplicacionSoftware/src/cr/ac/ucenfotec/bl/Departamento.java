package cr.ac.ucenfotec.bl;

public class Departamento {

    /**
     * Representa un departamento institucional que puede gestionar tickets.
     * Incluye información básica como nombre, funciones, contacto y extensión.
     */

    //Atributos principales del departamento
    private String nombre;
    private String descripcion;
    private String correo;
    private String extension;

    /**
     * Constructor completo para registrar departamentos con toda su información.
     */
    public Departamento(String nombre, String descripcion, String correo, String extension) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.extension = extension;
    }

    /**
     * Constructor alternativo usado cuando solo se requiere nombre y descripción.
     */
    public Departamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getExtension() {
        return extension;
    }

    //Setters
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setDescripcion(String nuevoDescripcion) {
        this.descripcion = nuevoDescripcion;
    }

    public void setCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
    }

    public void setExtension(String nuevoExtension) {
        this.extension = nuevoExtension;
    }

    public String toString() {
        return "Nombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nCorreo electrónico: " + correo +
                "\nExtensión telefónica: " + extension +
                "\n";
    }

    public boolean equals(Departamento departamento) {
        return(nombre.equals(departamento.nombre));
    }
}