package leetcode.normal.n90

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/subsets-ii/
  * 90. 子集 II
  */
object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted
    val ss = mutable.Set[List[Int]]()

    def dfs(pos: Int, res: List[Int]): Unit = {
      ss.add(res)
      (pos + 1 until sorted.length).foreach {
        next =>
          dfs(next, res :+ sorted(next))
          dfs(next, res)
      }
    }

    dfs(-1, List.empty)
    ss.toList
  }
}
