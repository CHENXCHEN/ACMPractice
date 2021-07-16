package leetcode.normal.n2028

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
  * 剑指 Offer 53 - I. 在排序数组中查找数字 I
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.length == 0) return 0

    def findLeft(): Int = {
      var l = 0
      var r = nums.length - 1
      var ans = -1
      while (l <= r) {
        val m = (l + r) >> 1
        if (nums(m) == target) {
          ans = m
          r = m - 1
        } else if (nums(m) > target) {
          r = m - 1
        } else {
          l = m + 1
        }
      }
      ans
    }

    def findRight(): Int = {
      var l = 0
      var r = nums.length - 1
      var ans = -1
      while (l <= r) {
        val m = (l + r) >> 1
        if (nums(m) == target) {
          ans = m
          l = m + 1
        } else if (nums(m) > target) {
          r = m - 1
        } else {
          l = m + 1
        }
      }
      ans
    }

    lazy val leftPos = findLeft()
    lazy val rightPos = findRight()
    if (leftPos == -1) 0
    else rightPos - leftPos + 1
  }
}
