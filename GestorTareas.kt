class GestorTareas {
    // Uso de colecciones para almacenar la información de las tareas
    private val listaTareas = mutableListOf<Tarea>()
    private var siguienteId = 1

    fun agregarTarea(descripcion: String) {
        val nuevaTarea = Tarea(id = siguienteId++, descripcion = descripcion)
        listaTareas.add(nuevaTarea)
        println("¡Tarea agregada con éxito! (ID: ${nuevaTarea.id})")
    }

    fun listarTareas() {
        if (listaTareas.isEmpty()) {
            println("No hay tareas registradas en la lista.")
            return
        }
        println("\n--- LISTA DE TAREAS ---")
        // Uso de operaciones funcionales en lugar de ciclos manuales (forEach)
        listaTareas.forEach { tarea ->
            val estado = if (tarea.completada) "[✓] Completada" else "[ ] Pendiente"
            println("${tarea.id}. ${tarea.descripcion} -> $estado")
        }
    }

    fun marcarComoCompletada(id: Int): Boolean {
        // Operación funcional: buscamos si existe algún elemento que coincida
        val tarea = listaTareas.find { it.id == id }
        return if (tarea != null) {
            tarea.completada = true
            true
        } else {
            false
        }
    }

    fun eliminarTarea(id: Int): Boolean {
        // Removemos directamente validando con un predicado funcional
        return listaTareas.removeIf { it.id == id }
    }

    fun mostrarEstadisticas() {
        // Uso de operaciones funcionales complejas (filter y conteo)
        val completadas = listaTareas.filter { it.completada }.size
        val pendientes = listaTareas.filter { !it.completada }.size

        println("\n--- ESTADÍSTICAS ---")
        println("Tareas Pendientes: $pendientes")
        println("Tareas Completadas: $completadas")
    }
}