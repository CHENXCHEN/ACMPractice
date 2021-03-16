package leetcode.normal.n59

/**
  * https://leetcode-cn.com/problems/spiral-matrix-ii/
  * 59. 螺旋矩阵 II
  */
object Solution {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    var (rows, cols) = (n, n)
    var vv = Array.fill[Array[Int]](n)(Array.fill[Int](n)(0))
    var (x, y) = (0, 0)
    var cnt = 1
    while (cols > 0 && rows > 0) {
      // 右
      (0 until cols).foreach {
        posY => vv(x)(y + posY) = cnt; cnt += 1
      }
      x += 1
      y += cols - 1
      rows -= 1
      // 下
      (0 until rows).foreach {
        posX => vv(x + posX)(y) = cnt; cnt += 1
      }
      x += rows - 1
      y -= 1
      cols -= 1
      // 左
      (0 until cols).foreach {
        posY => vv(x)(y - posY) = cnt; cnt += 1
      }
      x -= 1
      y -= cols - 1
      rows -= 1
      // 上
      (0 until rows).foreach {
        posX => vv(x - posX)(y) = cnt; cnt += 1
      }
      y += 1
      x -= rows - 1
      cols -= 1
    }
    vv
  }
}
