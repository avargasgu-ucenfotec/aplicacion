package cr.ac.ucenfotec.bl;

/**
 * Representa una entrada del diccionario emocional usada para el análisis
 * Bag of Words. Cada palabra se asocia a una emoción específica.
 */
public class DiccionarioEmocional {

    private String palabra;       // Palabra clave relacionada con emociones
    private String emocion;       // Emoción que esa palabra representa

    /**
     * Crea una entrada emocional del diccionario con su palabra y emoción asociada.
     */
    public DiccionarioEmocional(String palabra, String emocion) {
        this.palabra = palabra;
        this.emocion = emocion;
    }

    // Getters
    public String getPalabra() {
        return palabra;
    }

    public String getEmocion() {
        return emocion;
    }

    // Setters
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public boolean equals(DiccionarioEmocional otro) {
        return this.palabra.equalsIgnoreCase(otro.palabra);
    }

    public String toString() {
        return "Palabra: " + palabra + " | Emoción: " + emocion;
    }
}