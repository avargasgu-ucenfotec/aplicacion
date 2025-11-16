package cr.ac.ucenfotec.bl;

/**
 * Representa una entrada del diccionario técnico utilizada en el análisis
 * Bag of Words. Cada palabra se asocia a una categoría técnica.
 */
public class DiccionarioTecnico {

    private String palabra;       // Término técnico que se desea detectar
    private String categoria;     // Categoría técnica sugerida por la palabra

    /**
     * Crea una entrada del diccionario técnico con su palabra y categoría asociada.
     */
    public DiccionarioTecnico(String palabra, String categoria) {
        this.palabra = palabra;
        this.categoria = categoria;
    }

    // Getters
    public String getPalabra() {
        return palabra;
    }

    public String getCategoria() {
        return categoria;
    }

    // Setters
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean equals(DiccionarioTecnico otro) {
        return this.palabra.equalsIgnoreCase(otro.palabra);
    }

    public String toString() {
        return "Palabra: " + palabra + " | Categoría técnica: " + categoria;
    }
}