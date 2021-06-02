package net.catstack.tsp.permutations

/***
 * Псевдоним для типа списка перестоновок
 */
typealias Permutations<T> = ArrayList<ArrayList<T>>

/***
 * Метод расширение для класса List, который создаёт перестановки заданного множества
 * @param T - Тип элементов множества
 * @return список перестановок
 */
fun <T> List<T>.generatePermutations(): Permutations<T> {
    val result = Permutations<T>()

    generatePermutations(this, result, ArrayList())

    return result
}

/***
 * Рекурсивный алгоритм, создающий перестановки множества
 * @param list - исходное множество
 * @param result - список для сохранения возможных перестановок
 * @param currentPermutation - собираемая перестановка
 */
private fun <T> generatePermutations(list: List<T>, result: Permutations<T>, currentPermutation: ArrayList<T>) {
    if (list.isEmpty()) return

    if (currentPermutation.size == list.size) {
        result.add(currentPermutation)
        return
    }

    list.forEach {
        val newPermutation = ArrayList(currentPermutation)

        if (it in newPermutation) return@forEach

        newPermutation.add(it)

        generatePermutations(list, result, newPermutation)
    }
}
