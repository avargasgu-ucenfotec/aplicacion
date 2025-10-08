public class Usuario {

    //Clase "Usuario" que representa una persona que interactúa con el sistema.

    //Atributos
    private String nombre;          //Nombre completo del usuario.
    private String correo;          //Correo electrónico del usuario.
    private String contrasena;      //Contraseña del usuario para ingresar al sistema.
    private String telefono;        //Número de teléfono del usuario.
    private String tipo;            //Rol del usuario. Opciones válidas: administrador, estudiante, funcionario.

    //Métodos
    //Constructor
    public Usuario(String nombre, String correo, String contrasena, String telefono, String tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String correo, String contrasena, String tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    //Setter
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
    }

    public void setContrasena(String nuevoContrasena) {
        this.contrasena = nuevoContrasena;
    }

    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    public void setTipo(String nuevoTipo) {
        this.tipo = nuevoTipo;
    }

    //toString()
    public String toString() {
        return "Nombre completo: " + nombre +
                "\nCorreo electrónico: " + correo +
                "\nContraseña: " + contrasena +
                "\nTeléfono de contacto: " + telefono +
                "\nTipo de usuario: " + tipo +
                "\n";
    }
}
