package net.catstack.tsp.tsp

/***
 * Класс для представления города
 * @property name - имя города
 * @property neighborCitiesLengths - словарь расстояний до соседних городов
 */
class City(val name: String, val neighborCitiesLengths: HashMap<City, Int> = HashMap()) {
    override fun toString() = name
}