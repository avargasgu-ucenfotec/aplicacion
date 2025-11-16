package cr.ac.ucenfotec.db;

import java.util.ArrayList;
import cr.ac.ucenfotec.bl.*;

/**
 * Maneja la “base de datos” en memoria del sistema.
 * Centraliza usuarios, departamentos, tickets y diccionarios para
 * facilitar la gestión desde el menú y asegurar las validaciones necesarias.
 */
public class Database {

    private final ArrayList<Usuario> datosUsuario;                  // Usuarios registrados
    private final ArrayList<Departamento> datosDepartamento;        // Departamentos registrados
    private final ArrayList<Ticket> datosTicket;                    // Tickets registrados
    private final ArrayList<DiccionarioTecnico> datosDiccionarioTecnico;     // Palabras técnicas
    private final ArrayList<DiccionarioEmocional> datosDiccionarioEmocional; // Palabras emocionales

    /**
     * Inicializa todas las colecciones en memoria.
     */
    public Database() {
        datosUsuario = new ArrayList<>();
        datosDepartamento = new ArrayList<>();
        datosTicket = new ArrayList<>();
        datosDiccionarioTecnico = new ArrayList<>();
        datosDiccionarioEmocional = new ArrayList<>();
    }

    // ================================================================
    //      MÉTODOS DE INSERCIÓN BÁSICOS
    // ================================================================

    /** Inserta un usuario validado. */
    public void insertarUsuario(Usuario usuario) {
        datosUsuario.add(usuario);
    }

    /** Inserta un departamento validado. */
    public void insertarDepartamento(Departamento departamento) {
        datosDepartamento.add(departamento);
    }

    /** Inserta un ticket validado. */
    public void insertarTicket(Ticket ticket) {
        datosTicket.add(ticket);
    }

    // ================================================================
    //      REGISTRO DE ENTIDADES CON VALIDACIONES
    // ================================================================

    /**
     * Registra un usuario verificando unicidad por correo.
     */
    public void registrarUsuario(String nombre, String correo, String contrasena, String telefono, String tipo) {
        Usuario usuario = new Usuario(nombre, correo, contrasena, telefono, tipo);
        if (estaRepetidoUsuario(usuario)) {
            System.out.println("""
                            Registro no completado.
                            El correo electrónico ingresado ya se encuentra registrado.
                            Intente de nuevo con un correo electrónico distinto.""");
        } else {
            insertarUsuario(usuario);
            System.out.println("Registro completado.");
        }
    }

    /**
     * Registra un departamento verificando unicidad por nombre.
     */
    public void registrarDepartamento(String nombre, String descripcion, String correo, String extension) {
        Departamento departamento = new Departamento(nombre, descripcion, correo, extension);
        if (estaRepetidoDepartamento(departamento)) {
            System.out.println("""
                            Registro no completado.
                            El departamento ingresado ya se encuentra registrado.
                            Intente de nuevo con un nombre de departamento distinto.""");
        } else {
            insertarDepartamento(departamento);
            System.out.println("Registro completado.");
        }
    }

    /**
     * Registra un ticket asociándolo obligatoriamente a un usuario
     * y a un departamento existentes.
     */
    public void registrarTicket(String asunto, String descripcion, String correoUsuario, String nombreDepartamento) {

        Usuario usuarioAsociado = buscarUsuarioPorCorreo(correoUsuario);
        if (usuarioAsociado == null) {
            System.out.println("Error: El usuario con ese correo no existe.");
            return;
        }

        Departamento departamentoAsociado = buscarDepartamentoPorNombre(nombreDepartamento);
        if (departamentoAsociado == null) {
            System.out.println("Error: El departamento indicado no existe.");
            return;
        }

        Ticket ticket = new Ticket(asunto, descripcion, usuarioAsociado, departamentoAsociado);
        insertarTicket(ticket);

        System.out.println("Ticket registrado exitosamente.");
    }

    // ================================================================
    //      IMPRESIÓN DE LISTAS
    // ================================================================

    public void imprimirListaUsuarios() {
        if (datosUsuario.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario u : datosUsuario) {
                System.out.println(u);
            }
        }
    }

    public void imprimirListaDepartamentos() {
        if (datosDepartamento.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            for (Departamento d : datosDepartamento) {
                System.out.println(d);
            }
        }
    }

    public void imprimirListaTickets() {
        if (datosTicket.isEmpty()) {
            System.out.println("No hay tickets registrados.");
        } else {
            for (Object o : datosTicket) {
                System.out.println(o);
            }
        }
    }

    // ================================================================
    //      VALIDACIONES DE DUPLICADOS
    // ================================================================

    /** Verifica si ya existe un usuario con el mismo correo. */
    public boolean estaRepetidoUsuario(Usuario usuario) {
        for (Usuario u : datosUsuario) {
            if (u.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    /** Verifica si ya existe un departamento con el mismo nombre. */
    public boolean estaRepetidoDepartamento(Departamento departamento) {
        for (Departamento d : datosDepartamento) {
            if (d.equals(departamento)) {
                return true;
            }
        }
        return false;
    }

    // ================================================================
    //      BÚSQUEDAS
    // ================================================================

    /** Busca un usuario por correo, usado para asociar tickets. */
    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario u : datosUsuario) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        return null;
    }

    /** Busca un departamento por nombre, usado para asociar tickets. */
    public Departamento buscarDepartamentoPorNombre(String nombre) {
        for (Departamento d : datosDepartamento) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null;
    }

    // ================================================================
    //      CRUD DICCIONARIO TÉCNICO
    // ================================================================

    /**
     * Agrega una palabra técnica si no existe previamente.
     */
    public void agregarPalabraTecnica(String palabra, String categoria) {
        if (existePalabraTecnica(palabra)) {
            System.out.println("La palabra ya existe en el diccionario técnico.");
            return;
        }

        datosDiccionarioTecnico.add(new DiccionarioTecnico(palabra, categoria));
        System.out.println("Palabra técnica agregada correctamente.");
    }

    public DiccionarioTecnico buscarPalabraTecnica(String palabra) {
        for (DiccionarioTecnico d : datosDiccionarioTecnico) {
            if (d.getPalabra().equalsIgnoreCase(palabra)) {
                return d;
            }
        }
        return null;
    }

    public boolean existePalabraTecnica(String palabra) {
        return buscarPalabraTecnica(palabra) != null;
    }

    /**
     * Edita palabra y categoría técnica evitando duplicados.
     */
    public void editarPalabraTecnica(String palabraActual, String nuevaPalabra, String nuevaCategoria) {
        DiccionarioTecnico encontrado = buscarPalabraTecnica(palabraActual);

        if (encontrado == null) {
            System.out.println("La palabra indicada no existe en el diccionario técnico.");
            return;
        }

        if (!palabraActual.equalsIgnoreCase(nuevaPalabra) && existePalabraTecnica(nuevaPalabra)) {
            System.out.println("La nueva palabra ya existe en el diccionario técnico.");
            return;
        }

        encontrado.setPalabra(nuevaPalabra);
        encontrado.setCategoria(nuevaCategoria);

        System.out.println("Palabra técnica editada exitosamente.");
    }

    public void eliminarPalabraTecnica(String palabra) {
        DiccionarioTecnico encontrada = buscarPalabraTecnica(palabra);

        if (encontrada == null) {
            System.out.println("La palabra no existe en el diccionario técnico.");
            return;
        }

        datosDiccionarioTecnico.remove(encontrada);
        System.out.println("Palabra técnica eliminada.");
    }

    public void listarDiccionarioTecnico() {
        if (datosDiccionarioTecnico.isEmpty()) {
            System.out.println("No hay palabras en el diccionario técnico.");
            return;
        }

        for (DiccionarioTecnico dt : datosDiccionarioTecnico) {
            System.out.println(dt);
        }
    }

    // ================================================================
    //      CRUD DICCIONARIO EMOCIONAL
    // ================================================================

    public void agregarPalabraEmocional(String palabra, String emocion) {
        if (existePalabraEmocional(palabra)) {
            System.out.println("La palabra ya existe en el diccionario emocional.");
            return;
        }

        datosDiccionarioEmocional.add(new DiccionarioEmocional(palabra, emocion));
        System.out.println("Palabra emocional agregada correctamente.");
    }

    public DiccionarioEmocional buscarPalabraEmocional(String palabra) {
        for (DiccionarioEmocional d : datosDiccionarioEmocional) {
            if (d.getPalabra().equalsIgnoreCase(palabra)) {
                return d;
            }
        }
        return null;
    }

    public boolean existePalabraEmocional(String palabra) {
        return buscarPalabraEmocional(palabra) != null;
    }

    /**
     * Edita una palabra emocional y su emoción asociada.
     */
    public void editarPalabraEmocional(String palabraActual, String nuevaPalabra, String nuevaEmocion) {
        DiccionarioEmocional encontrado = buscarPalabraEmocional(palabraActual);

        if (encontrado == null) {
            System.out.println("La palabra indicada no existe en el diccionario emocional.");
            return;
        }

        if (!palabraActual.equalsIgnoreCase(nuevaPalabra) && existePalabraEmocional(nuevaPalabra)) {
            System.out.println("La nueva palabra ya existe en el diccionario emocional.");
            return;
        }

        encontrado.setPalabra(nuevaPalabra);
        encontrado.setEmocion(nuevaEmocion);

        System.out.println("Palabra emocional editada exitosamente.");
    }

    public void eliminarPalabraEmocional(String palabra) {
        DiccionarioEmocional encontrada = buscarPalabraEmocional(palabra);

        if (encontrada == null) {
            System.out.println("La palabra no existe en el diccionario emocional.");
            return;
        }

        datosDiccionarioEmocional.remove(encontrada);
        System.out.println("Palabra emocional eliminada.");
    }

    public void listarDiccionarioEmocional() {
        if (datosDiccionarioEmocional.isEmpty()) {
            System.out.println("No hay palabras en el diccionario emocional.");
            return;
        }

        for (DiccionarioEmocional de : datosDiccionarioEmocional) {
            System.out.println(de);
        }
    }

    // ================================================================
    //      ANÁLISIS BAG OF WORDS
    // ================================================================

    /**
     * Muestra los tickets disponibles con su índice para selección en el análisis.
     */
    public void listarTicketsConIndice() {
        if (datosTicket.isEmpty()) {
            System.out.println("No hay tickets registrados.");
            return;
        }

        for (int i = 0; i < datosTicket.size(); i++) {
            Ticket t = datosTicket.get(i);
            System.out.println(i + ") " + t.getAsunto());
        }
    }

    /**
     * Ejecuta el análisis Bag of Words sobre el ticket seleccionado
     * y despliega los resultados.
     */
    public void analizarTicketPorIndice(int indice) {
        if (datosTicket.isEmpty()) {
            System.out.println("No hay tickets registrados.");
            return;
        }

        if (indice < 0 || indice >= datosTicket.size()) {
            System.out.println("Índice de ticket inválido.");
            return;
        }

        Ticket ticket = datosTicket.get(indice);

        ResultadoAnalisis resultado = AnalizadorBoW.analizarDescripcion(
                ticket.getDescripcion(),
                datosDiccionarioTecnico,
                datosDiccionarioEmocional
        );

        System.out.println("\n=== Análisis Bag of Words del ticket ===");
        System.out.println("Asunto: " + ticket.getAsunto());
        System.out.println("Descripción: " + ticket.getDescripcion());
        System.out.println("Estado de ánimo detectado: " + resultado.getEmocionDominante());
        System.out.println("Palabras detonantes emocionales: " + resultado.getDetonantesEmocionales());
        System.out.println("Categoría técnica sugerida: " + resultado.getCategoriaTecnicaDominante());
        System.out.println("Palabras detonantes técnicas: " + resultado.getDetonantesTecnicos());
    }
}