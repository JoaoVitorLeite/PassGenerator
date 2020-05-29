# Password Generator

### About

Class to generate password in Scala

### Description

Simple random password generator implemented in Scala using `scala.util.Ranom`.

### Project Structure

```bash
src
|
+---.gitignore
|   build.sbt
|   LICENSE
|   README.md
|   
|                               
+---src
|   +---main
|   |   \---scala
|   |       \---password
|   |               PassGenerator.scala
|   |               
|   \---test
|       \---scala
|           \---password
|                   PassGenSuite.scala
|                   

```

### Compile

To compile the files it is necessary to be in the root directory(where 
the `build.sbt` file is), the use the `sbt compile` command.

### Test

To perform the tests it is necessary to be in the root 
directory(where the `build.sbt` file is), then use the `sbt test` 
command. The tests used FunSuite and assert's. There were 15 tests performed.

### IDE

The IDE used was [Intellij Idea](https://www.jetbrains.com/idea/).

### License

The LICENSE used is [Apache-2.0](https://github.com/JoaoVitorLeite/PassGenerator/blob/master/LICENSE).
