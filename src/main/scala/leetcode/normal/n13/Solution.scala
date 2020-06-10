package leetcode.normal.n13

/**
  * 罗马数字转整数(https://leetcode-cn.com/problems/roman-to-integer/)
  *
  * 模拟
  */
object Solution {
  val romanNumMap = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000,
  )

  def romanToInt(s: String): Int = {
    var ans = 0
    var i = s.length - 1
    while (i >= 0) {
      if (i - 1 >= 0 && romanNumMap(s(i - 1)) < romanNumMap(s(i))) {
        ans += romanNumMap(s(i)) - romanNumMap(s(i - 1))
        i -= 1
      } else {
        ans += romanNumMap(s(i))
      }
      i -= 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    Array(
      ("III", 3)
      , ("IV", 4)
      , ("IX", 9)
      , ("LVIII", 58)
      , ("MCMXCIV", 1994)
    ).foreach {
      case (x, ans) =>
        val rx = romanToInt(x)
        println("check ", x, rx)
        assert(ans == rx)
    }
  }
}
