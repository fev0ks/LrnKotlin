package general

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    for(i in 0 until s.length){
        val c = s[i]
        if (i==0 && !(c in 'a'..'z' || c == '_')){
            return false
        }
        if(i != 0 && !c.isLetterOrDigit()){
            return false
        }

    }
    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}