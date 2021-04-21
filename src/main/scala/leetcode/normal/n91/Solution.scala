package leetcode.normal.n91

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/decode-ways/
  * 91. 解码方法
  * dp(i) -> IF(dp(i - 1)) + IF(dp(i - 2))
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numDecodings(s: String): Int = {
    if (s.isEmpty || s.head == '0') return 0
    if (s.length == 1) return 1
    val dp = Array.fill[Int](s.length + 1)(0)
    dp(0) = 1
    if (isValid(s, 1, 1)) dp(1) = 1
    if (isValid(s, 0, 2)) dp(1) += 1
    if (dp(1) == 0) return 0
    (2 until s.length).foreach {
      i =>
        dp(i) = 0
        if (isValid(s, i, 1)) dp(i) += dp(i - 1)
        if (isValid(s, i - 1, 2)) dp(i) += dp(i - 2)
        if (dp(i) == 0) return 0
    }
    dp(s.length - 1)
  }

  def isValid(s: String, start: Int, len: Int): Boolean = {
    len match {
      case 1 => s(start) != '0'
      case _ => s(start) != '0' && s.substring(start, start + len).toInt <= 26
    }
  }

  def main(args: Array[String]): Unit = {
    println(numDecodings("1201234"))
    println(numDecodings("301"))
    println(numDecodings("12"))
  }
}
