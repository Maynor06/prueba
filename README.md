# Proyecto de Noticiero API

Este proyecto es una API desarrollada con **Java** y **Spring Boot** para un sistema de noticiero. La base de datos utilizada es **PostgreSQL** y los endpoints fueron probados utilizando **Postman**. A continuación se describen los principales endpoints disponibles en la API.

## Tecnologías utilizadas

- **Java** (JDK 17)
- **Spring Boot** (para la creación de la API)
- **PostgreSQL** (para la base de datos)
- **Spring Security** (para autenticación)
- **JWT** (para autenticación basada en tokens)
- **Postman** (para testing de los endpoints)

## Endpoints

A continuación se listan los principales endpoints disponibles:

### **Autenticación y Registro**
- `POST /auth/login` – Inicia sesión y devuelve un token JWT.
- `POST /user/register` – Registra un nuevo usuario y devuelve un token JWT.

### **Gestión de Noticias**
- `POST /news/createNew` – Crea una nueva noticia.
- `PUT /news/editNew/{id}` – Edita una noticia existente por su ID.
- `DELETE /news/deleteNew/{id}` – Elimina una noticia por su ID.
- `GET /news/newForCategory` – Obtiene noticias por categoría.
- `GET /news/newsOfAuthor` – Obtiene noticias por autor.

### **Gestión de Favoritos**
- `POST /Fav/newFav` – Agrega una noticia a los favoritos.
- `DELETE /Fav/removeFav` – Elimina una noticia de los favoritos.
- `GET /Fav/myFavs/{id}` – Obtiene todos los favoritos de un usuario.

## Testing de los Endpoints

Los endpoints fueron testeados utilizando **Postman**. Puedes encontrar ejemplos de uso y más detalles en el siguiente [documento de ejemplos](https://drive.google.com/file/d/1Z-LtuB1avBbVO2f8dIswQUofczPFIPvj/view?usp=sharing).

## Instrucciones para ejecutar el proyecto

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/Maynor06/prueba

2. **Configura la base de datos**:
   
   - Asegúrate de tener PostgreSQL instalado y crea una base de datos.
   - Actualiza el archivo application.properties con los detalles de tu base de datos.
   
3. **Ejecuta el proyecto**:
   
   - Usa Maven o Gradle para compilar y ejecutar la aplicación.
