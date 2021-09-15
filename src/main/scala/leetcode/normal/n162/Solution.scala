package leetcode.normal.n162

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/find-peak-element/
  * 162. 寻找峰值
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findPeakElement(nums: Array[Int]): Int = {
    var l = 0
    var r = nums.length - 1
    var ans = -1

    def compare(posL: Int, posR: Int): Int = {
      if (posL == -1) {
        -1
      } else if (posR == nums.length) {
        1
      } else {
        nums(posL) - nums(posR)
      }
    }

    while (l <= r && ans == -1) {
      val m = (l + r) >> 1
      if (compare(m - 1, m) < 0 && compare(m, m + 1) > 0) {
        ans = m
      }
      if (compare(m, m + 1) < 0) {
        l = m + 1
      } else r = m - 1
    }
    ans
  }
}
