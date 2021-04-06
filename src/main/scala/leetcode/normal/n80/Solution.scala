package leetcode.normal.n80

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
  * 80. 删除有序数组中的重复项 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    var left = -1
    var i = 1
    while (i < nums.length) {
      if (nums(i) == nums(i - 1)) {
        if (left == -1) left = i + 1
        else {
          nums(left) = nums(i)
          left += 1
        }
        i += 1
        while (i < nums.length && nums(i) == nums(i - 1)) i += 1
      } else {
        if (left > 0) {
          nums(left) = nums(i)
          left += 1
        }
        i += 1
      }
    }
    if (left > 0) left
    else nums.length
  }
}
