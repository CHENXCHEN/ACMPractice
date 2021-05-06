package leetcode.normal.n1486

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/xor-operation-in-an-array/
  * 1486. 数组异或操作
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def xorOperation(n: Int, start: Int): Int = {
    var ans = 0
    (0 until n).foreach {
      i =>
        val num = start + (i << 1)
        ans ^= num
    }
    ans
  }
}
