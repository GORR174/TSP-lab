package net.catstack.tsp.tsp

import net.catstack.tsp.permutations.generatePermutations

/***
 * Класс для представляения карты городов
 * @param cities - города, входящие в карту
 */
class CitiesMap(vararg cities: City) : ArrayList<City>() {
    init {
        cities.forEach(::add)
    }

    /***
     * Метод, возвращающий кротчайший маршрут, удовлетворяющий условию задачи коммивояжёра
     * @return кротчайший маршрут
     */
    fun getShortestPath(): CitiesPath {
        val permutations = this.generatePermutations().map { CitiesPath(it) }

        var smallestLength = Int.MAX_VALUE
        var resultPath = permutations[0]

        permutations.forEach {
            val length = it.length

            println("$it = $length")

            if (length < smallestLength) {
                smallestLength = length
                resultPath = it
            }
        }

        return resultPath
    }
}