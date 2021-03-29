package leetcode.normal.n190

/**
  * https://leetcode-cn.com/problems/reverse-bits/
  * 190. 颠倒二进制位
  */
object Solution {
  def reverseBits(x: Int): Int = {
    var ans = 0
    (0 until 32).foreach {
      i =>
        if (((x >> i) & 1) == 1) {
          ans |= 1 << (31 - i)
        }
    }
    ans
  }
}
