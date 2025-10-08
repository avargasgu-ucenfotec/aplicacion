public class Ticket {

    //Clase "Ticket" que representa un ticket generado por un usuario y asignado a un departamento.

    //Atributos
    private String asunto;              //Asunto del ticket
    private String descripcion;         //Descripción de la situación que justifica el registro del ticket.
    private String estado;              //Estado del ticket. Opciones válidas: nuevo, en progreso, resuelto.
    private Usuario usuario;            //Usuario que registra el ticket.
    private Departamento departamento;  //Departamento que maneja el ticket.

    //Métodos
    //Constructor
    public Ticket(String asunto, String descripcion, String estado, Usuario usuario, Departamento departamento) {
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.departamento = departamento;
    }

    public Ticket(String asunto, String descripcion) {
        this.asunto = asunto;
        this.descripcion = descripcion;
    }

    //Getter
    public String getAsunto() {
        return asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    //Setter
    public void setAsunto(String nuevoAsunto) {
        this.asunto = nuevoAsunto;
    }

    public void setDescripcion(String nuevoDescripcion) {
        this.descripcion = nuevoDescripcion;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void setUsuario(Usuario nuevoUsuario) {
        this.usuario = nuevoUsuario;
    }

    public void setDepartamento(Departamento nuevoDepartamento) {
        this.departamento = nuevoDepartamento;
    }

    //toString()
    public String toString() {
        return "Asunto: " + asunto +
                "\nDescripción: " + descripcion +
                "\nEstado: " + estado +
                "\nUsuario: " + usuario.getNombre() +
                "\nDepartamento: " + departamento.getNombre() +
                "\n";
    }
}
