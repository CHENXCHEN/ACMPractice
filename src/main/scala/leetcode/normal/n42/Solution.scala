package leetcode.normal.n42

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/trapping-rain-water/
  * 42. 接雨水
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def trap(height: Array[Int]): Int = {
    var (left, right) = (0, height.length - 1)
    var (leftMax, rightMax) = (0, 0)
    var ans = 0
    while (left < right) {
      leftMax = leftMax.max(height(left))
      rightMax = rightMax.max(height(right))
      if (height(left) <= height(right)) {
        ans += leftMax - height(left)
        left += 1
      } else {
        ans += rightMax - height(right)
        right -= 1
      }
    }
    ans
  }
}
