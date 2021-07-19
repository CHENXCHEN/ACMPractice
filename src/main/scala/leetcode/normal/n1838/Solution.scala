package leetcode.normal.n1838

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
  * 1838. 最高频元素的频数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxFrequency(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    val preSum = Array.fill(nums.length + 1)(0L)
    sorted.indices.foreach { i => preSum(i + 1) = preSum(i) + sorted(i) }
    if (sorted.last.toLong * sorted.length - preSum.last <= k) {
      sorted.length
    } else {
      def findLeftLessThan(right: Int): Int = {
        var l = 0
        var r = right
        var ret = -1
        while (l <= r) {
          val m = (l + r) >> 1
          val vSum = (right - m + 1).toLong * sorted(right)
          if (vSum - (preSum(right + 1) - preSum(m)) <= k) {
            ret = m
            r = m - 1
          } else {
            l = m + 1
          }
        }
        ret
      }

      var ans = 1
      (1 until sorted.length).foreach { i =>
        val left = findLeftLessThan(i)
        if (left != -1) {
          ans = ans.max(i - left + 1)
        }
      }
      ans
    }
  }
}
