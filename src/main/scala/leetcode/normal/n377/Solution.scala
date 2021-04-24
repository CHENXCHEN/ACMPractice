package leetcode.normal.n377

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/combination-sum-iv/
  * 377. 组合总和 Ⅳ
  * 给定一个不同的正整数数组 nums, 求有多少种方式相加组合得到 target, 元素可重复取
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def combinationSum4(_nums: Array[Int], target: Int): Int = {
    val nums = _nums.sorted
    val dp = Array.fill(target + 1)(0)
    dp(0) = 1
    (1 to target).foreach {
      i =>
        var j = 0
        while(j < nums.length && nums(j) <= i) {
          dp(i) += dp(i - nums(j))
          j += 1
        }
    }
    dp(target)
  }
}
