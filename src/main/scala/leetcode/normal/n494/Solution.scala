package leetcode.normal.n494

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/target-sum/
  * 494. 目标和
  * 回溯枚举
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    var ans = 0

    def findTarget(index: Int, sum: Int): Unit = {
      if (index == nums.length) {
        if (sum == target) ans += 1
      } else {
        findTarget(index + 1, sum + nums(index))
        findTarget(index + 1, sum - nums(index))
      }
    }

    findTarget(0, 0)
    ans
  }
}
