package cr.ac.ucenfotec.bl;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalizadorBoW {

    /**
     * Ejecuta el análisis Bag of Words sobre la descripción del ticket
     * usando los diccionarios técnico y emocional. Retorna emociones,
     * categorías y palabras detonantes detectadas.
     */

    public static ResultadoAnalisis analizarDescripcion(
            String descripcion,
            ArrayList<DiccionarioTecnico> dicTecnico,
            ArrayList<DiccionarioEmocional> dicEmocional) {

        ResultadoAnalisis resultado = new ResultadoAnalisis();

        String textoNormalizado = normalizarTexto(descripcion);
        String[] tokens = tokenizar(textoNormalizado);
        ArrayList<String> palabrasFiltradas = filtrarStopWords(tokens);

        HashMap<String, Integer> conteoEmociones = new HashMap<>();
        HashMap<String, Integer> conteoCategorias = new HashMap<>();

        // Cruza tokens con el diccionario emocional para contar emociones y registrar detonantes.
        for (String token : palabrasFiltradas) {
            for (DiccionarioEmocional de : dicEmocional) {
                if (token.equalsIgnoreCase(de.getPalabra())) {
                    String emocion = de.getEmocion();
                    int cantidad = 0;
                    if (conteoEmociones.containsKey(emocion)) {
                        cantidad = conteoEmociones.get(emocion);
                    }
                    conteoEmociones.put(emocion, cantidad + 1);
                    resultado.agregarDetonanteEmocional(token);
                }
            }
        }

        // Cruza tokens con el diccionario técnico para sugerir categoría y registrar detonantes.
        for (String token : palabrasFiltradas) {
            for (DiccionarioTecnico dt : dicTecnico) {
                if (token.equalsIgnoreCase(dt.getPalabra())) {
                    String categoria = dt.getCategoria();
                    int cantidad = 0;
                    if (conteoCategorias.containsKey(categoria)) {
                        cantidad = conteoCategorias.get(categoria);
                    }
                    conteoCategorias.put(categoria, cantidad + 1);
                    resultado.agregarDetonanteTecnico(token);
                }
            }
        }

        // Determina la emoción dominante según la frecuencia registrada.
        String emocionDominante = "No determinada";
        int maxEmocion = 0;
        for (String emocion : conteoEmociones.keySet()) {
            int cantidad = conteoEmociones.get(emocion);
            if (cantidad > maxEmocion) {
                maxEmocion = cantidad;
                emocionDominante = emocion;
            }
        }
        resultado.setEmocionDominante(emocionDominante);

        // Determina la categoría técnica dominante según la frecuencia registrada.
        String categoriaDominante = "No determinada";
        int maxCategoria = 0;
        for (String categoria : conteoCategorias.keySet()) {
            int cantidad = conteoCategorias.get(categoria);
            if (cantidad > maxCategoria) {
                maxCategoria = cantidad;
                categoriaDominante = categoria;
            }
        }
        resultado.setCategoriaTecnicaDominante(categoriaDominante);

        return resultado;
    }

    /**
     * Normaliza el texto convirtiéndolo a minúsculas y eliminando tildes
     * y símbolos para facilitar el análisis.
     */
    private static String normalizarTexto(String texto) {
        String minusculas = texto.toLowerCase();
        String sinTildes = Normalizer.normalize(minusculas, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        String soloLetrasEspacio = sinTildes.replaceAll("[^a-zñáéíóúü0-9 ]", " ");
        return soloLetrasEspacio;
    }

    /**
     * Divide el texto normalizado en palabras individuales (tokens).
     */
    private static String[] tokenizar(String texto) {
        return texto.split("\\s+");
    }

    /**
     * Elimina palabras comunes (stopwords) para mejorar la calidad del análisis.
     */
    private static ArrayList<String> filtrarStopWords(String[] tokens) {
        ArrayList<String> resultado = new ArrayList<>();

        String[] stopWords = {
                "el","la","los","las","un","una","unos","unas",
                "de","del","al","a","y","o","que","es","en","por",
                "para","con","sin","muy","no","si","lo","su","sus",
                "mi","mis","tu","tus","ya","pero","como"
        };

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            boolean esStopWord = false;
            for (String stop : stopWords) {
                if (token.equals(stop)) {
                    esStopWord = true;
                    break;
                }
            }

            if (!esStopWord) {
                resultado.add(token);
            }
        }

        return resultado;
    }
}