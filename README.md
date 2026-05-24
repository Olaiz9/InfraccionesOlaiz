# Sistema de Infracciones de Tránsito
Aplicación Full-Stack (API REST Desarrollada con SpringBoot) desarrollada para la gestión integral de multas y control vehicular.

## Tecnologías utilizadas
- Java
- Spring Boot
- Spring Data JPA + Hibernate
- MySQL 8
- HTML5 / CSS3 (Diseño Glassmorphism)
- JavaScript Vanilla (Fetch API)
- SweetAlert2 (Notificaciones asíncronas)

## Arquitectura
El proyecto implementa el patrón de diseño de capas clásico de Spring Boot en el backend, y una arquitectura SPA (Single Page Application) en el frontend:
- **Repository:** Interfaces que heredan de `JpaRepository` para el manejo de datos.
- **Service / ServiceImpl:** Lógica de negocio y validaciones.
- **Controller:** Endpoints REST que exponen la API en formato JSON.

## Entidades Principales
- **Vehículo:** Datos del rodado, incluyendo relaciones con Marca y Modelo.
- **Conductor y Licencia:** Relación uno a uno. La creación del conductor genera automáticamente su licencia.
- **AutoridadDeConstatacion:** Oficiales de tránsito capacitados para labrar actas.
- **ActaDeConstatacion:** Entidad transaccional que unifica Vehículo, Licencia, Autoridad y el detalle numérico/descriptivo de la infracción.

## Diagrama UML original
<img width="1247" height="791" alt="WhatsApp Image 2026-05-24 at 19 03 21" src="https://github.com/user-attachments/assets/f2dda629-ccd7-4253-8fc7-c1ec151366fa" />

## Requisitos para correr el proyecto
- Java 17 o superior
- MySQL 8 corriendo en localhost:3306 (o en la que lo tenfaa corriendo)
- IntelliJ IDEA (o IDE de preferencia)
- Navegador web moderno

## Configuración
Creá una base de datos en MySQL y luego editá el archivo `src/main/resources/application.properties` con tus credenciales:

##
- `properties spring.datasource.url=jdbc:mysql://localhost:3306/db_infracciones`
- `spring.datasource.username=root`
- `spring.datasource.password=tu_contraseña`
- `spring.jpa.hibernate.ddl-auto=update`

## Correr el proyecto
- Clonar el repositorio.
- Configurar el application.properties con tu base de datos y contraseña local.
- Ejecutar la clase principal en IntelliJ para levantar el backend en http://localhost:8080.
- Abrir el archivo index.html (ubicado en el frontend) haciendo doble clic para cargarlo en el navegador.

## Funcionalidades Destacadas
- CRUD completo de Vehículos, Conductores y Autoridades.
- Labrado de Actas con cruce de datos relacionales en tiempo real.
- Borrado en cascada controlado por JavaScript para proteger la integridad referencial (Foreign Keys).
- Validaciones en el cliente (bloqueo de números en nombres, letras en DNI/Licencias).
- Interfaz gráfica moderna (Glassmorphism) con notificaciones animadas (SweetAlert2).
- Carga asíncrona de datos para selectores y tablas.
