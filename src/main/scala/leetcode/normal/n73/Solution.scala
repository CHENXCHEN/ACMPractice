package leetcode.normal.n73

/**
  * https://leetcode-cn.com/problems/set-matrix-zeroes/
  * 73. 矩阵置零
  */
object Solution {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    var rows: List[Int] = List.empty
    var cols: List[Int] = List.empty
    val rowVis = Array.fill[Boolean](matrix.length)(false)
    val colVis = Array.fill[Boolean](matrix.head.length)(false)
    matrix.indices.foreach {
      i =>
        matrix(i).indices.foreach {
          j =>
            if (matrix(i)(j) == 0) {
              if (!rowVis(i)) {
                rows :+= i
                rowVis(i) = true
              }
              if (!colVis(j)) {
                cols :+= j
                colVis(j) = true
              }
            }
        }
    }
    rows.foreach {
      row =>
        matrix(row).indices.foreach {
          j =>
            matrix(row)(j) = 0
        }
    }
    cols.foreach {
      col =>
        matrix.indices.foreach {
          i =>
            matrix(i)(col) = 0
        }
    }
  }
}
