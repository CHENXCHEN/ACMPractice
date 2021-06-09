package leetcode.normal.n494

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/target-sum/
  * 494. 目标和
  * DP
  * (sum - neg) - neg = target
  * sum - target = 2 * neg
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    val neg2 = nums.sum - target
    if (neg2 % 2 != 0 || neg2 < 0) return 0
    val neg = neg2 >> 1
    val dp = Array.fill(neg + 10)(0)
    dp(0) = 1
    // dp[i][j] => 前 i 个数组中，相加等于 j 的方法数
    // dp[j] => 前 i 个数据中，相加等于 j 的方法数
    nums.foreach { num =>
      (neg.to(0, -1)).foreach { j =>
        if (j >= num) dp(j) += dp(j - num)
      }
    }
    dp(neg)
  }
}
