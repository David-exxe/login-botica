# Login Botica "Salud Ica" - Lab 14 Docker

Login con Spring Boot + Thymeleaf, usuarios estáticos (sin BD).

| Usuario | Clave | Rol |
|---|---|---|
| admin | admin123 | Administrador |
| caja01 | caja123 | Cajero |
| alm01 | alm123 | Almacenero |

## Ejecución con Docker
mvnw.cmd clean package -DskipTests
docker build -t login-botica .
docker run -d -p 8081:8080 --name botica login-botica

Abrir: http://localhost:8081/login
(Se usó el puerto 8081 porque el 8080 estaba ocupado por otro contenedor.)
