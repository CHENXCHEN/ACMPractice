package leetcode.normal.n1924

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/chuan-di-xin-xi/
  * LCP 07. 传递信息
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    val q = mutable.Queue.empty[(Int, Int)]
    q.enqueue((0, 0))
    val ans = Array.fill(k + 2)(Array.fill(n + 2)(0))
    val edges = relation.groupBy(_.head).mapValues(_.map(_.last).toSeq)
    ans(0)(0) = 1
    while (q.nonEmpty) {
      val (cur, step) = q.dequeue()
      if (step < k && edges.contains(cur))
        edges(cur).foreach { next =>
          if (ans(step + 1)(next) == 0) {
            q.enqueue((next, step + 1))
          }
          ans(step + 1)(next) += ans(step)(cur)
        }
    }
    ans(k)(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(numWays(3, Array(Array(0,2), Array(2,1)), 2))
  }
}
