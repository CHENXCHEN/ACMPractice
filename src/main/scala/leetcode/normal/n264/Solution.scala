package leetcode.normal.n264

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/ugly-number-ii/
  * 264. 丑数 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  lazy val preAns: Array[Int] = {
    val dp = Array.fill[Int](1700)(0)
    dp(1) = 1
    var (p2, p3, p5) = (1, 1, 1)
    (2 until 1700).foreach {
      i =>
        val n2 = dp(p2) * 2
        val n3 = dp(p3) * 3
        val n5 = dp(p5) * 5
        dp(i) = n2 min n3 min n5
        if (dp(i) == n2) p2 += 1
        if (dp(i) == n3) p3 += 1
        if (dp(i) == n5) p5 += 1
    }
    dp
  }

  def nthUglyNumber(n: Int): Int = {
    preAns(n)
  }
}
