package net.catstack.tsp

import net.catstack.tsp.tsp.CitiesMap
import net.catstack.tsp.tsp.City

fun main() {
    val citiesMap = CitiesMap(City("A"), City("B"), City("C"), City("D"))
    val (cityA, cityB, cityC, cityD) = citiesMap

    cityA.run {
        neighborCitiesLengths[cityB] = 20
        neighborCitiesLengths[cityC] = 42
        neighborCitiesLengths[cityD] = 35
    }

    cityB.run {
        neighborCitiesLengths[cityA] = 20
        neighborCitiesLengths[cityC] = 30
        neighborCitiesLengths[cityD] = 34
    }

    cityC.run {
        neighborCitiesLengths[cityA] = 42
        neighborCitiesLengths[cityB] = 30
        neighborCitiesLengths[cityD] = 12
    }

    cityD.run {
        neighborCitiesLengths[cityA] = 35
        neighborCitiesLengths[cityB] = 34
        neighborCitiesLengths[cityC] = 12
    }

    val shortestPath = citiesMap.getShortestPath()

    println("----------------")
    println("Кротчайший путь: $shortestPath имеет длину ${shortestPath.length}")
}