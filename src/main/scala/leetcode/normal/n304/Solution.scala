package leetcode.normal.n304

object Solution {
  def main(args: Array[String]): Unit = {
    val vv = Array.fill[Int](2, 3)(0)
    println(vv.length, vv.head.length, vv(0)(0))
  }
}

/**
  * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
  * 304. 二维区域和检索 - 矩阵不可变
  */
class NumMatrix(_matrix: Array[Array[Int]]) {
  lazy val preSum: Array[Array[Int]] = {
    val ret: Array[Array[Int]] = Array.fill[Int](_matrix.length, _matrix.head.length)(0)
    _matrix.indices.foreach {
      i =>
        _matrix.head.indices.foreach {
          j =>
            val upSum = if (i == 0) 0 else ret(i - 1)(j)
            val downSum = if (j == 0) 0 else ret(i)(j - 1)
            val removeSum = if (i == 0 || j == 0) 0 else ret(i - 1)(j - 1)
            ret(i)(j) = _matrix(i)(j) + upSum + downSum - removeSum
        }
    }
    ret
  }

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    val upSum = if (row1 == 0) 0 else preSum(row1 - 1)(col2)
    val leftSum = if (col1 == 0) 0 else preSum(row2)(col1 - 1)
    val removeSum = if (row1 == 0 || col1 == 0) 0 else preSum(row1 - 1)(col1 - 1)
    preSum(row2)(col2) - upSum - leftSum + removeSum
  }
}
