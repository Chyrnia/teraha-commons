# teraha-commons

`commons` es una librería creada para el proyecto de la materia **Sistemas Distribuidos** de la FIUNI.

Su función es proporcionar elementos compartidos por los microservicios del sistema distribuido, principalmente las entidades de dominio y los DTOs utilizados por sus APIs.

## Tecnologías

### JPA/Hibernate

Utilizamos las anotaciones de **Jakarta Persistence API (JPA)** para realizar el mapeo de las entidades entre Java y la base de datos, con **Hibernate** como proveedor de la implementación.

### Liquibase

Las migraciones de la base de datos son versionadas utilizando **Liquibase Community Edition**.

El esquema inicial se generó a partir de la base de datos existente y se mantiene mediante cambiosets versionados.

### Lombok

**Lombok** provee anotaciones que generan código *boilerplate*, permitiendo mantener las clases más sucintas y legibles.

### OpenAPI

Utilizamos **OpenAPI** para definir el contrato de las APIs del sistema.

A partir de la especificación OpenAPI, **OpenAPI Generator** genera automáticamente los DTOs Java durante el proceso de compilación. Los DTOs generados se incluyen en el paquete `com.teraha.commons.dtos`.

