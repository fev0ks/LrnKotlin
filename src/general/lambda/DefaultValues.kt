package general.lambda

fun main() {
    val defValues = DefaultValues()
    defValues.kek("this is kek")
    defValues.pek(a = 2, b = 3) { println("This is pek $it") }
//    defValues.pek(a = 2, 3) { print("This is pek $it") } exception
    defValues.pek(b = 4) { println("This is pek $it") }
    defValues.pek { println("This is pek $it") }
    defValues.foo(strings = *arrayOf("1", "2", "3")) { println("This is foo $it") }
    defValues.foo("4", "5", "6") { println("This is foo $it") }
}

class DefaultValues {

    fun pek(a: Int = 1, b: Int = 2, c: (String) -> Unit)
    {
        c("a = $a; b = $b")
    }

    fun kek(f: String) {
        println("f = $f")
    }

    fun foo(vararg strings: String, f: (String) -> Unit) {
        strings.iterator().forEach { f(it) }
    }

//    Compilation Error
//    fun fooboo(vararg strings: String, vararg strings2: String, f: (String) -> Unit) {
//    fun fooboo(vararg strings: String, a: Int, vararg ints: Int, f: (String) -> Unit) {


}