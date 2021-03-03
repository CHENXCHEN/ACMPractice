package leetcode.normal.n896

/**
  * https://leetcode-cn.com/problems/monotonic-array/
  * 896. 单调队列
  */
object Solution {
  def isMonotonic(A: Array[Int]): Boolean = {
    var isUp = true
    var isDown = true
    A.indices.foreach {
      i =>
        if (i > 0) {
          if (A(i) > A(i - 1)) isDown = false
          if (A(i) < A(i - 1)) isUp = false
        }
    }
    isUp | isDown
  }
}
