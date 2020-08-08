package general.extentional
val <T> List<T>.kek: Int
    get() = 666

fun List<Int>.sum2(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int): MutableList<T> {
    val tmp = this[index1] // 'this' относится к списку
    this[index1] = this[index2]
    this[index2] = tmp
    return this
}

fun main(args: Array<String>) {
    val sum = listOf(1, 2, 3).sum2()
    println(sum)    // 6

    val swap = mutableListOf(1, 2, 3)
    println(swap.swap(0,1))

    println(k)

    C().foo()
    D().foo()

    C().boo() //C
    D().boo() //C
}

open class C{
    fun boo(){
        println("Boo C")
    }
}
class D: C()

fun C.foo(){
    println("I'm C class")
}

fun D.foo(){
    println("I'm D class")
}

fun D.boo(){
    println("Boo D")
}

val k: Int 
    get() {
        return 123
    }