public class Departamento {

    //Clase "Departamento" que representa un departamento que gestiona un ticket.

    //Atributos
    private String nombre;          //Nombre del departamento.
    private String descripcion;     //Descripción breve de las funciones o alcance del departamento.
    private String correo;          //Correo electrónico del departamento.
    private String extension;       //Extensión telefónica del departamento.

    //Métodos
    //Constructor
    public Departamento(String nombre, String descripcion, String correo, String extension) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.extension = extension;
    }

    public Departamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Getter
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

    //Setter
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setDescripcion(String nuevoDescripcion) {
        this.descripcion = descripcion;
    }

    public void setCorreo(String nuevoCorreo) {
        this.correo = correo;
    }

    public void setExtension(String nuevoExtension) {
        this.extension = extension;
    }

    //toString()
    public String toString() {
        return "Nombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nCorreo electrónico: " + correo +
                "\nExtensión telefónica: " + extension +
                "\n";
    }
}
