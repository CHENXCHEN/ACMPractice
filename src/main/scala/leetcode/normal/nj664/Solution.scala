package leetcode.normal.nj664

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/strange-printer/
  * 664. 奇怪的打印机
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def strangePrinter(s: String): Int = {
    val dp = Array.fill(s.length)(Array.fill(s.length)(0))
    val n = s.length
    (n - 1).to(0, -1).foreach { i =>
      dp(i)(i) = 1
      (i + 1 until n).foreach { j =>
        if (s(i) == s(j)) {
          dp(i)(j) = dp(i)(j - 1)
        } else {
          dp(i)(j) =
            (i until j).map { k =>
              dp(i)(k) + dp(k + 1)(j)
            }.min
        }
      }
    }
    dp(0)(n - 1)
  }
}
