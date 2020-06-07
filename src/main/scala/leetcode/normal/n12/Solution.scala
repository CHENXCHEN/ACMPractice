package leetcode.normal.n12

/**
  * 整数转罗马数字(https://leetcode-cn.com/problems/integer-to-roman/)
  *
  * 模拟
  */
object Solution {
  val romanNumMap = Map(
    1 -> Seq("I", "X", "C", "M")
    , 4 -> Seq("IV", "XL", "CD")
    , 5 -> Seq("V", "L", "D")
    , 9 -> Seq("IX", "XC", "CM")
  )
  def intToRoman(num: Int): String = {
    var ans = Seq.empty[String]
    var rNum = num
    var pos = 0
    while (rNum > 0) {
      val t = rNum % 10
      if (romanNumMap.keySet.contains(t)) {
        ans +:= romanNumMap(t)(pos)
      } else if (t < 5) {
        ans +:= romanNumMap(1)(pos) * t
      } else {
        ans +:= romanNumMap(5)(pos) + (romanNumMap(1)(pos) * (t - 5))
      }
      rNum /= 10
      pos += 1
    }
    ans.mkString
  }

  def main(args: Array[String]): Unit = {
    Array(
      (3, "III")
      , (4, "IV")
      , (9, "IX")
      , (58, "LVIII")
      , (1994, "MCMXCIV")
    ).foreach {
      case (x, ans) =>
        val rx = intToRoman(x)
        println("check ", x, rx)
        assert(ans == rx)
    }
  }
}
