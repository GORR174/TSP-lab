package net.catstack.tsp.tsp

/***
 * Класс для представления пути между городами
 */
class CitiesPath(citiesList: ArrayList<City>) : ArrayList<City>() {
    init {
        citiesList.forEach(::add)
    }

    /***
     * Длина пути
     */
    val length: Int
        get() = this.foldIndexed(0) { index, sum, city -> sum + city.neighborCitiesLengths[this[(index + 1) % this.size]]!! }

    /***
     * Переопределение метода toString() для вывода пути
     * @return возвращает строку вида: Город1-Город2-Город3-Город1
     */
    override fun toString() = this.joinToString("-") + "-${this[0]}"
}