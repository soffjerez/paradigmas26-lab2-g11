// =====================================================================
// Ejercicios 4 y 5: Formateo de resultados
// =====================================================================

/**
 * Responsable de convertir los resultados del análisis a texto para mostrar.
 */
object Formatters {

  /**
   * Formatea el análisis NER de un post individual.
   *
   * @param postTitle título del post analizado
   * @param entities  entidades detectadas en ese post
   * @return bloque de texto con el título y las entidades encontradas
   *
   * TODO (Ejercicio 4): Implementar este método.
   *
   *   Usar el método describe de cada entidad para generar la salida.
   *   No es necesario hacer match sobre el tipo concreto de cada entidad:
   *   describe ya funciona correctamente para cualquier subtipo (polimorfismo).
   *
   *   Ejemplo de salida esperada:
   *
   *     Post: "Scala 3 released at EPFL by Martin Odersky"
   *     Entidades detectadas:
   *       [ProgrammingLanguage] Scala
   *       [University] EPFL
   *       [Person] Martin Odersky
   *
   *   Si no se detectaron entidades, mostrar un mensaje indicándolo.
   */
  def formatNERResult(postTitle: String, entities: List[NamedEntity]): String = {
    // detecto las entidades de cada post individual tomando como referencia las entidades generales
    val ent = Analyzer.detectEntities(postTitle, entities)
    // mapeo para guardar el formato correcto de la entidad
    val res = ent.map(e => "\t" + e.describe + "\n")

    // devolver un print? cual hay
    println(
      s"Post: \"$postTitle\"\n"+
        "Entidades detectadas:\n"+
        {if (ent.nonEmpty){res.mkString} else {"\t (no se detectaron entidades) \n"}}).toString
  }

  /**
   * Formatea un resumen de estadísticas de entidades por tipo.
   *
   * @param counts mapa de entityType → cantidad
   * @return texto con las estadísticas ordenadas por cantidad (de mayor a menor)
   *
   * TODO (Ejercicio 5): Implementar este método.
   *
   *   Ejemplo de salida esperada:
   *
   *     === Estadísticas de entidades ===
   *     Person: 5
   *     ProgrammingLanguage: 3
   *     Organization: 2
   *     University: 2
   */
  def formatEntityStats(counts: Map[String, Int]): String = {
    ???
  }
}
