package leetcode.normal.n421

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
  * BIT + 枚举答案
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findMaximumXOR(nums: Array[Int]): Int = {
    var ans = 0
    (30.to(0, -1)).foreach {
      bitPos =>
        ans = (ans << 1) | 1
        val set = nums.map(_ >> bitPos).toSet
        if (!nums.exists(x => set.contains((x >> bitPos) ^ ans))) {
          ans ^= 1
        }
    }
    ans
  }
}
