package leetcode.normal.n74

/**
  * https://leetcode-cn.com/problems/search-a-2d-matrix/
  * 74. 搜索二维矩阵
  */
object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val rows = matrix.length
    val cols = matrix.head.length

    def extract(pos: Int): (Int, Int) = {
      (pos / cols, pos % cols)
    }

    var (left, right) = (0, cols * rows - 1)

    while (left <= right) {
      val mid = (left + right) >> 1
      val (row, col) = extract(mid)
      val midVal = matrix(row)(col)
      if (midVal == target) return true
      else if (midVal > target) right = mid - 1
      else left = mid + 1
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(searchMatrix(Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 60)), 3))
  }
}
