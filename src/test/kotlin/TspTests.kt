import net.catstack.tsp.permutations.generatePermutations
import net.catstack.tsp.tsp.CitiesMap
import net.catstack.tsp.tsp.City
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TspTests {
    @Test
    fun testPermutation_Empty() {
        val list = arrayListOf<Int>()
        val permutations = list.generatePermutations()

        assertEquals(0, permutations.size)
    }

    @Test
    fun testPermutation_OneElement() {
        val list = arrayListOf(1)
        val permutations = list.generatePermutations()

        assertEquals(1, permutations.size)
        assertTrue(arrayListOf(1) in permutations)
    }

    @Test
    fun testPermutation_TwoElements() {
        val list = arrayListOf(1, 2)
        val permutations = list.generatePermutations()

        assertEquals(2, permutations.size)
        assertTrue(arrayListOf(1, 2) in permutations)
        assertTrue(arrayListOf(2, 1) in permutations)
    }

    @Test
    fun testPermutation_ThreeElements() {
        val list = arrayListOf(1, 2, 3)
        val permutations = list.generatePermutations()

        assertEquals(6, permutations.size)
        assertTrue(arrayListOf(1, 2, 3) in permutations)
        assertTrue(arrayListOf(1, 3, 2) in permutations)
        assertTrue(arrayListOf(2, 1, 3) in permutations)
        assertTrue(arrayListOf(2, 3, 1) in permutations)
        assertTrue(arrayListOf(3, 1, 2) in permutations)
        assertTrue(arrayListOf(3, 2, 1) in permutations)
    }

    @Test
    fun testPermutation_NonIntElements() {
        val list = arrayListOf("123", "test", "тест")
        val permutations = list.generatePermutations()

        assertEquals(6, permutations.size)
        assertTrue(arrayListOf("123", "test", "тест") in permutations)
        assertTrue(arrayListOf("123", "тест", "test") in permutations)
        assertTrue(arrayListOf("test", "123", "тест") in permutations)
        assertTrue(arrayListOf("test", "тест", "123") in permutations)
        assertTrue(arrayListOf("тест", "123", "test") in permutations)
        assertTrue(arrayListOf("тест", "test", "123") in permutations)
    }

    @Test
    fun testTspLength() {
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

        assertEquals(97, shortestPath.length)
    }
}