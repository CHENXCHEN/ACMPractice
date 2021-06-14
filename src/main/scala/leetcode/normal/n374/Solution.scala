package leetcode.normal.n374

class GuessGame {
  def guess(num: Int): Int = {
    if (num == 6) 0
    else if (num > 6) -1
    else 1
  }
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
  * 374. 猜数字大小
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
class Solution extends GuessGame {
  def guessNumber(n: Int): Int = {
    var left = 1L
    var right = n.toLong
    while (left < right) {
      val mid = (left + right + 1) >> 1
      val ret = guess(mid.toInt)
      // 如果 mid <= pick
      if (ret >= 0) left = mid
      else right = mid - 1
    }
    left.toInt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val solution = new Solution
    println(solution.guessNumber(100))
  }
}