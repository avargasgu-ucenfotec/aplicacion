# Aplicación de software - Aplicación de mesa de ayuda universitaria
## Alcance
1. Registrar usuarios únicos.
2. Registrar departamentos únicos.
3. Registrar tickets con asunto, descripción y estado.
4. Gestionar los diccionarios dinámicos desde la aplicación.
5. Garantizar la seguridad, persistencia y buenas prácticas de la arquitectura.
### Requerimientos funcionales
-   [x] El sistema no debe permitir usuarios duplicados.
-   [x] El sistema no debe permitir departamentos duplicados.
-   [x] El sistema permite registrar tickets con:
    -   [x] Asunto
    -   [x] Descripción
    -   [x] Estado
-   [x] El sistema analiza el texto de un ticket usando _Bag of Words_:
    -   [x] Detecta el estado de ánimo del usuario
    -   [x] Sugiere categoría técnica del ticket
-   [x] El sistema gestiona los diccionarios dinámicos desde la aplicación.
-   [ ] El sistema garantiza seguridad.
-   [ ] El sistema garantiza persistencia.
-   [x] El sistema garantiza buenas prácticas de la arquitectura.
-   [ ] Usuarios
    -   [x] El usuario se identifica de forma única mediante su correo electrónico.
    -   [ ] Las contraseñas se deben almacenar en la base de datos encriptadas.
    -   [x] Registro obligatorio del nombre completo.
    -   [x] Registro obligatorio del correo electrónico.
    -   [x] Registro obligatorio de la contraseña.
    -   [x] Registro opcional del teléfono de contacto.
    -   [x] Registro obligatorio del tipo de usuario (administrador, estudiante, funcionario).
-   [ ] Departamentos
    -   [x] Registro de departamentos.
    -   [ ] Administración de departamentos.
    -   [x] Cada ticket debe estar asociado a un departamento.
    -   [x] Registro obligatorio del nombre.
    -   [x] Registro obligatorio de la descripción breve de las funciones o alcance.
    -   [x] Registro opcional del correo electrónico.
    -   [x] Registro opcional de la extensión telefónica.
-   [x] Tickets
    -   [x] Registro obligatorio de asunto.
    -   [x] Registro obligatorio de descripción.
    -   [x] Registro obligatorio de estado (nuevo, en progreso, resuelto).
    -   [x] Registro obligatorio de usuario.
    -   [x] Registro obligatorio de departamento.
-   [x] Diccionarios dinámicos
    -   [x] CRUD de palabras en el diccionario técnico.
    -   [x] CRUD de palabras en el diccionario emocional.
    -   [x] Las palabras deben ser únicas dentro de cada diccionario.
-   [x] Análisis _Bag of Words_
    -   [x] El sistema debe permitir ejecutar, bajo demanda, un análisis de la descripción de un ticket.
    -   [x] El análisis detecta el estado de ánimo del usuario, y muestra las palabras detonantes.
    -   [x] El análisis sugiere la categoría técnica, y muetras las palabras detonantes.
-   [ ] Configuración externa
    -   [ ] La información de conexión a la base de datos debe estar en un archivo externo.
    -   [ ] La aplicación debe leer automáticamente el archivo externo al iniciar.
### Requerimientos no funcionales
-   [ ] Interfaz gráfica construida en Java Swing.
-   [x] Arquitectura en capaz.
-   [ ] Persistencia de datos mediante el uso de una base de datos relacional MySQL.
-   [ ] Contraseñas encriptadas.
-   [x] Calidad del código.
