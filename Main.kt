import trivia_preguntas.Trivia

fun main() {
    var continuar = true

    while (continuar) {
        println("===================================")
        println("           MENU PRINCIPAL")
        println("===================================")
        println("1. Gestor de tareas")
        println("2. Trivia de preguntas")
        println("3. Salir")
        print("Selecciona una opcion: ")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> ejecutarGestorTareas()
            2 -> {
                val trivia = Trivia()
                trivia.iniciar()
            }
            3 -> {
                println("Saliendo del programa...")
                continuar = false
            }
            else -> println("Opcion invalida. Intenta de nuevo.")
        }

        println()
    }
}

fun ejecutarGestorTareas() {
    val gestor = GestorTareas()
    var continuar = true

    println("===================================")
    println(" Bienvenido al Gestor de Tareas CLI ")
    println("===================================")

    while (continuar) {
        mostrarMenu()
        print("\nSelecciona una opcion (1-6): ")

        val entrada = readLine()
        val opcion = entrada?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Escribe la descripcion de la tarea: ")
                val desc = readLine()

                if (!desc.isNullOrBlank()) {
                    gestor.agregarTarea(desc.trim())
                } else {
                    println("Error: La descripcion de la tarea no puede estar vacia.")
                }
            }

            2 -> gestor.listarTareas()

            3 -> {
                print("Introduce el ID de la tarea a completar: ")
                val idInput = readLine()?.toIntOrNull()

                idInput?.let { id ->
                    if (gestor.marcarComoCompletada(id)) {
                        println("Tarea marcada como completada.")
                    } else {
                        println("No se encontro ninguna tarea con el ID: $id")
                    }
                } ?: println("Error: Por favor, introduce un ID numerico valido.")
            }

            4 -> {
                print("Introduce el ID de la tarea a eliminar: ")
                val idInput = readLine()?.toIntOrNull()

                idInput?.let { id ->
                    if (gestor.eliminarTarea(id)) {
                        println("Tarea eliminada exitosamente.")
                    } else {
                        println("No se encontro ninguna tarea con el ID: $id")
                    }
                } ?: println("Error: Por favor, introduce un ID numerico valido.")
            }

            5 -> gestor.mostrarEstadisticas()

            6 -> {
                println("Gracias por utilizar el gestor de Tareas. Saliendo del programa...")
                continuar = false
            }

            else -> println("Opcion invalida. Intenta de nuevo con un numero del 1 al 6.")
        }
    }
}

fun mostrarMenu() {
    println("\n--- MENU DE OPCIONES ---")
    println("1. Agregar tarea")
    println("2. Listar tareas")
    println("3. Marcar tarea como completada")
    println("4. Eliminar tarea")
    println("5. Mostrar estadisticas")
    println("6. Salir")
}