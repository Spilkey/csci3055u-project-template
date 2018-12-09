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

     
> - _Some interesting features_
      
     Uses Function concepts such as Lambda Calculus, Immutable data, Closure, Function as values.
      

## About the syntax

> _give some code snippet of the language_

*Bindings*
```scala
var age : Int = 42

val gender : String = "female"
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

      The compiler is based off of Java. To use the language you can either use an intelij plug in or a download for a command line           interface. Other ways to use scala would be to use a REPL and on MAC os is brew update, brew install scala
      Scala is installed per project basis rather than system wide, this means that every project has its own version.
      
## About the standard library

> _Give some examples of the functions and data structures
> offered by the standard library_.

## About open source library

> _Describe at least one contribution by the open source
community written in the language._

# Analysis of the language

> _Organize your report according to the project description
document_.


