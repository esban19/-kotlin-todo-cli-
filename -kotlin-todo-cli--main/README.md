# Gestor de Tareas por Consola (To-Do CLI)

## 1. Descripción 
Es una aplicación intuitiva y ligera de línea de comandos desarrollada en Kotlin diseñada para gestionar actividades diarias mediante operaciones CRUD fluidas y seguras.

## 2. Instrucciones de Instalación y Ejecución
Para clonar, compilar y ejecutar esta aplicación desde cero en tu equipo local, asegúrate de tener instalado el SDK de Kotlin (v1.9 o superior). Ejecuta los siguientes comandos en tu terminal:

```bash
# Clonar el repositorio
git clone [https://github.com/TU_USUARIO/kotlin-todo-cli.git](https://github.com/TU_USUARIO/kotlin-todo-cli.git)

# Acceder al directorio del proyecto
cd kotlin-todo-cli

# Compilar el archivo del proyecto
kotlinc Main.kt Tarea.kt GestorTareas.kt -include-runtime -d GestorTareas.jar (este siendo mi caso)

# Ejecutar la aplicación compilada
java -jar GestorTareas.jar
```

## 3. Funcionalidades Principales
* **Agregar Tareas:** Registro secuencial de tareas asignándoles un ID incremental único de forma automática.
* **Listar Tareas:** Impresión estructurada en consola del listado de tareas junto a sus respectivos estados actuales (Pendiente/Completada).
* **Completar Tareas:** Modificación dinámica del estado de una tarea buscando directamente por su identificador numérico.
* **Eliminar Tareas:** Remoción física de registros obsoletos de la lista de pendientes de forma controlada.
* **Estadísticas de Uso:** Conteo automatizado de tareas resueltas y pendientes usando predicados lógicos.

## 4. Conceptos de Kotlin Aplicados
| Requisito Técnico | Implementación en Código (El archivo y función)                                                                   |
| :--- |:------------------------------------------------------------------------------------------------------------------|
| **Funciones, condicionales y ciclos** | Usamos del bucle `while` y condicional `when` en `Main.kt`; para tener limpio fuera del cuerpo del main.          |
| **Colecciones con operaciones funcionales** | Uso de `MutableList` filtrada con `.forEach`, `.find` y `.removeIf` dentro de `GestorTareas.kt`.                  |
| **Null Safety** | Uso constante de operadores seguros `?.`, `?:` junto a la función de alcance `.let` en las lecturas de `Main.kt`. |
| **Data Class** | Definimos limpiamente de la entidad del dominio dentro de `Tarea.kt`.                                             |

## 5. Reflexión de Proceso
* **a) ¿Qué fue lo más difícil de este proyecto y cómo lo resolviste?**
    Pues mas que nada poder manipular de forma segura los tipos de datos nulables que devuelve readLine cuando el usuario ingresa caracteres inesperados o inputs vacíos, resolviéndolo mediante el casteo seguro toIntOrNull respaldado con el operador Elvis.

* **b) ¿Hubo algún concepto de Kotlin que al principio no entendías y que ahora sí comprendes? ¿Cómo llegaste a entenderlo?**
    Fueron las operaciones funcionales con predicados tipo Lambda, las cuales logré como que asimilar al tener como contraste del ciclo for tradicional que requiere 5 líneas puede reducirse a un único método declarativo como removeIf.

* **c) Si tuvieras que mejorar o ampliar este proyecto, ¿qué le agregarías y por qué?**
    El implementar persistencia de datos persistente mediante el almacenamiento de un JSON local o una base de datos embebida como SQLite, asegurando que las tareas no se borren de la memoria cada vez que se detiene la consola porque luego me ha pasado con las MV.

* **d) ¿Qué aprendiste de este proyecto que no aprendiste solo leyendo o viendo videos?**
    La importancia de la robustez del código cuando ejecutas el codigo. Ver vídeos hace me hace creer que me saldran las a la primera, pero cuando trabajo directamente con la consola casi simpre habra errores y corregir los luego llega a ser complicado aun mas como en mi caso que no habia estado familiarizado en este entorno.
## Módulo de trivia

El proyecto incluye un módulo de trivia sobre conceptos básicos de Kotlin.

Este módulo contiene:

- Una clase `Pregunta` para representar cada pregunta.
- Un banco de preguntas iniciales.
- Una función para obtener las preguntas en orden aleatorio.
```
