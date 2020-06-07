package leetcode.normal.n11

/**
  * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
  *
  * 说明：你不能倾斜容器，且 n 的值至少为 2。
  *
  * 来源：力扣（LeetCode）
  * 链接：https://leetcode-cn.com/problems/container-with-most-water
  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  *
  * 双指针解法
  */
object Solution {
  def maxArea(height: Array[Int]): Int = {
    var l = 0
    var r = height.length - 1
    var ans = 0
    while (l < r) {
      ans = Math.max(ans, (r - l) * Math.min(height(l), height(r)))
      if (height(l) < height(r)) l += 1
      else r -= 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    Array(
      (Array(1,8,6,2,5,4,8,3,7), 49)
    ).foreach {
      case (x, ans) =>
        val rx = maxArea(x)
        println("check ", x.toSeq, rx)
        assert(ans == rx)
    }
  }
}
