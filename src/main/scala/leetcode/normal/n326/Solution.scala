package leetcode.normal.n326

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/power-of-three/
  * 326. 3的幂
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isPowerOfThree(n: Int): Boolean = {
    var nx = n
    while (nx != 0 && nx % 3 == 0) {
      nx /= 3
    }
    nx > 0 && (nx == 1 || nx % 3 == 0)
  }
}