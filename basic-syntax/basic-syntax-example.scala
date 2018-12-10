val x = 100
val y = println("x=" + x)
// or 
val x = 100
val y = 200
val z = {
    println(x)
    println(y)
    x + y // evaluates to last expression in the block
}
