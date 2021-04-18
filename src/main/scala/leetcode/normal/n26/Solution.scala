package leetcode.normal.n26

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
  * 26. 删除有序数组中的重复项
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length < 2) return nums.length
    var (i, tot) = (1, 1)
    while (i < nums.length) {
      while (i < nums.length && nums(i) == nums(i - 1)) i += 1
      if (i < nums.length) {
        nums(tot) = nums(i)
        tot += 1
      }
      i += 1
    }
    tot
  }
}
