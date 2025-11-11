# Aplicación de software - Aplicación de mesa de ayuda universitaria
## Alcance
1. Registrar usuarios únicos.
2. Registrar departamentos únicos.
3. Registrar tickets con asunto, descripción y estado.
4. Gestionar los diccionarios dinámicos desde la aplicación.
5. Garantizar la seguridad, persistencia y buenas prácticas de la arquitectura.
### Requerimientos funcionales
-   [ ] El sistema no debe permitir usuarios duplicados.
-   [ ] El sistema no debe permitir departamentos duplicados.
-   [ ] El sistema permite registrar tickets con:
    -   [ ] Asunto
    -   [ ] Descripción
    -   [ ] Estado
-   [ ] El sistema analiza el texto de un ticket usando _Bag of Words_:
    -   [ ] Detecta el estado de ánimo del usuario
    -   [ ] Sugiere categoría técnica del ticket
-   [ ] El sistema gestiona los diccionarios dinámicos desde la aplicación.
-   [ ] El sistema garantiza seguridad.
-   [ ] El sistema garantiza persistencia.
-   [ ] El sistema garantiza buenas prácticas de la arquitectura.
-   [ ] Usuarios
    -   [ ] El usuario se identifica de forma única mediante su correo electrónico.
    -   [ ] Las contraseñas se deben almacenar en la base de datos encriptadas.
    -   [ ] Registro obligatorio del nombre completo.
    -   [ ] Registro obligatorio del correo electrónico.
    -   [ ] Registro obligatorio de la contraseña.
    -   [ ] Registro opcional del teléfono de contacto.
    -   [ ] Registro obligatorio del tipo de usuario (administrador, estudiante, funcionario).
-   [ ] Departamentos
    -   [ ] Registro de departamentos.
    -   [ ] Administración de departamentos.
    -   [ ] Cada ticket debe estar asociado a un departamento.
    -   [ ] Registro obligatorio del nombre.
    -   [ ] Registro obligatorio de la descripción breve de las funciones o alcance.
    -   [ ] Registro opcional del correo electrónico.
    -   [ ] Registro opcional de la extensión telefónica.
-   [ ] Tickets
    -   [ ] Registro obligatorio de asunto.
    -   [ ] Registro obligatorio de descripción.
    -   [ ] Registro obligatorio de estado (nuevo, en progreso, resuelto).
    -   [ ] Registro obligatorio de usuario.
    -   [ ] Registro obligatorio de departamento.
-   [ ] Diccionarios dinámicos
    -   [ ] CRUD de palabras en el diccionario técnico.
    -   [ ] CRUD de palabras en el diccionario emocional.
    -   [ ] Las palabras deben ser únicas dentro de cada diccionario.
-   [ ] Análisis _Bag of Words_
    -   [ ] El sistema debe permitir ejecutar, bajo demanda, un análisis de la descripción de un ticket.
    -   [ ] El análisis detecta el estado de ánimo del usuario, y muestra las palabras detonantes.
    -   [ ] El análisis sugiere la categoría técnica, y muetras las palabras detonantes.
-   [ ] Configuración externa
    -   [ ] La información de conexión a la base de datos debe estar en un archivo externo.
    -   [ ] La aplicación debe leer automáticamente el archivo externo al iniciar.
### Requerimientos no funcionales
-   [ ] Interfaz gráfica construida en Java Swing.
-   [ ] Arquitectura en capaz.
-   [ ] Persistencia de datos mediante el uso de una base de datos relacional MySQL.
-   [ ] Contraseñas encriptadas.
-   [ ] Calidad del código.
