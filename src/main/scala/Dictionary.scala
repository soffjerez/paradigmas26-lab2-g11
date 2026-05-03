// =====================================================================
// Ejercicio 2: Cargar diccionarios de entidades
// =====================================================================

/**
 * Responsable de cargar colecciones de entidades nombradas desde archivos.
 *
 * Un diccionario es un archivo de texto plano donde cada línea contiene
 * el nombre de una entidad conocida del mismo tipo.
 *
 * Ejemplo — data/people.txt:
 *   Martin Odersky
 *   Alan Turing
 *   Ada Lovelace
 *
 * Ejemplo — data/languages.txt:
 *   Scala
 *   Python
 *   Haskell
 */
object Dictionary {

  private def assignClass(entity: String, entityType: String): NamedEntity = {
    entityType match {
      case "Person" => new Person(entity)
      case "Organization" => new Organization(entity)
      case "University" => new University(entity)
      case "Place" => new Place(entity)
      case "Technology" => new Technology(entity)
      case "ProgrammingLanguage" => new ProgrammingLanguage(entity)
    }
  }    

  /**
   * Lee un archivo de diccionario y crea una lista de entidades del tipo indicado.
   *
   * @param filePath   ruta al archivo de diccionario (ej: "data/people.txt")
   * @param entityType tipo de entidad: "Person", "University", "ProgrammingLanguage", etc.
   * @return lista de NamedEntity del tipo correspondiente
   *
   * TODO (Ejercicio 2): Implementar este método.
   *
   *   Pasos sugeridos:
   *     1. Leer las líneas del archivo
   *     2. Para cada línea, crear la instancia de la clase correcta
   *     3. Retornar la lista de entidades creadas
   *
   *   Para crear la clase correcta según el tipo se puede usar match:
   *
   */
  def loadFromFile(filePath: String, entityType: String): List[NamedEntity] = {
    val lines = FileIO.readLines(filePath)                                            // obtengo las lineas del archivo 
    val data: List[NamedEntity] = lines.map( line => assignClass(line, entityType))   // para cada linea le creo una instancia de la clase que corresponde
    data 
  }

  /**
   * Carga todos los diccionarios disponibles y combina sus entidades.
   *
   * @return lista con todas las entidades de todos los diccionarios
   *
   * TODO (Ejercicio 2): Implementar este método.
   *
   */
  def loadAll(): List[NamedEntity] = {
    val people = loadFromFile("data/people.txt", "Person")                         // obtengo la lista de entidades para cada archivo 
    val organizations = loadFromFile("data/organizations.txt", "Organization")
    val universities = loadFromFile("data/universities.txt", "University")
    val places = loadFromFile("data/places.txt", "Place")
    val languages = loadFromFile("data/languages.txt", "ProgrammingLanguage")

    val res = people ++ organizations ++ universities ++ places ++ languages
    res 
  }
}
