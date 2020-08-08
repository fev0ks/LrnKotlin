@file:JvmName("AnotherName")
package kt_java;

import java.io.IOException

fun main(){
    val test: String? = "123"
    println(test ?: "Hmmmm")
    var t = Test2()
}

fun someMethod(){
    println("I'm a method")
}

@Throws(IOException::class)
@JvmName("thisIsAMethod")
fun throwException(){
    throw IOException("some exception!!!")
}

