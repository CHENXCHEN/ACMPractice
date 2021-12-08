package leetcode.normal.n689

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
  * 689. 三个无重叠子数组的最大和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    val preSum = Array.fill(nums.length + 1)(0)
    (1 to nums.length).foreach { i =>
      preSum(i) = preSum(i - 1) + nums(i - 1)
    }

    def calc(pos: Int): Int = {
      preSum(pos + k) - preSum(pos)
    }

    val rightMax = Array.fill(nums.length)((0, 0))
    val leftMax = Array.fill(nums.length)((0, 0))
    (0 until (nums.length - k)).foreach { i =>
      val si = calc(i)
      if (i == 0 || leftMax(i - 1)._1 < si) {
        leftMax(i) = (si, i)
      } else leftMax(i) = leftMax(i - 1)
    }

    (nums.length - k).to(0, -1).foreach { i =>
      val si = calc(i)
      if (i == nums.length - k || rightMax(i + 1)._1 <= si) {
        rightMax(i) = (si, i)
      } else rightMax(i) = rightMax(i + 1)
    }

    var maxAns = 0
    var maxArr = Array.fill(3)(0)
    (k until (nums.length - k - k + 1)).foreach { i =>
      val res = leftMax(i - k)._1 + calc(i) + rightMax(i + k)._1
      if (res > maxAns) {
        maxAns = res
        maxArr = Array(leftMax(i - k)._2, i, rightMax(i + k)._2)
      }
    }
    maxArr
  }
}