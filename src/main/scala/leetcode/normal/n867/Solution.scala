package leetcode.normal.n867

/**
  * https://leetcode-cn.com/problems/transpose-matrix/
  * 867. 转置矩阵
  */
object Solution {
  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    matrix.head.indices.map {
      y =>
        matrix.indices.map {
          x =>
            matrix(x)(y)
        }.toArray
    }.toArray
  }
}
