package leetcode.normal.n375

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
  * 375. 猜数字大小 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getMoneyAmount(n: Int): Int = {
    val dp = Array.fill(n + 1)(Array.fill(n + 1)(0))
    (n - 1).to(1, -1).foreach { i =>
      (i + 1).to(n).foreach { j =>
        dp(i)(j) = j + dp(i)(j - 1)
        i.until(j).foreach { k =>
          dp(i)(j) = dp(i)(j).min(k + dp(i)(k - 1).max(dp(k + 1)(j)))
        }
      }
    }
    dp(1)(n)
  }
}
