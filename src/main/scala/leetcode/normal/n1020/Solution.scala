package leetcode.normal.n1020

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/number-of-enclaves/
  * 1020. 飞地的数量
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numEnclaves(grid: Array[Array[Int]]): Int = {
    val vis = Array.fill(grid.length)(Array.fill(grid.head.length)(false))
    val dx = Array(1, -1, 0, 0)
    val dy = Array(0, 0, 1, -1)
    val q = mutable.Queue.empty[(Int, Int)]
    val rows = grid.length
    val cols = grid.head.length

    Array(0, rows - 1).foreach { row =>
      0.until(cols).foreach { col =>
        if (grid(row)(col) == 1) {
          q.enqueue((row, col))
          vis(row)(col) = true
        }
      }
    }
    Array(0, cols - 1).foreach { col =>
      0.until(rows).foreach { row =>
        if (grid(row)(col) == 1) {
          q.enqueue((row, col))
          vis(row)(col) = true
        }
      }
    }

    while (q.nonEmpty) {
      val (x, y) = q.dequeue()
      (0 until 4).foreach { i =>
        val nextX = x + dx(i)
        val nextY = y + dy(i)
        if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
          if (grid(nextX)(nextY) == 1 && !vis(nextX)(nextY)) {
            q.enqueue((nextX, nextY))
            vis(nextX)(nextY) = true
          }
        }
      }
    }
    var ans = 0
    (0 until rows).foreach { row =>
      (0 until cols).foreach { col =>
        if (grid(row)(col) == 1 && !vis(row)(col)) ans += 1
      }
    }
    ans
  }
}