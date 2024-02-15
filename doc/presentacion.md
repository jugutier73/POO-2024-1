---
marp: true
header: <div class="encabezado"><img src='imagenes/franjaSuperior.png'  /><div class="titulo"><h1 class="texto"></h1></div></div>
footer: '![image](imagenes/franjaInferior.png)' 
_header: '' 
_footer: '' 
paginate: true
_paginate: false
_backgroundImage: url('imagenes/fondo.png')
style: |

  .encabezado {
    position: relative; left: 0; top:0;display: inline-block; text-align: center;
  }
  .titulo {
    position: absolute; top: 40%; left: 50%; transform: translate(0%, -50%); color: gray;
  }
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
  .texto:after {
    content: 'Titulo';
  }
  
  h1 { color: black }
---

<div style="position: absolute; left: 30%; top:45%; width: 70%; text-align: left"><h1 style="color: gray">Programación Orientada a Objetos</h1></div>
<div style="position: absolute; left: 30%; top:55%; width: 70%; text-align: left"><h5 style="color: gray">Área de programación<br />
Programa de Ingeniería de Sistemas y Computación<br />
Facultad de Ingeniería
</h5></div>

<div style="position: absolute; left: 45%; top:20%; background-color: rgb(212, 231, 205); width: 550px">
<b>
Problema: <br />
Información de un estudiante<br />
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---


<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

Robinson es un profesor de la universidad del Quindío que le ha solicitado diseñar un sistema para la gestión de los estudiantes del curso de Programación 1. Para ello, él necesita que la aplicación que permita:

Almacenar la información de **VARIOS** estudiantes, incluyendo su número de identificación (sin repetir), nombres, apellidos, correo, teléfono y edad. Desea listar los estudiantes en orden alfabético y en orden descendente según la edad. También desea obtener la lista de los estudiantes menores de edad.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

- Almacenar/Recuperar la información de varios estudiante. 
- Agregar/Recuperar un estudiante al curso
- Obtener el listado de los estudiantes en orden alfabético
- Obtener el listado de los estudiantes en orden descendente según la edad
- Obtener el listado de los estudiantes menores de edad

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- del curso
  - nombre: Texto
  - La lista de estudiantes del curso : Colección de estudiantes
- por cada estudiante
  - nombres : Text
  - apellidos :Texto
  - número de identificación: Texto
  - correo: Texto
  - teléfono : Texto 
  - edad: Entero



---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

- Curso
- Estudiante

<div style="position: absolute; left: 40%; top:30%; ">


![width:500](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Estudiante
  - Almacenar/Recuperar la información de varios estudiante. 
- Curso
  - Obtener el nombre del curso
  - Agregar un estudiante al curso
      - Validar que el número de identificación no exista
  - Obtener el listado de los estudiantes en orden alfabético
  - Obtener el listado de los estudiantes en orden descendente según la edad
  - Obtener el listado de los estudiantes menores de edad

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

![width:1500](diagrama-01.svg)



---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>


<div style="font-size: 12pt;">

Clase: **Estudiante**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos | Estudiante(“Camila", "Alzate Rios”, ”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18)| Estudiante creado Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) |
| Con datos nulos | Estudiante(null,null,null,null,null,0) | Error, faltan datos para la creación del estudiante |
| Datos vacíos | Estudiante(“”, “”, “camila@uniquindio.edu.co”, “”, 18)| Error, faltan datos para la creación del estudiante |
| Edad negativa | Estudiante(“Camila, Alzate Rios”, “109453264”, “camila@uniquindio.edu.co”, “315635674”, -18) |Error, la edad no pueden ser negativos                      |
| Correo inválido | Estudiante(“Camila, Alzate Rios”, “109453264”, “cami”, “315635674”, 18)  | Error, el correo del estudiante es invalido         |

Pruebas a asociadas a las clase **Estudiante** que se está reutilizando del Problema 01.
</div>

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **Curso**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos | Curso("Programación 1")| Curso creado Curso("Programación 1") |
| Agregar un estudiante | registrarEstudiante( Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) )| Estudiante registrado Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18)|
| Agregar un estudiante nulo | registrarEstudiante( null )| Error, no puede agregar un estudiante nulo.|
| Agregar un estudiante repetido | registrarEstudiante( Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) ) <br> registrarEstudiante( Estudiante(Rodrigo", "Calderon”,”109453264”, “rodrigo@uniquindio.edu.co”, “3223451278”, 19) )| Error, no puede registrar dos veces el mismo número de identificación |
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **Curso**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Obtener listado alfabético | registrarEstudiante( Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 15) ) <br> registrarEstudiante( Estudiante(“Xiomara", "Gomez”,”109445634”, “xiomara@uniquindio.edu.co”, “3148763412”, 31) ) <br> registrarEstudiante( Estudiante(“Ana Maria", "Quintero”,”109498764”, “anamaria@uniquindio.edu.co”, “3137442312”, 28) ) <br> registrarEstudiante( Estudiante(“Yudi", "Pulgarin”,”1092394924”, “yudi@uniquindio.edu.co”, “3218341234”, 17) )| Se obtiene el listado de los estudiantes en el orden: "Ana Maria", "Camila", "Xiomara", "Yudi" |
| Obtener listado edad descendete | registrarEstudiante( Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 15) ) <br> registrarEstudiante( Estudiante(“Xiomara", "Gomez”,”109445634”, “xiomara@uniquindio.edu.co”, “3148763412”, 31) ) <br> registrarEstudiante( Estudiante(“Ana Maria", "Quintero”,”109498764”, “anamaria@uniquindio.edu.co”, “3137442312”, 28) ) <br> registrarEstudiante( Estudiante(“Yudi", "Pulgarin”,”1092394924”, “yudi@uniquindio.edu.co”, “3218341234”, 17) )| Se obtiene el listado de los estudiantes en el orden: "Xiomara", "Ana Maria", "Yudi", "Camila" |
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **Curso**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Obtener listado menores de edad | registrarEstudiante( Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 15) ) <br> registrarEstudiante( Estudiante(“Xiomara", "Gomez”,”109445634”, “xiomara@uniquindio.edu.co”, “3148763412”, 31) ) <br> registrarEstudiante( Estudiante(“Ana Maria", "Quintero”,”109498764”, “anamaria@uniquindio.edu.co”, “3137442312”, 28) ) <br> registrarEstudiante( Estudiante(“Yudi", "Pulgarin”,”1092394924”, “yudi@uniquindio.edu.co”, “3218341234”, 17) )| Se obtiene el listado de los estudiantes en el orden:  "Camila", "Yudi" |
</div>



---


<style scoped>
.texto:after {
    content: 'Reconocimiento de patrones: ¿Qué puede reutilizar?';
  }
</style>

- La clase **Estudiante** del Problema 01 con sus respectivas pruebas.


---

<style scoped>
.texto:after {
    content: 'Codificación: ';
  }
</style>

- **¿Cómo pruebo la solución?**

  - Almacenar datos de prueba de un estudiante. 
  - Recuperar datos de prueba de un estudiante. 
  - Verificar que los datos almacenados coinciden con los datos recuperados

- **Cómo escribo la solución en Java?**

  Ver la carpeta del *src* en el proyecto de **Visual Studio Code**



---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
