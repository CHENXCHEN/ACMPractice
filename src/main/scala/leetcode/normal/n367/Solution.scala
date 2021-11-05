package leetcode.normal.n367

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/valid-perfect-square/
  * 367. 有效的完全平方数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isPerfectSquare(num: Int): Boolean = {
    var left = 1L
    var right = num.toLong
    while (left <= right) {
      val mid = (left + right) >> 1
      val tmp = mid * mid
      if (tmp == num) return true
      else if (tmp > num) right = mid - 1
      else left = mid + 1
    }
    false
  }
}
