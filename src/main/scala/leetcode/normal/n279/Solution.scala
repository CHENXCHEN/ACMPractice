package leetcode.normal.n279

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/perfect-squares/
  * 279. 完全平方数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numSquares(n: Int): Int = {
    val maxSqrt = findMaxSqrt(n)
    val dp = Array.fill(n + 10)(0)
    (1 to n).foreach { i => dp(i) = i }
    (2 to maxSqrt).foreach { i =>
      val s = i * i
      (s to n).foreach { j =>
        dp(j) = dp(j).min(dp(j - s) + 1)
      }
    }
    dp(n)
  }

  def findMaxSqrt(n: Int): Int = {
    var left = 1
    var right = n
    while (left < right) {
      val mid = (left + right + 1) >> 1
      val s = mid * mid
      if (s <= n) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    left
  }
}
