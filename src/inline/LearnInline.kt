package inline

class Store(val lambda: () -> Unit){
    init{
        lambda.invoke()
    }
}

inline fun someFun(
    inlineLambda: () -> Unit,
    noinline noinlineLambda: () -> Unit,
    crossinline crossinlineLambda: () -> Unit
) {
    Store {
        println("Print 1.1")
//        inlineLambda cannot be used
//        inlineLambda()
        noinlineLambda() //not inlined
        println("Print 3.1")
        crossinlineLambda() //not inlined
    }
    println("Print 1.2")
    inlineLambda() //inlined
    println("Print 2.2")
    noinlineLambda() // not inlined
    println("Print 3.2")
    crossinlineLambda() //inlined
}

fun main(args: Array<String>) {
    someFun({
        println("Print 1")
//        return //it is non-local return and it is ok for inline lambda
    }, {
        println("Print 2")
        return@someFun //non-local return is not compiled here
    }) {
        println("Print 3")
        return@someFun //non-local return is not compiled here
    }
}