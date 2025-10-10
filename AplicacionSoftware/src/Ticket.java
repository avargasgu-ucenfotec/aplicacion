public class Ticket {

    //Clase "Ticket" que representa un ticket generado por un usuario y asignado a un departamento.

    //Atributos
    private String asunto;          //Asunto del ticket
    private String descripcion;     //Descripción de la situación que justifica el registro del ticket.
    private String estado;          //Estado del ticket. Opciones válidas: nuevo, en progreso, resuelto.
    private String usuario;         //Nombre del usuario que registra el ticket.
    private String departamento;    //Nombre del departamento que maneja el ticket.

    //Métodos
    //Constructor
    public Ticket(String asunto, String descripcion, String estado, String usuario, String departamento) {
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

    public String getUsuario() {
        return usuario;
    }

    public String getDepartamento() {
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

    public void setUsuario(String nuevoUsuario) {
        this.usuario = nuevoUsuario;
    }

    public void setDepartamento(String nuevoDepartamento) {
        this.departamento = nuevoDepartamento;
    }

    //toString()
    public String toString() {
        return "Asunto: " + asunto +
                "\nDescripción: " + descripcion +
                "\nEstado: " + estado +
                "\nUsuario: " + usuario +
                "\nDepartamento: " + departamento +
                "\n";
    }
}
