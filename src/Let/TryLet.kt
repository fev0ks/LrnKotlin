package Let

fun main() {
    var k: String?
    k = "lllll"
    k = k?.let {
        it.capitalize()
    } ?: "def"
    println(k)
}