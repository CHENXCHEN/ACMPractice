package leetcode.normal.n342

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/power-of-four/
  * 342. 4的幂
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isPowerOfFour(n: Int): Boolean = {
    if (n <= 0) return false
    var bn = n
    while (bn != 1 && (bn & 3) == 0) {
      bn >>= 2
    }
    bn == 1
  }
}
