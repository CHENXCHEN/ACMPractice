package leetcode.normal.n1833

/**
  * Created by CHENXCHEN
  * 1833. 雪糕的最大数量
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    val sorted = costs.sorted
    var sum = 0
    var ans = 0
    sorted.foreach { cost =>
      if (sum + cost <= coins) {
        sum += cost
        ans += 1
      }
    }
    ans
  }
}