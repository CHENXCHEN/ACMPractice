package leetcode.normal.n231

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/power-of-two/
  * 231. 2 的幂
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isPowerOfTwo(n: Int): Boolean = {
    n != 0 && n != Int.MinValue && (n & (n - 1)) == 0
  }
}
