//Rozwiązania listy 1 dla PUM od Jarosław Szekuła

//play.kotlinlang.org nie pozwala na wprowadzenie wartości do terminala,
//odpowiednie linijki kodu zostały zakomentowane

import kotlin.math.pow

fun main() {
    val poem = """
        Kotlin, the philosopher in code's grand tale,
        With extension functions, it sets the sail.
        From chapters to verses, a narrative so true,
        In the world of programming, it's the cue!
    """.trimIndent()
    println(poem)
    //----------Zadanie_1----------
    zad1(100)
    
    //----------Zadanie_2----------
    val word1 = "absdba"
    val word2 = "abba"
    if (isPalindrome(word1)) {
        println("Słowo \"$word1\" jest palindromem.")
    } else {
        println("Słowo \"$word1\" nie jest palindromem.")
    }
    if (isPalindrome(word2)) {
        println("Słowo \"$word2\" jest palindromem.")
    } else {
        println("Słowo \"$word2\" nie jest palindromem.")
    }
    
    //----------Zadanie_3----------
    print("Podaj liczbę wierszy trójkąta Pascala: ")
    //val rows = readLine()?.toIntOrNull() ?: return
    val rows = 5
    for (row in generatePascalsTriangle(rows)) {
        println(row.joinToString(" "))
    }
    
    //----------Zadanie_4----------
    print("Podaj liczbę: ")
    //val number4 = readLine()?.toIntOrNull()
    val number4 = 28
    if (number4 == null || number4 <= 0) {
        println("Podano niepoprawną liczbę.")
        return
    }
    println(classifyNumber(number4))
    
    //----------Zadanie_5----------
    print("Podaj liczbę: ")
    //val number5 = readLine()?.toIntOrNull()
    val number5 = 153
    if (number5 == null || number5 < 0) {
        println("Podano niepoprawną liczbę.")
        return
    }

    if (isArmstrongNumber(number5)) {
        println("Liczba $number5 jest liczbą Armstronga.")
    } else {
        println("Liczba $number5 nie jest liczbą Armstronga.")
    }
}


//----------Funkcje----------

fun zad1(argument: Int): Int{
    
    for(x in 1..argument){
        
        if((x % 3) == 0){ //
            if((x % 5) == 0){
                if ((x % 7) == 0){
                    if ((x % 11) == 0){
                        if ((x % 13) == 0){
                            println("TrzyPięćSiedemJedynaścieTrzynaście")
                        }
                        else{
                            println("TrzyPięćSiedemJedynaście")
                        }
                    }
                    else{
                        println("TrzyPięćSiedem")
                    }
                }
                else{
                    println("TrzyPięć")
                }
            }
            else{
                println("Trzy")
            }
        }
        else if((x % 5) == 0){
                if ((x % 7) == 0){
                    if ((x % 11) == 0){
                        if ((x % 13) == 0){
                            println("PięćSiedemJedynaścieTrzynaście")
                        }
                        else{
                            println("PięćSiedemJedynaście")
                        }
                    }
                    else{
                        println("PięćSiedem")
                    }
                }
                else{
                    println("Pięć")
                }
        }
        else if ((x % 7) == 0){
                    if ((x % 11) == 0){
                        if ((x % 13) == 0){
                            println("SiedemJedynaścieTrzynaście")
                        }
                        else{
                            println("SiedemJedynaście")
                        }
                    }
                    else{
                        println("Siedem")
                    }
                }
        else if ((x % 11) == 0){
                        if ((x % 13) == 0){
                            println("JedynaścieTrzynaście")
                        }
                        else{
                            println("Jedynaście")
                        }
                    }
        else if ((x % 13) == 0){
            println("Trzynaście")
        }
        else{
            println(x)
        }
        
    }
    
    return 1;
}



fun isPalindrome(podslowo: String): Boolean {
    val slowo = podslowo.lowercase().replace("\\s".toRegex(), "")
    return slowo == slowo.reversed()
}


fun generatePascalsTriangle(rows: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()

    for (i in 0 until rows) {
        val row = mutableListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                row.add(triangle[i - 1][j - 1] + triangle[i - 1][j])
            }
        }
        triangle.add(row)
    }
    return triangle
}

fun sumOfDivisors(n: Int): Int {
    var sum = 0
    for (i in 1 until n) {
        if (n % i == 0) {
            sum += i
        }
    }
    return sum
}

fun classifyNumber(n: Int): String {
    val aliquotSum = sumOfDivisors(n)

    return when {
        aliquotSum == n -> "Liczba $n jest doskonała."
        aliquotSum > n -> "Liczba $n jest obfita."
        else -> "Liczba $n jest niedomiarowa."
    }
}

fun isArmstrongNumber(n: Int): Boolean {
    val digits = n.toString().map { it.digitToInt() }
    val power = digits.size

    var sum = 0
    for (digit in digits) {
        val double = digit.toDouble()
        val raised = double.pow(power) // Podniesienie cyfry do potęgi
        val rounded = raised.toInt() // Konwersja wyniku na liczbę całkowitą
        sum += rounded // Dodanie do sumy
    }

    return sum == n
}
