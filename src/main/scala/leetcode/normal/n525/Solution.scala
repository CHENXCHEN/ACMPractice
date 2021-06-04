package leetcode.normal.n525

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/contiguous-array/
  * 525. 连续数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findMaxLength(nums: Array[Int]): Int = {
    var pre0 = 0
    var pre1 = 0
    val mm = mutable.Map[Int, Int]()
    mm.put(0, -1)
    var maxLen = 0
    nums.indices.foreach { i =>
      if (nums(i) == 1) pre1 += 1
      else pre0 += 1
      val sign = pre0 - pre1
      if (!mm.contains(sign)) {
        mm.put(sign, i)
      } else {
        maxLen = maxLen max (i - mm(sign))
      }
    }
    maxLen
  }
}