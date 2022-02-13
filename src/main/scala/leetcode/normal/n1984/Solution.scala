package leetcode.normal.n1984

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
  * 1984. 学生分数的最小差值
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minimumDifference(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var ans = sorted(k - 1) - sorted.head
    0.to(nums.length - k).foreach { i =>
      val res = sorted(i + k - 1) - sorted(i)
      ans = ans.min(res)
    }
    ans
  }
}