# demo

Luis es un profesor de la universidad del Quindío que le ha solicitado diseñar un sistema para la gestión de los estudiantes del curso de programación 1. Él necesita que la aplicación que permita:

Almacenar la información de un estudiante, incluyendo su número de identificación, nombres, apellidos, correo, teléfono y edad.


# Autores

- Profesores del área de programación

# Herramientas

- [java 17](https://adoptium.net/es)
- [junit 5.10.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0)
- [maven](https://maven.apache.org)


# Construcción y pruebas

Para compilar el proyecto puede usar el comando:

```shell
mvn clean compile
```

Para ejecutar las pruebas puede usar el comando: 

```shell
 mvn clean test
```

Para generar el jar puede usar el comando: 

```shell
 mvn clean package
```

y para ejecutar el jar

```shell
 java -jar target/demo-1.0.jar
```
