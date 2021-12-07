package leetcode.normal.n1034

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/coloring-a-border/
  * 1034. 边界着色
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def colorBorder(grid: Array[Array[Int]], row: Int, col: Int, color: Int): Array[Array[Int]] = {
    val dx = Array(1, 0, -1, 0)
    val dy = Array(0, 1, 0, -1)
    val rows = grid.length
    val cols = grid.head.length
    val from = grid(row)(col)
    val q = mutable.Queue.empty[(Int, Int)]
    q.enqueue((row, col))
    val vis = Array.fill(rows)(Array.fill(cols)(false))
    vis(row)(col) = true
    val ans = grid.map(_.clone())

    def isBoard(x: Int, y: Int): Boolean = {
      if (x < 0 || y < 0 || x >= rows || y >= cols) true
      else false
    }

    while (q.nonEmpty) {
      val (x, y) = q.dequeue()
      var isBordGrid = false
      (0 until 4).foreach { i =>
        val nextX = dx(i) + x
        val nextY = dy(i) + y
        if (isBoard(nextX, nextY)) {
          isBordGrid = true
        } else if (!vis(nextX)(nextY)) {
          vis(nextX)(nextY) = true
          if (grid(nextX)(nextY) == from) {
            q.enqueue((nextX, nextY))
          } else isBordGrid = true
        } else if (grid(nextX)(nextY) != from) {
          isBordGrid = true
        }
      }
      if (isBordGrid) {
        ans(x)(y) = color
      }
    }
    ans
  }
}