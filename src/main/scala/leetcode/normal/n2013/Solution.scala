package leetcode.normal.n2013

/**
  * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
  * 面试题 17.21. 直方图的水量
  */
object Solution {
  def trap(height: Array[Int]): Int = {
    if (height.isEmpty) return 0
    val leftMax = Array.fill[Int](height.length)(0)
    val rightMax = Array.fill[Int](height.length)(0)
    leftMax(0) = height(0)
    rightMax(height.length - 1) = height.last
    (1 until height.length).foreach {
      i =>
        leftMax(i) = math.max(leftMax(i - 1), height(i))
    }
    (height.length - 2 to(0, -1)).foreach {
      i =>
        rightMax(i) = math.max(rightMax(i + 1), height(i))
    }
    var ans = 0
    (1 until height.length - 1).foreach {
      i =>
        val minHeight = math.min(leftMax(i - 1), rightMax(i + 1))
        if (minHeight > height(i)) ans += minHeight - height(i)
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    Seq(
      Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    ).foreach {
      arr =>
        println(s"ans: ${trap(arr)}, arr: ${arr.toSeq}")
    }
  }
}
