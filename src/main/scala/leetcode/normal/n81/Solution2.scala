package leetcode.normal.n81

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/submissions/
  * 81. 搜索旋转排序数组 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def search(nums: Array[Int], target: Int): Boolean = {
    var (left, right) = (0, nums.length - 1)
    while (left <= right) {
      val mid = (left + right) >> 1
      val vMid = nums(mid)
      val vLeft = nums(left)
      val vRight = nums(right)
      if (vMid == target) return true
      else if (vLeft < vMid) {
        if (vLeft <= target && target < vMid) right = mid - 1
        else left = mid + 1
      }
      else if (vLeft > vMid) {
        if (vMid < target && target <= vRight) left = mid + 1
        else right = mid - 1
      } else left += 1
    }
    false
  }
}
