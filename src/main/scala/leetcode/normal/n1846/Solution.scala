package leetcode.normal.n1846

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
  * 1846. 减小和重新排列数组后的最大元素
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maximumElementAfterDecrementingAndRearranging(arr: Array[Int]): Int = {
    val sorted = arr.sorted
    var ans = 1
    (1 until arr.length).foreach { i =>
      if (sorted(i) >= ans + 1) ans += 1
    }
    ans
  }
}
