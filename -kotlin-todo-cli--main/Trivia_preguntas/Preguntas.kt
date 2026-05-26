package trivia_preguntas

// Data class requerida por la rúbrica para modelar una pregunta de la trivia
data class Pregunta(
    val id: Int,
    val enunciado: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int // Índice de la opción correcta (1 a 4)
)