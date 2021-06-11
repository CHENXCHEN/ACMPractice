package leetcode.normal.n518

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/coin-change-2/
  * 518. 零钱兑换 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.fill(amount + 10)(0)
    dp(0) = 1
    coins.foreach { coin =>
      (coin to amount).foreach { j =>
        dp(j) += dp(j - coin)
      }
    }
    dp(amount)
  }
}
