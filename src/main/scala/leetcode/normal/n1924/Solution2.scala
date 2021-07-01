package leetcode.normal.n1924

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/chuan-di-xin-xi/
  * LCP 07. 传递信息
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    val dp = Array.fill(k + 2)(Array.fill(n + 2)(0))
    dp(0)(0) = 1
    (1 to k).foreach { step =>
      relation.foreach { edge =>
        val from = edge.head
        val to = edge.last
        dp(step)(to) += dp(step - 1)(from)
      }
    }
    dp(k)(n - 1)
  }
}
