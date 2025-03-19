//Zad_1
val r: (String, Int) -> String = {
    s, i -> s.repeat(i)
}

//Zad_2
val <T> List<T>.tail: List<T>
    get() = if (this.isNotEmpty()) this.drop(1) else emptyList()

val <T> List<T>.head: T
    get() = this.first()

//Zad_3
fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    if (lst.size < 2) return true

    for (i in 0 until lst.size - 1) {
        if (!order(lst[i], lst[i + 1])) {
            return false
        }
    }
    return true
}

//Zad_4
fun <A> tailToHead(lst: List<A>): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list") // Obsługa pustej listy

    val lastElement = lst.last() // Pobieramy ostatni element
    val remainingList = lst.dropLast(1) // Pobieramy listę bez ostatniego elementu

    return listOf(lastElement) + remainingList // Tworzymy nową listę z ostatnim elementem na początku
}

//Zad_5
fun <A> setHead(lst: List<A>, item: A): List<A> {
    if (lst.isEmpty()) return listOf(item) // Jeśli lista jest pusta, zwracamy listę z jednym elementem
    return listOf(item) + lst.drop(1) // Zamieniamy pierwszy element i dołączamy resztę listy
}

//Zad_6/7
fun check(N: Int, list: List<Int>): Int {
    if (N >= list.size) throw IllegalArgumentException("Preambuła N musi być mniejsza niż długość listy.")

    for (i in N until list.size) {
        val target = list[i]
        val preamble = list.subList(i - N, i) // Pobranie aktualnej preambuły

        if (!hasTwoSum(preamble, target)) {
            return target // Znaleziono pierwszą liczbę, która nie spełnia warunku
        }
    }
    return -1 // Wszystkie liczby spełniają warunek
}

fun hasTwoSum(preamble: List<Int>, target: Int): Boolean {
    val seen = mutableSetOf<Int>()

    for (num in preamble) {
        val complement = target - num
        if (complement in seen) {
            return true // Znaleziono dwie różne liczby sumujące się do target
        }
        seen.add(num)
    }
    return false
}

//main
fun main() {
    
    //Zad_1
    println(r("Hello", 3))
    
    
    //Zad_2
    val numbers2 = listOf(1, 2, 3, 4, 5)
    println("Head: ${numbers2.head}")
    println("Tail: ${numbers2.tail}")

    val emptyList2 = listOf<Int>()
    println("Tail pustej listy: ${emptyList2.tail}")
    
    
    //Zad_3
    val ascendingOrder: (Int, Int) -> Boolean = { a, b -> a <= b }
    val descendingOrder: (Int, Int) -> Boolean = { a, b -> a >= b }

    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = listOf(5, 4, 3, 2, 1)
    val list3 = listOf(1, 3, 2, 4, 5)

    println(isSorted(list1, ascendingOrder))
    println(isSorted(list2, descendingOrder))
    println(isSorted(list3, ascendingOrder))
    
    
    //Zad_4
    val list4 = listOf(1, 2, 3, 4, 5)
    val newList4 = tailToHead(list4)

    println(newList4)

    val singleElementList = listOf(42)
    println(tailToHead(singleElementList))

    val emptyList4 = listOf<Int>()
    
    
    //Zad_5
    val list5 = listOf(1, 2, 3, 4, 5)
    val newList5 = setHead(list5, 99)

    println(newList5)

    val emptyList5 = listOf<Int>()
    val newEmptyList5 = setHead(emptyList5, 42)
    
    println(newEmptyList5)
    
    
    //Zad_6/7
    val numbers6 = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
    val N7 = 5

    println(check(N7, numbers6))
}
