package leetcode.normal.n1189

/**
  * Created by CHENXCHEN
  * 1189. “气球” 的最大数量
  * https://leetcode-cn.com/problems/maximum-number-of-balloons/
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxNumberOfBalloons(text: String): Int = {
    val has = Array.fill(26)(0)
    text.foreach { ch => has(ch - 'a') += 1 }
    "balloon".map { ch => ch -> 1 }.groupBy(_._1).mapValues(_.length)
      .map { case (ch, cnt) =>
        has(ch - 'a') / cnt
      }.min
  }
}