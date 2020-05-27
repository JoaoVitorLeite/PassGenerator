package password

import scala.util.Random

object PassGenerator {

  implicit class Gen(addsymbols: String = ""){

    def generate(size: Int, upperCase: Boolean, lowerCase: Boolean, numbers: Boolean, symbols: Boolean): String ={
      val upper = (65 to 90).toList.map(_.toChar.toString)
      val lower = (97 to 122).toList.map(_.toChar.toString)
      val nums = (0 to 9).toList.map(_.toString)
      val symb = addsymbols.toList.map(_.toString)
      val ans: List[String] = (upperCase, lowerCase, numbers, symbols) match {
        case (b1, b2, b3, b4) if b1 && !b2 && !b3 && !b4 => upper
        case (b1, b2, b3, b4) if !b1 && b2 && !b3 && !b4 => lower
        case (b1, b2, b3, b4) if !b1 && !b2 && b3 && !b4 => nums
        case (b1, b2, b3, b4) if !b1 && !b2 && !b3 && b4 => symb
        case (b1, b2, b3, b4) if b1 && b2 && !b3 && !b4 => upper ++ lower
        case (b1, b2, b3, b4) if b1 && !b2 && b3 && !b4 => upper ++ nums
        case (b1, b2, b3, b4) if b1 && !b2 && !b3 && b4 => upper ++ symb
        case (b1, b2, b3, b4) if !b1 && b2 && b3 && !b4 => lower ++ nums
        case (b1, b2, b3, b4) if !b1 && b2 && !b3 && b4 => lower ++ symb
        case (b1, b2, b3, b4) if !b1 && !b2 && b3 && b4 => nums ++ symb
        case (b1, b2, b3, b4) if b1 && b2 && b3 && !b4 => upper ++ lower ++ nums
        case (b1, b2, b3, b4) if b1 && b2 && !b3 && b4 => upper ++ lower ++ symb
        case (b1, b2, b3, b4) if b1 && !b2 && b3 && b4 => upper ++ nums ++ symb
        case (b1, b2, b3, b4) if !b1 && b2 && b3 && b4 => lower ++ nums ++ symb
        case (b1, b2, b3, b4) if b1 && b2 && b3 && b4 => upper ++ lower ++ nums ++ symb
      }
      Random.shuffle(ans).take(size).mkString("")
    }

  }

}
