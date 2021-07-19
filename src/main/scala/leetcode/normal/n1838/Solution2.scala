package leetcode.normal.n1838

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
  * 1838. 最高频元素的频数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def maxFrequency(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var l = 0
    var tot = 0
    var ans = 1
    (1 until sorted.length).foreach { r =>
      tot += (sorted(r) - sorted(r - 1)) * (r - l)
      while (tot > k) {
        tot -= sorted(r) - sorted(l)
        l += 1
      }
      ans = ans max (r - l + 1)
    }
    ans
  }
}
