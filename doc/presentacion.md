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

<div style="font-size: 20pt">

Ana es profesora en la Universidad del Quindío y necesita un sistema para el control de la asistencia de sus estudiantes de Programación I.

Ella desea poder indicar la PRESENCIA o AUSENCIA de sus estudiantes en las clases del curso. Las clases tiene una fecha y hora programada de antemano. 

Además ella quiere conocer:
- los asistentes y ausentes a cierta clase del curso; 
- el porcentaje de asistencia de cada una de las clases; 
- la cantidad de ausencias de un determinado estudiante, teniendo en cuente que, si el estudiante no tiene una asistencia explicita de PRESENTE, se asume como AUSENTE. 

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

Sistema para el control de la asistencia de sus estudiantes de Programación I.

- Almacenar / Recuperarla información de un estudiante. 
- Programar las clases del curso.
- Indicar la asistencia o ausencia de los estudiantes en cada clase.
- Obtener la lista de asistentes y ausentes a cierta clase del curso.
- Calcular el porcentaje de asistencia de cada una de las clases.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- **Estudiante**, como no se especifica se asume la información del estudiante de Problema 01 para su reutilización

  - nombres : Texto
  - apellidos :Texto
  - número de identificación: Texto
  - correo: Texto
  - teléfono : Texto 
  - edad: Entero

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>


- **Curso**
  - nombre : Texto
- **Clase del Curso**
  - fechaClase: Fecha
- **Tipo de asistencia**
  - PRESENTE
  - AUSENTE
- **Asistencia**
  - tipo de asistencia: Tipo de asistencia
  - clase programada: Clase del curso

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

<div style="position: absolute; left: 8%; top:30%; ">

![width:1100](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>


- **Estudiante**
  - Almacenar / Recuperarla información de un estudiante. 
  - Indicar la asistencia o ausencia de los estudiantes en cada clase.


- **Curso**
  - Programar las clases del curso.
  - Obtener la lista de asistentes y ausentes a cierta clase del curso.
  - Calcular el porcentaje de asistencia de cada una de las clases.


---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>



<div style="position: absolute; left: 3%; top:30%; ">

![width:1200](diagrama-01.svg)
</div>


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

- Almacenar datos de prueba
- Recuperar los datos de prueba
- Verificar que los datos almacenados coinciden con los datos recuperados


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

Pruebas a asociadas a las clase **Curso** que se está reutilizando del Problema 02.
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">


Clase: **Estudiante**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos | Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18)| Estudiante creado Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) |
| Con datos nulos | Estudiante(null,null,null,null,null,0) | Error, faltan datos para la creación del estudiante |
| Datos vacíos | Estudiante(“”, “”, “camila@uniquindio.edu.co”, “”, 18)| Error, faltan datos para la creación del estudiante |
| Edad negativa | Estudiante(“Camila", "Alzate Rios”, “109453264”, “camila@uniquindio.edu.co”, “315635674”, -18) |Error, la edad no pueden ser negativos                      |
| Correo inválido | Estudiante(“Camila", "Alzate Rios”, “109453264”, “cami”, “315635674”, 18)  | Error, el correo del estudiante es invalido         |

Pruebas a asociadas a las clase **Estudiante** que se está reutilizando del Problema 01.
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">


Clase: **ClaseCurso**
| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Clase Curso en la fecha actual | Se crear una ClaseCurso con la fecha actual | Se verifica que la fecha es la actual |
| Clase curso con fecha nula | Se intenta crear una fecha con nulo | Error, no se puede crear una ClaseCurso con la fecha nula |

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">



Clase: **Asistencia**
| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Asistencia de PRESENTE en una clase ocho días atrás | Se crear una ClaseCurso con la fecha de ocho días atrás y se crea una asistencia de PRESENTE para esa clase | Se verifica que la asistencia tiene los datos correctos |
| Asistencia de AUSENTE en una clase 1 mes atrás | Se crear una ClaseCurso con la fecha de 1 mes atrás y se crea una asistencia de AUSENTE para esa clase | Se verifica que la asistencia tiene los datos correctos |
| Asistencia con clase curso nula | Se intenta crear una asistencia con clase de curso nulo | Error, no se puede crear una asistencia con una ClaseCurso nula |



---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">


Clase: **Estudiante**
| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Indicar la presencia a una clase del curso | Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) se le indica que estaba presente en la clase del curso del día 19-Feb-2024 a las 14:00 | Estudiante “Camila" queda con asistencia en la clase indicada |
| Indicar la ausencia a una clase del curso | Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) se le indica que estaba ausente en la clase del curso del día 19-Feb-2024 a las 14:00 | Estudiante “Camila" queda con ausencia en la clase indicada |
| Obtener la asistencia una clase del curso no programada| Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) NO se le indica que estaba presente / ausente en la clase del curso del día 19-Feb-2024 a las 14:00 | Estudiante “Camila" queda con ausencia en la clase indicada (valor por omisión) |
| Indicar la presencia a una clase del curso | Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) se le indica que estaba presente null | Error, la clase del curso no puede ser nula |

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">


Clase: **Curso**
| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Se programan clases para el curso  | Al curso de "Programación 1" se le programan tres clases separadas con ocho días de diferencia. La primera clase 15 atrás de la fecha actual, la segunda 8 atrás y la tercera en la fecha actual. Estas clases son para el curso de "Programación 1" | Se obtienen las tres clases debidamente programadas.|
| Lista de asistentes  | Al curso de "Programación 1" se le crean tres estudiantes "Xiomara", "Ana", "Juan" (con los otros datos de forma arbitraria) se indica que "Xiomara" asistió a todas las clases; a "Ana" solamente se le indica que asistió a la primera y la última; y finalmente se indica que "Juan" estaba ausente en la segunda, presente en la tercera pero no se indica nada en la primera. Solicita la lista de los que asistieron a la primera clase | Se obtiene que son "Xiomara" y "Ana" |
| Lista de ausentes  | Al curso de "Programación 1" se le crean tres estudiantes "Xiomara", "Ana", "Juan" (con los otros datos de forma arbitraria) se indica que "Xiomara" asistió a todas las clases; a "Ana" solamente se le indica que asistió a la primera y la última; y finalmente se indica que "Juan" estaba ausente en la segunda, presente en la tercera pero no se indica nada en la primera. Solicita la lista de los ausentes a la segunda clase | Se obtiene que son "Ana" y "Juan" |

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt">


Clase: **Curso**
| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Porcentaje de asistencia de una clase | Al curso de "Programación 1" se le crean tres estudiantes "Xiomara", "Ana", "Juan" (con los otros datos de forma arbitraria) se indica que "Xiomara" asistió a todas las clases; a "Ana" solamente se le indica que asistió a la primera y la última; y finalmente se indica que "Juan" estaba ausente en la segunda, presente en la tercera pero no se indica nada en la primera. Solicita el porcentaje de asistencia de la primera clase| Se obtiene 2/3 (0.66) |
| Cantidad de ausencias | Al curso de "Programación 1" se le crean tres estudiantes "Xiomara", "Ana", "Juan" (con los otros datos de forma arbitraria) se indica que "Xiomara" asistió a todas las clases; a "Ana" solamente se le indica que asistió a la primera y la última; y finalmente se indica que "Juan" estaba ausente en la segunda, presente en la tercera pero no se indica nada en la primera. Solicita la cantidad de ausencias de "Juan"| Se obtiene que son 2 |

---


<style scoped>
.texto:after {
    content: 'Reconocimiento de patrones: ¿Qué puede reutilizar?';
  }
</style>


- La clase **Estudiante** del Problema 01 con sus respectivas pruebas.

- Se reutiliza parte de la clase **Curso** del Problema 02 y algunas de sus pruebas asociadas con el alcance de este problema.


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
