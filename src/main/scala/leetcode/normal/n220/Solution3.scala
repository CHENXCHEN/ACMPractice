package leetcode.normal.n220

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/contains-duplicate-iii/
  * 220. 存在重复元素 III
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution3 {
  def containsNearbyAlmostDuplicate(nums2: Array[Int], k: Int, t: Int): Boolean = {
    if (k == 0) return false
    val nums = nums2.map(_.toLong)
    var i = 0
    val tSet = mutable.TreeSet[Long]()
    while (i < nums.length) {
      val between = tSet.range(nums(i) - t, nums(i) + t + 1)
      if (between.nonEmpty) return true
      tSet.add(nums(i))
      if (tSet.size > k) {
        tSet.remove(nums(i - k))
      }
      i += 1
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(containsNearbyAlmostDuplicate(Array(1, 5, 9, 1, 5, 9), 2, 3))
  }
}
