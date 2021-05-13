package leetcode.normal.n1269

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
  * 1269. 停在原地的方案数
  * 组合数 dp(i)(j) = dp(i-1)(j) + dp(i-1)(j-1) + dp(i-1)(j+1)
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numWays(steps: Int, arrLen: Int): Int = {
    val maxCols = steps min (arrLen - 1)
    val dp = Array.fill(steps + 1)(Array.fill(maxCols + 1)(0))
    val mod = 1000000007
    dp(0)(0) = 1
    (1 to steps).foreach {
      i =>
        (0 to maxCols).foreach {
          j =>
            dp(i)(j) = dp(i - 1)(j)
            if (j != 0) dp(i)(j) = (dp(i)(j) + dp(i - 1)(j - 1)) % mod
            if (j != maxCols) dp(i)(j) = (dp(i)(j) + dp(i - 1)(j + 1)) % mod
        }
    }
    dp(steps).head
  }
}
