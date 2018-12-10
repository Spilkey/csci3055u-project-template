import scala.io.Source
object Main extends App {
    val lines = Source.fromFile("text.txt").getLines.toList
    for(words <- lines) {
        for(word <- words.split(" ")
            if word.startsWith("t")){
            println(word)
        }
    }
}