package leetcode.normal.n704

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-search/
  * 704. 二分查找
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    var l = 0
    var r = nums.length - 1
    while (l <= r) {
      val mid = (l + r) >> 1
      if (nums(mid) > target) {
        r = mid - 1
      } else if (nums(mid) < target) {
        l = mid + 1
      } else {
        return mid
      }
    }
    -1
  }
}
