package leetcode.normal.n786

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
  * 786. 第 K 个最小的素数分数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    val pQueue = mutable.PriorityQueue.empty[(Int, Int)]((x, y) => {
      arr(y._1) * arr(x._2) - arr(x._1) * arr(y._2)
    })
    (1 until arr.length).foreach { i =>
      pQueue.enqueue((0, i))
    }
    (1 until k).foreach { _ =>
      val (x, y) = pQueue.dequeue()
      if (x + 1 < y) {
        pQueue.enqueue((x + 1, y))
      }
    }
    val (tx, ty) = pQueue.dequeue()
    Array(arr(tx), arr(ty))
  }
}

