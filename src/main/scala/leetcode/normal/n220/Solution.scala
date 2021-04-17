package leetcode.normal.n220

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/contains-duplicate-iii/
  * 220. 存在重复元素 III
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    if (k == 0) return false
    val longNums = nums.map(_.toLong)
    checkIfLeft(longNums, k, t) || checkIfLeft(longNums.reverse, k, t)
  }

  def checkIfLeft(nums: Array[Long], k: Int, t: Int): Boolean = {
    var right = 1
    var i = 0
    val tMap = new java.util.TreeMap[Long, Int]()
    tMap.put(nums.head, 1)
    while (i < nums.length) {
      // 删除当前元素，只考虑一边的
      tMap.put(nums(i), tMap.get(nums(i)) - 1)
      if (tMap.get(nums(i)) == 0) tMap.remove(nums(i))

      // 移动右元素
      while (right - i <= k && right <= nums.length - 1) {
        tMap.put(nums(right), tMap.getOrDefault(nums(right), 0) + 1)
        right += 1
      }
      val vv = tMap.higherEntry(nums(i) - 1)
      if (vv != null && (vv.getKey - nums(i)) <= t) {
        return true
      }
      i += 1
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(containsNearbyAlmostDuplicate(Array(1, 5, 9, 1, 5, 9), 2, 3))
    println(containsNearbyAlmostDuplicate(Array(2147483647, -1, 2147483647), 1, 2147483647))
  }
}
