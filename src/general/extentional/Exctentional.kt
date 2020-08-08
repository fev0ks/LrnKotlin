package general.extentional


fun main() {
42.print()

}

fun <T> T.print(){
    println(this)
}

val String.numVowels
    get() = count {
        "aeiouy".contains(it)
    }