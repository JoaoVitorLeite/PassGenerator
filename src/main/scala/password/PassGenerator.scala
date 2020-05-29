package password

import scala.util.Random

/***
 * @author João Vitor Leite
 */


/***
 * Object to generate random password
 */
object PassGenerator {

  /***
   * Implicit class to generate random password
   *
   * <p>
   *   Note: If you want symbols in the password pass the symbols as a String to the Gen method
   * </p>
   *
   * @param addsymbols Symbol String
   */
  implicit class Gen(addsymbols: String = ""){

    /***
     * Method to define which elements the password will have
     * @param size Password size
     * @param upperCase Boolean parameter to define if there will be UpperCase in the password
     * @param lowerCase Boolean parameter to define if there will be LowerCase in the password
     * @param numbers Boolean parameter to define if there will be Numbers in the password
     * @param symbols Boolean parameter to define if there will be Symbols in the password
     * @return Random password in String format
     */
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
