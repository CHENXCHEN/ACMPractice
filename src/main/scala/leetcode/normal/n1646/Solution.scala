package leetcode.normal.n1646

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getMaximumGenerated(n: Int): Int = {
    if (n == 0) return 0
    val nums = Array.fill(n + 2)(0)
    nums(0) = 0
    nums(1) = 1
    (1 to n).foreach { i =>
      val ll = i << 1
      val rr = ll | 1
      if (ll <= n) nums(ll) = nums(i)
      if (rr <= n) nums(rr) = nums(i) + nums(i + 1)
    }
    nums.max
  }
}