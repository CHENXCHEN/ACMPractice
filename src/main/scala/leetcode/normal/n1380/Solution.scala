package leetcode.normal.n1380

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
  * 1380. 矩阵中的幸运数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def luckyNumbers(matrix: Array[Array[Int]]): List[Int] = {
    val rows = matrix.length
    val cols = matrix.head.length
    val rowsMin = Array.fill(rows)(0)
    val colsMax = Array.fill(cols)(0)
    0.until(rows).foreach { row =>
      0.until(cols).foreach { col =>
        val item = matrix(row)(col)
        if (col == 0) rowsMin(row) = item
        else rowsMin(row) = rowsMin(row).min(item)
        if (row == 0) colsMax(col) = item
        else colsMax(col) = colsMax(col).max(item)
      }
    }
    0.until(rows).flatMap { row =>
      0.until(cols).flatMap { col =>
        val item = matrix(row)(col)
        if (item == rowsMin(row) && item == colsMax(col)) Some(item)
        else None
      }
    }.toList
  }
}