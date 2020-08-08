package standart_functions

fun main() {
    val user = User()
    user.name = "kek"
    user.age = 1

    val applyUser = User().apply {
        name = "kek2"
        age = 2
    }.let {
        println(it.name)
        it.age * it.age
    }.run {
        isEven(this, "1")
    }.takeIf {
        it
    }?.run(
        ::kek
    ).also {
        println(it)
    }

    val firstList = listOf("q", "qwe", "qwert", "eqwewq", "sadasdsa")
    val secondList = firstList.map { it.length }
    println(secondList)

    val numberList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    val filteredList = numberList.flatMap { it.filter { number -> number > 3 } }
    println(filteredList)

}

fun isEven(int: Int, str: String) = int % 2 == 0

fun kek(b: Boolean) = if (b) "true" else "false"

class User() {
    var name = ""
    var age: Int = 0
}
