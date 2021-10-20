import kotlin.random.Random

fun main() {
    print("Enter n-value: ")
    val n = readLine()?.toInt()
    var arrays = ArrayList<ArrayList<Int>>()
    var size = Random.nextInt(0, 100)
    var sizes = mutableListOf(size)
    /*
    Следующий цикл работает так: В пустой ArrayList arrays я добавляю такие же пустые ArrayList.
    Во внутреннем цикле, который идет от 0 до какого-то произвольного размера я добавляю рандомные числа от 0 до 10, для простоты.
    Позже, чтобы размеры не повторялись, в цикле while я проверяю, есть ли такой размер в списке, где я и буду хранить размеры.
    Если такого нет, то я спокойно добавляю его и делаю итерацию во внешнем цикле. В обратном случае я ищу значение для size, которого еще нет в списке.
     */
    for (i in 0 until n!! step 1) {
        arrays.add(ArrayList())
        for (j in 0 until size step 1) {
            arrays.last().add(Random.nextInt(0, 10))
        }
        while (sizes.contains(size)) {
            size = Random.nextInt(0, 100)
        }
        sizes.add(size)
        arrays.last().sort()
        if (i % 2 == 1) {
            arrays.last().reverse()
        }
    }
    for (array in arrays) {
        for (element in array) {
            print("$element ")
        }
        println()
    }
}
