package leetcode.normal.n131

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/palindrome-partitioning/
  * 131. 分割回文串
  */
object Solution {
  def checkIf(str: String): Boolean = {
    if (str.length == 1) true
    else {
      var (left, right) = (0, str.length - 1)
      while (left < right && str(left) == str(right)) {
        left += 1
        right -= 1
      }
      left >= right
    }
  }

  def partition(s: String): List[List[String]] = {
    val edges = s.indices.map {
      i =>
        ((i + 1) to s.length).flatMap {
          j =>
            if (Some(s.substring(i, j)).exists(checkIf)) Some(j)
            else None
        }.toArray
    }.toArray
    val q = mutable.Queue[Array[Int]](Array(0))
    var ans: Array[Array[Int]] = Array.empty
    while (q.nonEmpty) {
      val cur = q.dequeue()
      if (cur.last == s.length) {
        ans :+= cur
      } else {
        edges(cur.last).foreach {
          n => q.enqueue(cur :+ n)
        }
      }
    }
    ans.map {
      subArr =>
        (0 until subArr.length - 1).map {
          i => s.substring(subArr(i), subArr(i + 1))
        }.toList
    }.toList
  }
}
