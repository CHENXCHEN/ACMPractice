package leetcode.normal.n523

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode-solu-rdzi/
  * 523. 连续的子数组和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    val mm = mutable.Map[Int, Int](0 -> -1)
    var ss = 0
    nums.indices.exists { i =>
      ss = (ss + nums(i)) % k
      if (mm.contains(ss)) {
        if (i - mm(ss) >= 2) true
        else false
      } else {
        mm.put(ss, i)
        false
      }
    }
  }
}
