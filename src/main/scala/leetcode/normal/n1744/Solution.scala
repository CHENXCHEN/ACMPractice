package leetcode.normal.n1744

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
  * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def canEat(candiesCount: Array[Int], queries: Array[Array[Int]]): Array[Boolean] = {
    val preSum = Array.fill(candiesCount.length + 1)(0L)
    candiesCount.indices.foreach { i =>
      preSum(i + 1) = preSum(i) + candiesCount(i)
    }
    queries.map { arr =>
      val fType: Int = arr.head
      val fDay: Long = arr(1).toLong
      val fCap: Long = arr.last.toLong
      val range1 = (fDay + 1, fCap * (fDay + 1))
      val range2 = (preSum(fType) + 1, preSum(fType + 1))
      !(range1._2 < range2._1 || range1._1 > range2._2)
    }
  }
}
