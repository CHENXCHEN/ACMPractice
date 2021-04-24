package leetcode.normal.n368

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/largest-divisible-subset/
  * 368. 最大整除子集
  * 给定一个无重复的正整数数组 nums，找出最大整除子集 ans，这个集合内每一对元素都有 ans(i)|ans(j) or ans(j)|ans(i)
  * DP 解法，max
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def largestDivisibleSubset(_nums: Array[Int]): List[Int] = {
    val nums = _nums.sorted
    val dp = Array.fill(nums.length + 1)(0)
    val pre = Array.fill(nums.length + 1)(-1)
    var maxPos = 0
    nums.indices.foreach { i =>
      dp(i) = 1
      (0 until i).foreach { j =>
        if (nums(i) % nums(j) == 0 && dp(j) + 1 > dp(i)) {
          dp(i) = dp(j) + 1
          pre(i) = j
          if (dp(i) > dp(maxPos)) maxPos = i
        }
      }
    }
    var ans = Vector.empty[Int]
    while (maxPos != -1) {
      ans +:= nums(maxPos)
      maxPos = pre(maxPos)
    }
    ans.toList
  }

  def main(args: Array[String]): Unit = {
    println(largestDivisibleSubset(Array(1, 2, 3)))
  }
}
