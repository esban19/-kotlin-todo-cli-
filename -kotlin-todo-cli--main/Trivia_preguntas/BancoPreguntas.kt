package trivia_preguntas

class BancoPreguntas {
    private val listaPreguntas = mutableListOf<Pregunta>()

    fun inicializarTrivia() {
        listaPreguntas.add(Pregunta(1, "¿Qué palabra clave define una constante en Kotlin?", listOf("var", "const val", "val", "let"), 3))
        listaPreguntas.add(Pregunta(2, "¿Cómo maneja Kotlin la seguridad contra nulos por defecto?", listOf("Permite nulos siempre", "Los tipos no son anulables por defecto", "Usa punteros", "Lanza NullPointerException"), 2))
        listaPreguntas.add(Pregunta(3, "¿Cuál es la ventaja de una Data Class?", listOf("Hereda de múltiples clases", "Genera automáticamente toString(), equals() y hashCode()", "Hace el código más rápido", "No permite funciones"), 2))
        listaPreguntas.add(Pregunta(4, "¿Qué palabra clave se usa para definir una variable que puede cambiar?", listOf("val", "var", "fun", "class"), 2))
        listaPreguntas.add(Pregunta(5, "¿Qué palabra clave se usa para crear una función en Kotlin?", listOf("function", "def", "fun", "method"), 3))
        listaPreguntas.add(Pregunta(6, "¿Qué estructura se usa para tomar decisiones en Kotlin?", listOf("if", "print", "readLine", "listOf"), 1))
    }

    // Operación funcional requerida: baraja y obtiene las preguntas listas para el juego
    fun obtenerPreguntasDelJuego(): List<Pregunta> {
        return listaPreguntas.shuffled()
    }
}