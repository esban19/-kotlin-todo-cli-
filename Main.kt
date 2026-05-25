fun main() {
    val gestor = GestorTareas()
    var continuar = true

    println("=====================================")
    println(" bienvenido al Gestor de Tareas CLI ")
    println("=====================================")

    while (continuar) {
        mostrarMenu()
        print("\nSelecciona una opción (1-6): ")

        // Uso de Null Safety al leer de consola para evitar excepciones catastróficas
        val entrada = readLine()
      //  val opcion = entrada?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Escribe la descripción de la tarea: ")
                val desc = readLine()
                // Verificamos de forma segura que la cadena no esté vacía o nula
                if (!desc.isNullOrBlank()) {
                    gestor.agregarTarea(desc.trim())
                } else {
                    println("Error: La descripción de la tarea no puede estar vacía.")
                }
            }
            2 -> gestor.listarTareas()
            3 -> {
                print("Introduce el ID de la tarea a completar: ")
                val idInput = readLine()?.toIntOrNull()
                // let ejecuta el bloque solo si el ID es un número válido
                idInput?.let { id ->
                    if (gestor.marcarComoCompletada(id)) {
                        println("Tarea marcada como completada.")
                    } else {
                        println("No se encontró ninguna tarea con el ID: $id")
                    }
                } ?: println("Error: Por favor, introduce un ID numérico válido.")
            }
            4 -> {
                print("Introduce el ID de la tarea a eliminar: ")
                val idInput = readLine()?.toIntOrNull()
                idInput?.let { id ->
                    if (gestor.eliminarTarea(id)) {
                        println("Tarea eliminada exitosamente.")
                    } else {
                        println("No se encontró ninguna tarea con el ID: $id")
                    }
                } ?: println("Error: Por favor, introduce un ID numérico válido.")
            }
            5 -> gestor.mostrarEstadisticas()
            6 -> {
                println("¡Gracias por utilizar el Gestor de Tareas! Saliendo del programa...")
                continuar = false
            }
            else -> println("Opción inválida. Intenta de nuevo con un número del 1 al 6.")
        }
    }
}

fun mostrarMenu() {
    println("\n--- MENÚ DE OPCIONES ---")
    println("1. Agregar tarea")
    println("2. Listar tareas")
    println("3. Marcar tarea como completada")
    println("4. Eliminar tarea")
    println("5. Mostrar estadísticas")
    println("6. Salir")
}