# _Your project title_

- _Samuel Pilkey_
- _samuel.pilkey@uoit.net_

## About the language

> _Describe the language_

      This language is object oriented. Scala uses java. Java has its own problems with OOP.
      In Scala, all data are objects belonging to some class. All computation occurs in some method invocation.   
      
      Uses 
      Symbols - a name of a variable that refer that to some data
      Binding - an association of a symbol to some specific data
      Scopes - a set of bindings such that each symbol is assicated to a unique data value.
      
      
> - _History_

      The language scala was invented by Martin Odersky. He started off making a 
      language called Funnel at his university (EPFL).The language was not very 
      pleasent to use in practice since it was minimal and new users would struggle. 
      This led him to start developing a language called scala in 2001. Scala first 
      released in 2003.
     
> - _Some interesting features_
      
     Uses Function concepts such as Lambda Calculus, Immutable data, Closure, and Function as values.
      

## About the syntax

> _give some code snippet of the language_


*In Clojure*
```clojure
(let [x 89
      y 90]
  (+ x y))
```

*In Scala*
```scala
//scala doesn't have let syntax but can mimic it
def sumstuff : Int {
      val x = 89
      val y = 90
      x + y
      }      
```
*Bindings*
```scala
var age : Int = 42
//variables can over writen ex, age += 1 is valid this means that they are mutable

val gender : String = "female"
//values cannot be changed 
```

*Expressions*
```scala

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
```
*Data Structures*
```scala
val array = Array(1,2,3,4)
val list  = List(1,2,3,4)
println("First element:" + array(0))
println("First element:" + list(0))
// uses (index)
```
*Class*
```scala

class Car(year: Int, miles: Int) {
    // Initialize the object fields
    public val yearOfCar = year
    public var milesDriven = miles

    // Print a message
    println("Constructing a car", year, miles)

    def drive(distance: Int) {
        milesDriven += Math.abs(distance)
    }
}
// new keyword 
val car = new Car(2016, 5000)
car.drive(120)

//arguments prefixed with var and val ca be both constructor args and feilds of the class
class Car(val year: Int, var miles: Int, maker_ : String){  
 //Secondary Construcctor as def this(..)
    def this(year_:Int, miles: Int) {
       this(year, miles, "GM")
    }
    
    var maker: String = if (maker_ == "GM") 
                            "General Motors" 
                        else
                            maker_

    def drive(distance: Int) {
        milesDriven += Math.abs(distance)
    }
    def requiresEmissionTest : Boolean = milesDriven > 100000
}

```
*Extending a class*
```scala
class Tesla(year: Int) 
  extends Car(year, "Tesla Motor")
```

*Scala Hashmaps*
```scala
//immutable
val grades = Map("Mary" -> 90,
                 "Jack" -> 80,
                 "Joe" -> 76)

val gradeOfMary: Int = grades("Mary")
or
//mutable
val grades = scala.collection.mutable.Map(
               "Mary" -> 90,
               "Jack" -> 80,
               "Joe" -> 76
             )
             
grades += ("Bob" -> 98)
grades.remove("Joe")
grades("Jack") = 85
```
*Loops*
```scala

var i = 0
while(i < 100) {
    i += 1
    println(">" + i)
}

for(i <- 0 to 5)
    println(i)
    

//--looping over maps ------------------
val studentNames = Array("Jack", "Mary", "Joe")
for(name <- studentNames) {
    println(name)
}    

for(name <- studentNames 
         if name.startsWith("J")) {
    println(name)
}
//--------------------------------------
```



## About the tools

> _Describe the compiler or interpreter needed_.

      The compiler is based off of Java. To use the language you can either 
      use an intelij plug in or a download for a command line interface. 
      Other ways to use scala would be to use a REPL and on MAC os is 
      brew update, brew install scala.
      
      This info can be found at https://www.scala-lang.org/download/
      
      Scala is installed per project basis rather than system wide, this
      means that every project has its own version.
      To set up the project structure on command line this must be used 
      
```scala 
- hello-world
    - project (sbt uses this to install manage plugins and dependencies)
        - build.properties
    - src
        - main
            - scala (All of your scala code goes here)
                -Main.scala (Entry point of program) <-- this is all we need for now
    build.sbt (sbt's build definition file)

```

      
## About the standard library

> _Give some examples of the functions and data structures
> offered by the standard library_.







## About open source library

> _Describe at least one contribution by the open source
community written in the language._

      lauris/awsome-scala
      This is an open source repository where there is frame works, software, and libraries for 
      all to use. Example are listed in the repo at 
      https://github.com/lauris/awesome-scala/blob/master/README.md
      One open source library is ScalaFX. It is built on top of java fx 2 and 8.  
# Analysis of the language

> _Organize your report according to the project description
document_.

1. Scala supports both procedural and Functional Programing as there is 
mutable and immutable objects a long with iterative loops and other procedural 
concepts mix in the mainly Functional based language.
      
2.Scala does have the abilty to preform meta programming such as macro's
      ex
```scala
//prototypical macro definition 
def m(x: T): R = macro implRef
```
      
3. Symbol resolution is the concept of not knowing what a symbol means but resolving the unknown
Scala does support closure 
      
 ```scala
 // mutiplier is a function which takes i and returns i * factor
 //factor is not a formal paramater of the fucntion although it has a reference exteranlly
 //if there is no external references then the fucntion is trivially closed over itself
 
 object Demo {
   def main(args: Array[String]) {
      println( "multiplier(1) value = " +  multiplier(1) )
      println( "multiplier(2) value = " +  multiplier(2) )
   }
   var factor = 3
   val multiplier = (i:Int) => i * factor
}     
```

4. Lexical Scoping - scala does support lexical scoping
```scala 
def sqrt(x: Double) = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(square(guess) - x) < 0.001

  sqrtIter(1.0, x)
}   
//vs 

def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess) guess
    else sqrtIter(improve(guess))

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(square(guess) - x) < 0.001

  sqrtIter(1.0, x)
}
```
Do to the lexical scoping of scala the x passed as an argument for sqrt can be accsesed 
by the auxillary functions in the inner scope not requiring them to pass the x between them

Scala does not use Dynamic Scoping rules as Dynamic scoping checks the calling enviroment for
non-locals rather then the defining enviroment for non-locals. This means that programmers would 
have no idea how their code would be run
example
```scala
val delta = 1e-10 // a global constant

def isSmall(x: Double) = {
   math.abs(x) <= delta
}

def testIsSmall = {
   val delta = 100
   isSmall(delta/2) // 50 <= delta?
}
//Lexical/Static Scope delta in testInSmall = 1e-10
//Dynamic = 100 since isSmall is called where delta = 100
``` 
5. 
Scala supports main functional concepts such as Lambda Calculus, Immutable data, Closure, and Function as values.

6. Type System
Scala 


