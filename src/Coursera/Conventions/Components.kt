package Coursera.Conventions

data class MyClass(val name: String, val age: Int){

}

fun main() {
    var myClass = MyClass("Mipa", 25)
    println(myClass.component1() + " - $myClass.component2()")
}