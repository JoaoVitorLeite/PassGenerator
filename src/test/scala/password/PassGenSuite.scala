package password

import org.scalatest.FunSuite

class PassGenSuite extends FunSuite{

  test("T1"){
    val a = new PassGenerator.Gen().generate(20,true, false, false, false)
    assert(a.exists(_.isUpper))
  }
  test("T2"){
    val a = new PassGenerator.Gen().generate(20,false, true, false, false)
    assert(a.exists(_.isLower))
  }
  test("T3"){
    val a = new PassGenerator.Gen().generate(20,false, false, true, false)
    assert(a.exists(_.isDigit))
  }
  test("T4"){
    val a = new PassGenerator.Gen("-").generate(20,false, false, false, true)
    assert(a.contains("-"))
  }
  test("T5"){
    val a = new PassGenerator.Gen().generate(20,true,true,false,false)
    assert(a.exists(_.isLetter))
  }
  test("T6"){
    val a = new PassGenerator.Gen().generate(20,true, false, true, false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T7"){
    val a = new PassGenerator.Gen("$").generate(20,true, false, false, true)
    assert(a.contains("$"))
  }
  test("T8"){
    val a = new PassGenerator.Gen().generate(20,false, true, true, false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T9"){
    val a = new PassGenerator.Gen("*").generate(20,false, true, false ,true)
    assert(a.contains("*"))
  }
  test("T10") {
    val a = new PassGenerator.Gen("!").generate(20, false, false, true, true)
    assert(a.contains("!"))
  }
  test("T11"){
    val a = new PassGenerator.Gen().generate(20,true,true,true,false)
    assert(a.exists(_.isLetterOrDigit))
  }
  test("T12"){
    val a = new PassGenerator.Gen("@").generate(20,true,true,false, true)
    assert(a.contains("@"))
  }
  test("T13"){
    val a = new PassGenerator.Gen(":").generate(20,true,false, true,true)
    assert(a.contains(":"))
  }
  test("T14"){
    val a = new PassGenerator.Gen(":").generate(20,false,true, true,true)
    assert(a.contains(":"))
  }
  test("T15"){
    val a = new PassGenerator.Gen(",").generate(20,true,true, true,true)
    assert(a.contains(","))
  }

}
