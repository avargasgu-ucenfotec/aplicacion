package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

/**
 * Contiene los resultados generados por el análisis Bag of Words.
 * Almacena la emoción dominante, la categoría técnica sugerida
 * y las palabras detonantes detectadas durante el análisis.
 */
public class ResultadoAnalisis {

    private String emocionDominante;
    private String categoriaTecnicaDominante;
    private ArrayList<String> detonantesEmocionales;   // Palabras que activaron emociones
    private ArrayList<String> detonantesTecnicos;      // Palabras que activaron categorías técnicas

    /**
     * Inicializa las listas de detonantes para evitar valores nulos.
     */
    public ResultadoAnalisis() {
        detonantesEmocionales = new ArrayList<>();
        detonantesTecnicos = new ArrayList<>();
    }

    // Getters y setters principales
    public String getEmocionDominante() {
        return emocionDominante;
    }

    public void setEmocionDominante(String emocionDominante) {
        this.emocionDominante = emocionDominante;
    }

    public String getCategoriaTecnicaDominante() {
        return categoriaTecnicaDominante;
    }

    public void setCategoriaTecnicaDominante(String categoriaTecnicaDominante) {
        this.categoriaTecnicaDominante = categoriaTecnicaDominante;
    }

    public ArrayList<String> getDetonantesEmocionales() {
        return detonantesEmocionales;
    }

    public ArrayList<String> getDetonantesTecnicos() {
        return detonantesTecnicos;
    }

    /**
     * Registra una palabra detonante emocional, evitando duplicados.
     */
    public void agregarDetonanteEmocional(String palabra) {
        if (!detonantesEmocionales.contains(palabra)) {
            detonantesEmocionales.add(palabra);
        }
    }

    /**
     * Registra una palabra detonante técnica, evitando duplicados.
     */
    public void agregarDetonanteTecnico(String palabra) {
        if (!detonantesTecnicos.contains(palabra)) {
            detonantesTecnicos.add(palabra);
        }
    }
}