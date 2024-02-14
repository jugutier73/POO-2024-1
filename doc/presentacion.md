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

Luis es un profesor de la universidad del Quindío que le ha solicitado diseñar un sistema para la gestión de los estudiantes del curso de programación 1. Para ello, él necesita que la aplicación que permita:

Almacenar la información de un estudiante, incluyendo su número de identificación, nombres, apellidos, correo, teléfono y edad.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

- Almacenar la información de un estudiante. 


---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- nombres : Texto
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

- Estudiante

<div style="position: absolute; left: 40%; top:30%; ">


![width:300](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué solicitan finalmente?';
  }
</style>

- Almacenar la información de un estudiante
- Recuperar la información de un estudiante



---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Almacenar la 
información del estudiante

<div style="position: absolute; left: 40%; top:30%; ">

![width:800](diagrama-01.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Recuperar la información
 de un estudiante

<div style="position: absolute; left: 40%; top:30%; ">

![width:800](diagrama-02.svg)
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

<div style="font-size: 9pt">

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos | Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18)| Estudiante creado Estudiante(“Camila", "Alzate Rios”,”109453264”, “camila@uniquindio.edu.co”, “315635674”, 18) |
| Con datos nulos | Estudiante(null,null,null,null,null,0) | Error, faltan datos para la creación del estudiante |
| Datos vacíos | Estudiante(“”, “”, “camila@uniquindio.edu.co”, “”, 18)| Error, faltan datos para la creación del estudiante |
| Edad negativa | Estudiante(“Camila", "Alzate Rios”, “109453264”, “camila@uniquindio.edu.co”, “315635674”, -18) |Error, la edad no pueden ser negativos                      |
| Correo inválido | Estudiante(“Camila", "Alzate Rios”, “109453264”, “cami”, “315635674”, 18)  | Error, el correo del estudiante es invalido         |

</div>

---


<style scoped>
.texto:after {
    content: 'Reconocimiento de patrones: ¿Qué puede reutilizar?';
  }
</style>

- No aplica


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
