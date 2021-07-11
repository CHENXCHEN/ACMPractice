package leetcode.normal.n930

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
  * 930. 和相同的二元子数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    val tMap = mutable.TreeMap.empty[Int, Int]
    var sum = 0
    var ans = 0
    nums.foreach { num =>
      tMap.put(sum, tMap.getOrElse(sum, 0) + 1)
      sum += num
      ans += tMap.getOrElse(sum - goal, 0)
    }
    ans
  }
}
