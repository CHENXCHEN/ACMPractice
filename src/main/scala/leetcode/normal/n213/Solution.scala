package leetcode.normal.n213

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/house-robber-ii/
  * 213. 打家劫舍 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) return nums.head
    findMaxNum(nums, 0, nums.length - 1) max findMaxNum(nums, 1, nums.length)
  }

  def findMaxNum(nums: Array[Int], start: Int, end: Int): Int = {
    if (start >= end) return 0
    if (end - start == 1) return nums(start)
    var prePreNum = nums(start)
    var preNum = nums(start) max nums(start + 1)
    var maxNum = prePreNum max preNum
    var i = start + 2
    while (i < end) {
      val nowNum = (prePreNum + nums(i)).max(preNum)
      maxNum = maxNum max nowNum
      prePreNum = preNum
      preNum = nowNum
      i += 1
    }
    maxNum
  }
}
