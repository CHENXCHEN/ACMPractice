package leetcode.normal.n31

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/next-permutation/
  * 31. 下一个排列
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {

  def swap(nums: Array[Int], posI: Int, posJ: Int): Unit = {
    val tmp = nums(posI)
    nums(posI) = nums(posJ)
    nums(posJ) = tmp
  }

  def reverseInPlace(nums: Array[Int], start: Int, end: Int): Unit = {
    var left = start
    var right = end
    while (left < right) {
      swap(nums, left, right)
      left += 1
      right -= 1
    }
  }

  def nextPermutation(nums: Array[Int]): Unit = {
    var leftPos = -1
    for (i <- 0 until (nums.length - 1)) {
      if (nums(i) < nums(i + 1)) {
        leftPos = i
      }
    }
    if (leftPos == -1) {
      reverseInPlace(nums, 0, nums.length - 1)
    } else {
      var rightPos = -1
      for (i <- (nums.length - 1).until(leftPos, -1)) {
        if (rightPos == -1 && nums(i) > nums(leftPos)) {
          rightPos = i
        }
      }
      swap(nums, leftPos, rightPos)
      reverseInPlace(nums, leftPos + 1, nums.length - 1)
    }
  }
}
