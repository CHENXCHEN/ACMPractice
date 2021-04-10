package leetcode.normal.n263

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/ugly-number/
  * 263. 丑数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isUgly(n: Int): Boolean = {
    if (n == 0) return false
    var ans = n
    while ((ans & 1) == 0) ans >>= 1
    while (ans % 3 == 0) ans /= 3
    while (ans % 5 == 0) ans /= 5
    ans == 1
  }
}
