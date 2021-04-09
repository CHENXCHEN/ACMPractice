package leetcode.normal.n154

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
  * 154. 寻找旋转排序数组中的最小值
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findMin(nums: Array[Int]): Int = {
    var (left, right) = (0, nums.length - 1)
    var minNum = nums.head
    while (left <= right) {
      val mid = (left + right) >> 1
      val (vRight, vMid) = (nums(right), nums(mid))
      if (vMid < vRight) {
        minNum = minNum min vMid
        right = mid - 1
      } else if (vMid > vRight) {
        minNum = minNum min vRight
        left = mid + 1
      } else {
        minNum = minNum min vMid
        right -= 1
      }
    }
    minNum
  }

  def main(args: Array[String]): Unit = {
    println(findMin(Array(3, 4, 5, 1, 2)))
    println(findMin(Array(4, 5, 6, 7, 0, 1, 2)))
  }
}
