// =====================================================================
// Ejercicios 3 y 5: Detección y conteo de entidades
// =====================================================================

/**
 * Responsable de detectar entidades nombradas en texto libre y
 * producir estadísticas sobre ellas.
 */
object Analyzer {

  /**
   * Detecta las entidades del diccionario que aparecen en el texto dado.
   *
   * @param text       texto a analizar (ej: título o cuerpo de un post)
   * @param dictionary lista de entidades conocidas (cargadas desde los diccionarios)
   * @return lista de entidades cuyo texto aparece en el texto analizado
   *
   * TODO (Ejercicio 3): Implementar este método.
   *
   *   Para cada entidad en el diccionario, verificar si su texto aparece en el
   *   texto del post. Retornar únicamente las entidades que aparecen.
   *
   *   Ejemplo:
   *     text       = "Scala fue creado en EPFL por Martin Odersky"
   *     dictionary = List(
   *                    ProgrammingLanguage("Scala"),
   *                    University("EPFL"),
   *                    Person("Martin Odersky"),
   *                    Person("Ada Lovelace")   ← no aparece en el texto
   *                  )
   *     resultado  = List(
   *                    ProgrammingLanguage("Scala"),
   *                    University("EPFL"),
   *                    Person("Martin Odersky")
   *                  )
   */
  def detectEntities (text: String, dictionary: List [NamedEntity]): List[NamedEntity] = {
    dictionary.filter { entity =>

      //Convierte el texto del objeto a una version segura, para poder aplicar bien el regex
      //tal que sin quote: "C++" haría problema
      //con quote: "C++" sería texto normal
      val escapedText = java.util.regex.Pattern.quote(entity.text)

      // Detéctame solamente el texto del objeto SI Y SOLO SI no posee letras ni números antes de este
      // (?<!\w antes y después del escapedText)
      // (?i) ignora mayúsculas y minúsculas
      // Con esto nos evitamos que se detecte "java" si el texto dice "javalalala"
      val regex = s"(?i)(?<!\\w)$escapedText(?!\\w)".r

      // Busca la primera coincidencia de la regex en el texto y si este existe o no,
      // entonces devolverá la entidad o None
      regex.findFirstIn(text).isDefined
    }
  }

  /**
   * Cuenta cuántas entidades de cada tipo fueron detectadas.
   *
   * @param entities lista de entidades detectadas
   * @return mapa de entityType → cantidad de apariciones
   *
   * TODO (Ejercicio 5): Implementar este método.
   *
   *   Ejemplo:
   *     entities = List(
   *                  Person("Alan Turing"),
   *                  ProgrammingLanguage("Scala"),
   *                  Person("Ada Lovelace"),
   *                  University("MIT")
   *                )
   *     resultado = Map(
   *                   "Person"              -> 2,
   *                   "ProgrammingLanguage" -> 1,
   *                   "University"          -> 1
   *                 )
   */
  def countByType(entities: List[NamedEntity]): Map[String, Int] = {
    ???
  }
}
