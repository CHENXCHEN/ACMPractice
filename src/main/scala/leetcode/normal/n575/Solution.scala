package leetcode.normal.n575

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/distribute-candies/
  * 575. 分糖果
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def distributeCandies(candyType: Array[Int]): Int = {
    val candyMap = candyType.map(x => x -> 1).groupBy(_._1).mapValues(_.length)
    math.min(candyMap.size, candyType.length >> 1)
  }
}
