---
title: Taller UD09_03: Proyecto JavaFX (con Maven)
language: ES
author: David Martínez Peña [www.martinezpenya.es]
subject: Programación
keywords: [PRG, 2025, Programacion, Java]
IES: IES Eduardo Primo Marqués (Carlet)
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
---


[toc]

# Crea un proyecto de JavaFx (con Maven)

Cuando creas un proyecto en Intellij, el mismo IDE ofrece un tipo de proyecto JavaFx: 

<img src="/assets/javafxmaven1.png" alt="Proyecto JavaFX, paso 1" style="zoom:50%;" />

> ### Fíjate que al elegir el tipo de proyecto JavaFX a la parte derecha se selecciona el gestor de librerías Maven.
>
>  En el siguiente tema veremos como gestionar manualmente Maven, de momento dejaremos que IntelliJ genere el projecto Maven para JavaFx por nosotros.
>
> Solo debes fijarte en escribir tu nombre y apellidos como en la imagen y seleccionar la versión 21 del jdk.

En la siguiente ventana debes marcar al menos estas dos opciones:

<img src="/assets/javafxmaven2.png" alt="Proyecto JavaFX, paso 2" style="zoom: 50%;" />

Y por último pulsar el botón [Create]

Si esperas unos segundos aparecerá una notificación en la parte inferior derecha:

<img src="/assets/javafxmaven3.png" alt="Proyecto JavaFX, paso 3" style="zoom:50%;" />

Debes elegir la opción Load Maven Project, y esperar a que procese las dependencias solicitadas.



Estructura del proyecto JavaFx recien creado con el asistente de IntelliJ:

![Proyecto JavaFX, paso 4](/assets/javafxmaven4.png)

En la imágen anterior puedes encontrar:

1. fichero `pom.xml` que gestiona las dependencias del proyecto maven.
2. `HelloApplication` clase que contiene el main de la aplicación JavaFx
3. `HelloController` clase con el controlador de la aplicación
4. `hello-view.fxml` archivo que contiene el formulario (vista) de la apliación

El proyecto sigue el patrón MVC que hemos visto en teoria, solo que es tan simple que no tiene ningún Modelo.

# Modificar el formulario con `SceneBuilder`

Si has configurado correctamente `SceneBuilder` en tu ordenador para usarlo desde IntelliJ, deberias poder pulsar con el botón derecho del ratón sobre el archivo (4) (`hello-view.fxml`) y elegir la opción `Abrir en SceneBuilder`:

<img src="/assets/javafxmavenSceneBuilder.png" alt="Proyecto JavaFX, Scene Builder" style="zoom:50%;" />

# Usa `FXMLManager`

Ahora, vamos a añadir cualquier componente a nuestra interfaz (preferiblemente mediante `SceneBuilder`), en nuestro caso, por ejemplo, otro botón (al que llamaremos "mola":

<img src="/assets/javafxmaven5.png" alt="Proyecto JavaFX, paso 5" style="zoom:50%;" />

Ahora nuestra vista tiene un componente más que nuestro controlador, y aquí es donde entra en acción `FXMLManager` ya que en lugar de estar pendientes de ir añadiendo nuestras modificaciones en la Vista a nuestro Controlador, `FXMLManager` se encargará de gestionarlo.

Hacemos clic derecho sobre el archivo `hello-view.fxml` y elegimos la opción:

<img src="/assets/javafxmaven6.png" alt="Proyecto JavaFX, paso 6" style="zoom:50%;" />

Ahora si abrimos de nuevo el fichero HelloController.java aparte del botón hello (que ya aparecia anteriormente) aparecerá el nuevo boton "mola":

<img src="/assets/javafxmaven7.png" alt="Proyecto JavaFX, paso 7" style="zoom:50%;" />

# Actividades

Usa el asistente de IntelliJ para crear proyecto `JavaFX` con maven. Modifica el formulario con `SceneBuilder` y cambia el texto del botón por tu nombre y apellidos. Añade un nuevo botón (con el nombre que quieras), pon el texto que quieras, y con `FXMLManager` añade el código correspondiente al `HelloController.java`.

Genera un zip con el proyecto de IntelliJ (o la carpeta src del IDE que uses). Envía el archivo zip a la tarea de Aules.

# Fuentes de información

- [Wikipedia](https://es.wikipedia.org)
- [Programación (Grado Superior) - Juan Carlos Moreno Pérez (Ed. Ra-ma)](https://www.ra-ma.es/libro/programacion-grado-superior_48302/)
- Apuntes IES Henri Matisse (Javi García Jimenez?)
- Apuntes AulaCampus
- [Apuntes José Luis Comesaña](https://www.sitiolibre.com/)
- [Apuntes IOC Programació bàsica (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_asx_m03_/web/fp_asx_m03_htmlindex/index.html)
- [Apuntes IOC Programació Orientada a Objectes (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m03_/web/fp_dam_m03_htmlindex/index.html)
- [FXDocs](https://github.com/FXDocs/docs)
- https://openjfx.io/openjfx-docs/
- https://arturoblasco.github.io/pr
