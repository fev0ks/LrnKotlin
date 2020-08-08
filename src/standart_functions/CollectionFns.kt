package standart_functions

import kotlin.system.measureTimeMillis

fun main() {
    //FOLD
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator")
        accumulator + (number * 3)
    }
    println("Folded value: $foldedValue")
    println(3.isPrime())

    val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)
        .filter { it >= 5 }
        .apply { println(toString()) }
        .windowed(2, 2) { it.first() to it.last() }
        .apply { println(toString()) }
        .map { it.first * it.second }
        .apply { println(toString()) }
        .sum()
    println("ValuesToAdd: $valuesToAdd")


    for(i in 0 until 10){

    }
    //FILTER
    //TIME
    //SEQUENCE
    val sequenceInMils = measureTimeMillis {
        generateSequence(3) { value -> value + 1 }
            .filter { it.isPrime() }.take(100).iterator().forEach { print("$it ") }
    }
    println("\nCalculated by $sequenceInMils ms")

    val numbers = listOf(5, 2, 10, 4)
    println("Number: $numbers")
    //REDUCE
    val reduce1 = numbers.reduce { sum, element -> sum + 2 * element } // 5 4 20 8
    println("reduce*2: $reduce1")
    val reduce2 = numbers.reduce { sum, element -> sum + element }
    println("reduce: $reduce2")

    val fold1 = numbers.fold(0) { sum, element -> sum + element * 2 }
    println("fold*2:: $fold1")
    val fold2 = numbers.fold(0) { sum, element -> sum + element + 2 }
    println("fold+2:: $fold2")

    (1..100).map { x ->
        when {
            x % 3 == 0 && x % 5 == 0 -> "FizzBuzz"
            x % 3 == 0 -> "Fizz"
            x % 5 == 0 -> "Buzz"
            else -> x.toString()
        }
    }.forEach { println(it) }
}

fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0)
            return false
    }
    return true
}
