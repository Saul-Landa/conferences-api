# Conferences API

Debemos generar las imágenes de cada microservicio.

* Primero debemos generar los archivos .jar, ingresamos a la raíz de cada carpeta (conferences-service, eureka-server, gateway-server y users-service) y ejecutamos lo siguiente:

```sh
$ .\mvnw clean package -DskipTests
```

* Al mismo tiempo debemos crear las imágenes para docker con los siguientes comandos:

| Carpeta | Comando |
| ------ | ------ |
| conferences-service | docker build -t conferences-service:1.0.0 . |
| eureka-server | docker build -t eureka-server:1.0.0 . |
| gateway-server | docker build -t gateway-server:1.0.0 . |
| users-service | docker build -t users-service:1.0.0 . |

* Una vez generadas todas las imágenes, entramos a la carpeta docker-compose y ejecutamos el siguiente comando para tener los microservicios en un cotener de docker:

```sh
$ docker compose up -d
```

# Nota

- Se agrega una carpeta con una collección de postman para hacer pruebas a los diferentes end points.
- En caso de que cause problemas el uso de la dependecia "users-commons" agregada en el pom.xml, se debe ingresar a la raíz de ese proyecto y ejecutar el siguiente comando:

```sh
$ mvnw.cmd clean install -DskipTests
```
