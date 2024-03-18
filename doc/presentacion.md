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
Parcial I<br />
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

El vicerrector de investigaciones de la Universidad del Quindío ha solicitado al departamento de tecnología e investigaciones, del cual usted forma parte, diseñar un sistema que permita gestionar los contactos de su agenda. 

Cada contacto debe tener un nombre, alias, dirección, teléfono y correo electrónico. Se considera que dos contactos son iguales si comparten el mismo nombre y teléfono, y un contacto puede pertenecer a varios grupos. Cada grupo debe tener un nombre y una categoría (oficina, fiesta, amigos, familia). 

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

Sistema que permita gestionar los contactos de su agenda. 

- Almacenar / Recuperarla información de contacto. 
  - No pueden haber dos contactos con el mismo nombre y teléfono.
- Almacenar / Recuperarla información de grupos.
  - Un contacto puede estar en varios grupos.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

<div style="font-size: 15pt;">

- **Agenda**:
  - nombre: Texto (ver prueba en el parcial)
  - descripcion: Texto (ver prueba en el parcial)
- **Contacto**:
  - nombre: Texto
  - alias: Texto
  - dirección: Texto
  - teléfono: Texto
  - correo electrónico: Texto. 
- **Grupo**:
  - nombre: Texto
  - categoría: Categoría ( oficina, fiesta, amigos, familia). 

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

<div style="position: absolute; left: 25%; top:30%; ">

![width:550](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>


- **Agenda**
  - Almacenar / Recuperarla información del dueño de la agenda.
  - Adicionar un contacto
  - Obtener los contactos
  - Adicionar un grupo
  - Obtener un grupo
  - Verificar la existencia de un contacto

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>


- **Grupo**

  - Almacenar / Recuperar la categoría
  - Adicionar un contacto
  - Obtener los contactos del grupo

- **Contacto**

  - Almacenar / Recuperar la información de un contacto.

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>



<div style="position: absolute; left: 20%; top:30%; ">

![width:690](diagrama-01.svg)
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

Clase: **Agenda**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Contactos iguales | Se crea una agenda  ("Personal", "Amigos y Familia"), se crean: contacto1 ("Raul", "Yulbra", "Cr 10 N", "12345", "ryrivera@uniquindio.edu.co") y el contacto2 Contacto("Raul", "El flaco", "Calle 100", "12345", "rarias@uniquindio.edu.co"). Luego se intentan adicionar los contactos a la agenda| Error, ya que el segundo contacto tiene el mismo nombre y correo que el primero. |
| Obtener listado ordenado por correo | Se crean  la agenda ("Programación I", "Esta es la agenda para guardar los contactos del vicerrector"). Se crean y se adicionan los contactos: camila = new Contacto ("Camila", "Camila", "Km 2", "3221593403", "camila@uniquindio.edu.co"), xiomara = new Contacto ("Xiomara", "Xiomi", "avenida 20 # 13-80", "3148763412", "xiomara@uniquindio.edu.co") y ana = new Contacto ("Ana Maria", "Anita", "Carrera 20", "3137442312", "anamaria@uniquindio.edu.co")| Se solicita el listado ordenado por correo y se obtiene la colección {ana, camila, xionara}.|


</div>

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
