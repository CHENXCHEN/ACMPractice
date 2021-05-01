package leetcode.normal.n137

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/single-number-ii/
  * 137. 只出现一次的数字 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    val map = mutable.Map[Int, Int]()
    nums.foreach {
      num => map.put(num, map.getOrElse(num, 0) + 1)
    }
    map.find(x => x._2 == 1).head._1
  }
}
