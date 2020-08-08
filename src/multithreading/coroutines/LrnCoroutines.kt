package multithreading.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {

//    example2()
//    example3()

    example5()
    example6()
}

fun example1() {
    val jobe = GlobalScope.launch {
        delay(1000L)
        println("World")
    }

//    runBlocking {
//        jobe.join() //wait result of job
//    }
    say("hello")
//    Thread.sleep(2000L)

    runBlocking {
        say("hi")
        delay(2000L)
    }
    say("main")
}

fun example2() {
    runBlocking { // start main coroutine
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main coroutine continues here immediately
        delay(2000L)      // delaying for 2 seconds to keep JVM alive
    }
}

fun example3() {
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}

fun example4() {
    runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope 1") // This line will be printed before the nested launch
        }
    }

    CoroutineScope(Dispatchers.IO).launch {
        println("Task from coroutine scope 2")
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}

fun example5() {
    println("coroutines")
    runBlocking {
        repeat(100_000) { // launch a lot of coroutines
            launch {
                delay(1000L)
                print(".")
            }
        }
    }
    println()
}

fun example6(){
    println("threads")
    repeat(100_000){
        thread {
            Thread.sleep(1000L)
            print(".")
        }
    }
    println()
}

fun say(message: String) {
    println(message)
}

class LrnCoroutines {
}