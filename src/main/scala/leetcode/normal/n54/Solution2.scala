package leetcode.normal.n54

/**
  * https://leetcode-cn.com/problems/spiral-matrix/
  * 54. 螺旋矩阵
  */
object Solution2 {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    var (rows, cols) = (matrix.length, matrix.head.length)
    var vv = List.empty[Int]
    var (x, y) = (0, 0)

    def check(x: Int, y: Int): Boolean = x > 0 && y > 0

    while (check(rows, cols)) {
      // 右
      if (check(rows, cols))
        (0 until cols).foreach {
          posY => vv :+= matrix(x)(y + posY)
        }
      x += 1
      y += cols - 1
      rows -= 1
      //      println(s"右 $rows $cols")
      // 下
      if (check(rows, cols))
        (0 until rows).foreach {
          posX => vv :+= matrix(x + posX)(y)
        }
      x += rows - 1
      y -= 1
      cols -= 1
      //      println(s"下 $rows $cols")
      // 左
      if (check(rows, cols))
        (0 until cols).foreach {
          posY => vv :+= matrix(x)(y - posY)
        }
      x -= 1
      y -= cols - 1
      rows -= 1
      //      println(s"左 $rows $cols")
      // 上
      if (check(rows, cols))
        (0 until rows).foreach {
          posX => vv :+= matrix(x - posX)(y)
        }
      y += 1
      x -= rows - 1
      cols -= 1
      //      println(s"上 $rows $cols")
    }
    vv
  }

  def main(args: Array[String]): Unit = {
    println(spiralOrder(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))))
    println(spiralOrder(Array(Array(1))))
    println(spiralOrder(Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12))))
  }
}
