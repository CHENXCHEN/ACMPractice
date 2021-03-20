package leetcode.normal.n132

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
  * 132. 分割回文串 II
  */
object Solution {
  def minCut(s: String): Int = {
    val isPalindromeMap = scala.collection.mutable.Map.empty[(Int, Int), Boolean]

    def isPa(left: Int, right: Int): Boolean = {
      if (left >= right) true
      else if (isPalindromeMap.contains((left, right))) isPalindromeMap((left, right))
      else {
        val ret = s(left) == s(right) && isPa(left + 1, right - 1)
        isPalindromeMap((left, right)) = ret
        ret
      }
    }

    val edges = s.indices.map {
      i =>
        (i + 1 to s.length).flatMap {
          j =>
            if (isPa(i, j - 1)) Some(j)
            else None
        }
    }

    val visit = Array.fill[Int](s.length + 10)(Int.MaxValue)
    visit(0) = 0

    val q = mutable.Queue[Int](0)
    while (q.nonEmpty) {
      val curIndex: Int = q.dequeue()
      val nextStep = visit(curIndex) + 1
      if (curIndex < s.length)
        edges(curIndex).foreach {
          nextIndex =>
            if (visit(nextIndex) > nextStep) {
              visit(nextIndex) = nextStep
              q.enqueue(nextIndex)
            }
        }
    }
    visit(s.length) - 1
  }

  def main(args: Array[String]): Unit = {
    minCut("aab")
  }
}
