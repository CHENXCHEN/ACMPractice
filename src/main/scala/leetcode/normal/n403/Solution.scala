package leetcode.normal.n403

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/frog-jump/
  * 403. 青蛙过河
  * DP，DP(i)(k) => 第 i 个位置上一步是 k 是否可以走到这里
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def canCross(stones: Array[Int]): Boolean = {
    val dp = Array.fill(stones.length + 2)(Array.fill(stones.length + 2)(false))
    dp(0)(0) = true
    (1 until stones.length).foreach {
      i =>
        (i - 1 to(0, -1)).takeWhile {
          j =>
            val k = stones(i) - stones(j)
            if (k > j + 1) false
            else {
              dp(i)(k) = dp(j)(k - 1) | dp(j)(k) | dp(j)(k + 1)
              if (i == stones.length - 1 && dp(i)(k)) {
                return true
              }
              dp(i)(k)
              true
            }
        }
    }
    dp(stones.length - 1).exists(x => x)
  }

  def main(args: Array[String]): Unit = {
    println(canCross(Array(0, 1, 3, 6, 10, 13, 14)))
  }
}
