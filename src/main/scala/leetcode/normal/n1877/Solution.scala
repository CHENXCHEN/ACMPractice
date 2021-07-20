package leetcode.normal.n1877

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
  * 1877. 数组中最大数对和的最小值
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minPairSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var l = 1
    var r = sorted.length - 2
    var ans = sorted.head + sorted.last
    while (l < r) {
      ans = ans max (sorted(l) + sorted(r))
      l += 1
      r -= 1
    }
    ans
  }
}
