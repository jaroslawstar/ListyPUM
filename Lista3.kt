//----------Zadanie_1----------
fun findDuplicates(numbers: List<Int>): List<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    for (num in numbers) {
        if (!seen.add(num)) { // Jeśli element już istnieje w zbiorze, dodajemy go do duplikatów
            duplicates.add(num)
        }
    }

    return duplicates.sorted() // Zwracamy posortowaną listę duplikatów
}

//----------Zadanie_2----------
fun addToBoolean(): Map<Int, Boolean> {
    return (1..20).associateWith { it % 2 == 0 }
}

//----------Zadanie_3----------
fun suma(a: List<Int>): Int = a.filter { it > 0 }.sum()

//----------Zadanie_4----------
fun countElements(lists: List<List<String>>): Map<String, Int> {
    return lists.flatten() // Spłaszczamy listę list do jednej listy
        .groupingBy { it } // Grupujemy elementy po ich wartości
        .eachCount() // Liczymy wystąpienia
}

//----------Zadanie_5----------
fun evenPositiveSquare(numbers: List<Int>): List<Int> {
    return numbers.mapIndexed { index, value -> 
        if (index % 2 != 0 && value > 0) value * value else null
    }.filterNotNull() // Usuwamy wartości null
}

//----------Zadanie_6----------
fun perm(numbers: List<Int>): List<List<Int>> {
    if (numbers.isEmpty()) return listOf(emptyList())

    return numbers.flatMap { num ->
        perm(numbers - num).map { listOf(num) + it }
    }
}

//----------Zadanie_7----------
fun srt(words: List<String>): List<Pair<String, List<String>>> {
    return words.filter { it.length % 2 == 0 } // Filtrujemy tylko parzyste długości
        .groupBy { it.first().toString() } // Grupujemy po pierwszej literze
        .toSortedMap() // Sortujemy klucze (pierwsze litery)
        .map { it.key to it.value } // Konwertujemy na listę par
}

//----------Zadanie_8----------
fun wordToPhoneNumber(word: String): String {
    val keypad = mapOf(
        'A' to "2", 'B' to "22", 'C' to "222",
        'D' to "3", 'E' to "33", 'F' to "333",
        'G' to "4", 'H' to "44", 'I' to "444",
        'J' to "5", 'K' to "55", 'L' to "555",
        'M' to "6", 'N' to "66", 'O' to "666",
        'P' to "7", 'Q' to "77", 'R' to "777", 'S' to "7777",
        'T' to "8", 'U' to "88", 'V' to "888",
        'W' to "9", 'X' to "99", 'Y' to "999", 'Z' to "9999"
    )

    return word.uppercase().map { keypad[it] ?: it }.joinToString("")
}

//----------Zadanie_9----------
data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(students: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>> {
    val passingScore = 50

    // Podział studentów na zdanych i niezdanych
    val (passed, failed) = students.partition { it.score >= passingScore }

    // Grupowanie zdanych studentów według przedmiotów
    val passedBySubject = passed.groupBy { it.subject }

    // Znalezienie przedmiotów, gdzie wszyscy zdali
    val subjectsAllPassed = students.groupBy { it.subject }
        .filterValues { studentsInSubject -> studentsInSubject.all { it.score >= passingScore } }
        .keys.toList()

    return Triple(passedBySubject, failed, subjectsAllPassed)
}

//----------Zadanie_10----------
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
    operator fun plus(value: Int) = Point(x + value, y + value)
    operator fun minus(other: Point) = Point(x - other.x, y - other.y)
    operator fun times(other: Point) = Point(x * other.x, y * other.y)
    operator fun inc() = Point(x + 1, y + 1)
    operator fun dec() = Point(x - 1, y - 1)
    operator fun not() = Point(-x, -y)
}

//----------main----------
fun main() {
    
    //----------Zadanie_1----------
    val numbers1 = listOf(4, 2, 7, 4, 9, 2, 5, 7, 7)
    println(findDuplicates(numbers1))
    
    //----------Zadanie_2----------
    println(addToBoolean())
    
    //----------Zadanie_3----------
    val numbers3 = listOf(-5, 10, -3, 8, 0, 7, -2)
    println(suma(numbers3))
    
    //----------Zadanie_4----------
    val data = listOf(
        listOf("jabłko", "banan", "truskawka"),
        listOf("truskawka", "banan"),
        listOf("truskawka", "jabko", "banan")
    )

    println(countElements(data))
    
    //----------Zadanie_5----------
    val numbers5 = listOf(-3, 4, -2, 5, 6, -1, 7, 8)
    println(evenPositiveSquare(numbers5))
    
    //----------Zadanie_6----------
    val numbers6 = listOf(1, 2, 3)
    println(perm(numbers6))
    
    //----------Zadanie_7----------
    val words = listOf("apple", "banana", "apricot", "blueberry", "cherry", "avocado", "grape", "melon")
    println(srt(words))
    
    //----------Zadanie_8----------
    println(wordToPhoneNumber("franek"))
    println(wordToPhoneNumber("wojtek"))
    
    //----------Zadanie_9----------
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")
    
    //----------Zadanie_10----------
    var p1 = Point(1, 1)
    val p2 = Point(2, 2)
    
    println(p1 + p2)  // Output: (3, 3)
    p1 += 1
    println(p1)  // Output: (2, 2)
    println(p1 - p2)  // Output: (-1, -1)
    println(p1 * p2)  // Output: (2, 2)
    p1++
    println(p1)  // Output: (3, 3)
    p1--
    println(p1)  // Output: (2, 2)
    println(!p1)  // Output: (-2, -2)
}
