---
title: Taller UD10_3: Librerias Maven vs Jar
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

# Gestión de librerías con `Maven` vs Manualmente (Jar)

## ¿Qué es Maven?

Maven es una herramienta de gestión y comprensión de proyectos, principalmente utilizada en proyectos Java. Su principal función es gestionar las dependencias (librerías y otros componentes que tu proyecto necesita), construir el proyecto y gestionar la configuración del ciclo de vida del desarrollo. Maven utiliza un archivo de configuración denominado `pom.xml` (Project Object Model), donde se especifican las dependencias y otros detalles del proyecto.

## Beneficios de Usar Maven

1. **Gestión Automática de Dependencias:** Maven descarga automáticamente las dependencias del proyecto desde repositorios remotos y las incluye en el proyecto, evitando la necesidad de descargar y agregar manualmente los archivos JAR.
2. **Estandarización del Proyecto: **Proporciona una estructura estándar para los proyectos, lo que facilita la organización y el mantenimiento.
3. **Reproducibilidad:** El uso de `pom.xml` permite que cualquier desarrollador que clone el repositorio tenga exactamente las mismas versiones de las dependencias, asegurando que el proyecto se construya de manera consistente en diferentes entornos.
4. **Integración con IDEs:** Herramientas como IntelliJ IDEA tienen soporte nativo para Maven, lo que facilita la configuración y gestión del proyecto dentro del IDE.
5. **Gestión del Ciclo de Vida del Proyecto:** Maven puede automatizar tareas como compilación, pruebas, empaquetado y despliegue, facilitando la integración continua.

## Diferencias con agregar las librerías directamente al proyecto

**1. Gestión de Dependencias:** en **Maven** las dependencias se especifican en el archivo `pom.xml`. Maven descarga las dependencias automáticamente desde los repositorios configurados. Mientras que en **Manual** las dependencias se descargan manualmente y se agregan al proyecto, lo que puede llevar a inconsistencias y errores si diferentes desarrolladores utilizan versiones distintas de las librerías.

**2. Actualización de Dependencias:** en **Maven** actualizar una dependencia es tan simple como cambiar la versión en el `pom.xml`. Maven se encarga de descargar la nueva versión. Por contra, en **Manual** requiere descargar la nueva versión manualmente y reemplazar los archivos JAR antiguos en el proyecto.

**3. Estructura del Proyecto:** en **Maven** proporciona una estructura de proyecto estandarizada, lo que facilita la comprensión y la navegación del proyecto. Mientras que en **Manual** la estructura del proyecto puede variar según el desarrollador, lo que puede llevar a confusión y desorganización.

**4. Repositorios de Dependencias:** en **Maven** utiliza repositorios remotos (como Maven Central) para buscar y descargar dependencias. También permite configurar repositorios internos. Pero en **Manual** las dependencias deben ser gestionadas y almacenadas manualmente, lo que puede ser engorroso y propenso a errores.

**5. Integración con Herramientas de Construcción:** **Maven** se integra fácilmente con herramientas de construcción y CI/CD, permitiendo la automatización de tareas como compilación, pruebas y despliegue. Por otro lado en **Manual** se requieren scripts personalizados y configuración adicional para integrar tareas de construcción y despliegue.

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

1. fichero pom.xml que gestiona las dependencias del proyecto maven.
2. HelloApplication clase que contiene el main de la aplicación JavaFx
3. HelloController clase con el controlador de la aplicación
4. hello-view.fxml archivo que contiene el formulario (vista) de la apliación

El proyecto sigue el patrón MVC que hemos visto en teoria, solo que es tan simple que no tiene ningún Modelo.

# Modificar el formulario con SceneBuilder

Si has configurado correctamente SceneBuilder en tu ordenador para usarlo desde IntelliJ, deberias poder pulsar con el botón derecho del ratón sobre el archivo 4 (hello-view.fxml) y elegir la opción Abrir en SceneBuilder:

<img src="/assets/javafxmavenSceneBuilder.png" alt="Proyecto JavaFX, Scene Builder" style="zoom:50%;" />


# Actividades

Usa el asistente de IntelliJ para crear proyecto JavaFX con maven. Modifica el formulario con SceneBuilder y cambia el texto del botón por tu nombre y apellidos:

![Proyecto JavaFX, paso 5](/assets/javafxmaven5.png)

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
