package password

import org.scalatest.FunSuite

class PassGenSuite extends FunSuite{

  /***
   * <p>
   *   Note: Because of the random password generation mechanism the tests have no stability in the result, that is, if you select a password with numbers and letters one of the possible results is a password with letters only
   * </p>
   */

  test("T1"){
    val a = new PassGenerator.Gen().generate(20,upperCase = true, lowerCase = false, numbers = false, symbols = false)
    assert(a.exists(_.isUpper))
  }
  test("T2"){
    val a = new PassGenerator.Gen().generate(20,upperCase = false, lowerCase = true, numbers = false, symbols = false)
    assert(a.exists(_.isLower))
  }
  test("T3"){
    val a = new PassGenerator.Gen().generate(20,upperCase = false, lowerCase = false, numbers = true, symbols = false)
    assert(a.exists(_.isDigit))
  }
  test("T4"){
    val a = new PassGenerator.Gen("-").generate(20,upperCase = false, lowerCase = false, numbers = false, symbols = true)
    assert(a.contains("-"))
  }
  test("T5"){
    val a = new PassGenerator.Gen().generate(20,upperCase = true,lowerCase = true,numbers = false,symbols = false)
    assert(a.exists(_.isLetter))
  }
  test("T6"){
    val a = new PassGenerator.Gen().generate(20,upperCase = true, lowerCase = false, numbers = true, symbols = false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T7"){
    val a = new PassGenerator.Gen("$").generate(20,upperCase = true, lowerCase = false, numbers = false, symbols = true)
    assert(a.contains("$"))
  }
  test("T8"){
    val a = new PassGenerator.Gen().generate(20,upperCase = false, lowerCase = true, numbers = true, symbols = false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T9"){
    val a = new PassGenerator.Gen("*").generate(20,upperCase = false, lowerCase = true, numbers = false ,symbols = true)
    assert(a.contains("*"))
  }
  test("T10") {
    val a = new PassGenerator.Gen("!").generate(20, upperCase = false, lowerCase = false, numbers = true, symbols = true)
    assert(a.contains("!"))
  }
  test("T11"){
    val a = new PassGenerator.Gen().generate(20,upperCase = true,lowerCase = true,numbers = true,symbols = false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T12"){
    val a = new PassGenerator.Gen("@").generate(20,upperCase = true,lowerCase = true,numbers = false, symbols = true)
    assert(a.contains("@"))
  }
  test("T13"){
    val a = new PassGenerator.Gen(":").generate(20,upperCase = true,lowerCase = false, numbers = true,symbols = true)
    assert(a.contains(":"))
  }
  test("T14"){
    val a = new PassGenerator.Gen(":").generate(20,upperCase = false,lowerCase = true, numbers = true,symbols = true)
    assert(a.contains(":"))
  }
  test("T15"){
    val a = new PassGenerator.Gen(",").generate(20,upperCase = true,lowerCase = true, numbers = true,symbols = true)
    assert(a.contains(","))
  }

}
