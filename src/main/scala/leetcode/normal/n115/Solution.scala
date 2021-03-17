package leetcode.normal.n115

/**
  * https://leetcode-cn.com/problems/distinct-subsequences/
  * 115. 不同的子序列
  */
object Solution {
  def numDistinct(s: String, t: String): Int = {
    val dp = Array.fill[Array[Int]](s.length + 1)(Array.fill[Int](t.length + 1)(0))
    val (m, n) = (s.length, t.length)
    (0 to m).foreach {
      i => dp(i)(n) = 1
    }
    (m - 1 to(0, -1)).foreach {
      i =>
        val charS = s(i)
        (n - 1 to(0, -1)).foreach {
          j =>
            val charJ = t(j)
            if (charS == charJ) dp(i)(j) = dp(i + 1)(j + 1) + dp(i + 1)(j)
            else dp(i)(j) = dp(i + 1)(j)
        }
    }
    dp(0)(0)
  }

  def main(args: Array[String]): Unit = {
    println(numDistinct("rabbbit", "rabbit"))
  }
}
