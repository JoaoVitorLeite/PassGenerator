package password

object Main {

  def main(args: Array[String]): Unit = {
    println(new PassGenerator.Gen().generate(8,upperCase = true,lowerCase = true,numbers = true,symbols = false))
  }

}
