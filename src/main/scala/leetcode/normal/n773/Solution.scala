package leetcode.normal.n773

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/sliding-puzzle/
  * 773. 滑动谜题
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    val visit = Array.fill(543212)(-1)
    val start = board.flatten.mkString.toInt
    visit(start) = 0
    val q = mutable.Queue.empty[Int]
    q.enqueue(start)
    val dir = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    while (q.nonEmpty) {
      val cur = q.dequeue()
      if (cur == 123450) return visit(cur)
      val zeroPos = getPosFromVal(cur, 0)
      val (x, y) = (zeroPos / 3, zeroPos % 3)
      val step = visit(cur)
      dir.foreach {
        case (dx, dy) =>
          val tx = x + dx
          val ty = y + dy
          if (tx >= 0 && tx < 2 && ty >= 0 && ty < 3) {
            val next = tx * 3 + ty
            val nextNum = swapPosVal(cur, zeroPos, next)
            if (visit(nextNum) == -1 || visit(nextNum) > step + 1) {
              q.enqueue(nextNum)
              visit(nextNum) = step + 1
            }
          }
      }
    }
    -1
  }

  def getPosFromVal(num: Int, v: Int): Int = {
    (0 to 5).find(i => getValFromPos(num, i) == v).get
  }

  def getValFromPos(num: Int, pos: Int): Int = {
    val base = math.pow(10, 5 - pos).toInt
    (num / base) % 10
  }

  def swapPosVal(num: Int, pos1: Int, pos2: Int): Int = {
    val base1 = math.pow(10, 5 - pos1).toInt
    val base2 = math.pow(10, 5 - pos2).toInt
    val v1 = (num / base1) % 10
    val v2 = (num / base2) % 10
    num - v1 * base1 - v2 * base2 + v1 * base2 + v2 * base1
  }

  def main(args: Array[String]): Unit = {
    println(slidingPuzzle(Array(Array(1, 2, 3), Array(4, 0, 5))))
  }
}
