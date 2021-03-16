package leetcode.normal.n54

/**
  * https://leetcode-cn.com/problems/spiral-matrix/
  * 54. 螺旋矩阵
  */
object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    var minRow = -1
    var maxRow = matrix.length
    var minCol = -1
    var maxCol = matrix.head.length
    val hash = Array.fill[Array[Boolean]](matrix.length + 1)(Array.fill[Boolean](matrix.head.length + 1)(false))
    var (curX, curY) = (0, 0)
    var vv = List.empty[Int]

    def check(x: Int, y: Int): Boolean = x >= 0 && x < matrix.length && y >= 0 && y < matrix.head.length

    while (maxRow - minRow > 1 && maxCol - minCol > 1) {
      if (maxCol - minCol > 1) {
        // →
        while (curY < maxCol) {
          if (check(curX, curY) && !hash(curX)(curY)) {
            vv :+= matrix(curX)(curY)
            hash(curX)(curY) = true
          }
          curY += 1
        }
        curY = maxCol - 1
        curX += 1
        minRow += 1
        //        println(s"→ curX:$curX curY:$curY minCol:$minCol maxCol:$maxCol minRow:$minRow maxRow:$maxRow $vv")
      }
      if (maxRow - minRow > 1) {
        // ↓
        while (curX < maxRow) {
          if (check(curX, curY) && !hash(curX)(curY)) {
            vv :+= matrix(curX)(curY)
            hash(curX)(curY) = true
          }
          curX += 1
        }
        curX = maxRow - 1
        curY -= 1
        maxCol -= 1
        //        println(s"↓ curX:$curX curY:$curY minCol:$minCol maxCol:$maxCol minRow:$minRow maxRow:$maxRow $vv")
      }
      if (maxCol - minCol > 1) {
        // ←
        while (curY > minCol) {
          if (check(curX, curY) && !hash(curX)(curY)) {
            vv :+= matrix(curX)(curY)
            hash(curX)(curY) = true
          }
          curY -= 1
        }
        curY = minCol + 1
        curX -= 1
        maxRow -= 1
        //        println(s"← curX:$curX curY:$curY minCol:$minCol maxCol:$maxCol minRow:$minRow maxRow:$maxRow $vv")
      }
      if (maxRow - minRow > 1) {
        // ↑
        while (curX > minRow) {
          if (check(curX, curY) && !hash(curX)(curY)) {
            vv :+= matrix(curX)(curY)
            hash(curX)(curY) = true
          }
          curX -= 1
        }
        curX = minRow + 1
        curY += 1
        minCol += 1
        //        println(s"↑ curX:$curX curY:$curY minCol:$minCol maxCol:$maxCol minRow:$minRow maxRow:$maxRow $vv")
      }
    }
    vv
  }

  def main(args: Array[String]): Unit = {
    println(spiralOrder(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))))
    println(spiralOrder(Array(Array(1))))
  }
}
