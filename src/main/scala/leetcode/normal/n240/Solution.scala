package leetcode.normal.n240

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
  * 240. 搜索二维矩阵 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val rows = matrix.length
    val cols = matrix.head.length
    var x = 0
    var y = cols - 1
    while (x < rows && y >= 0) {
      val vv = matrix(x)(y)
      if (vv == target) {
        return true
      } else if (vv > target) {
        y -= 1
      } else {
        x += 1
      }
    }
    false
  }
}
