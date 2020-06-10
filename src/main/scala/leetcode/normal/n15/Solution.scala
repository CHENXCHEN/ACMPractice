package leetcode.normal.n15

import util.control.Breaks._

/**
  * 三数之和(https://leetcode-cn.com/problems/3sum/)
  */
object Solution {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val intToSet = nums.zipWithIndex.groupBy(_._1).map {
      case (i, tuples) => i -> tuples.map(_._2).toSet
    }
    var ans = List.empty[List[Int]]
    var results = Set.empty[String]
    for (i <- nums.indices) {
      for (j <- i + 1 until nums.length) {
        val vv = 0 - nums(i) - nums(j)
        if (intToSet.contains(vv) && intToSet(vv).exists(x => x != i && x != j)) {
          val ret = List(nums(i), nums(j), vv).sorted
          val retHash = ret.mkString(" ")
          if (!results.contains(retHash)) {
            ans :+= ret
          }
          results += retHash
        }
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    Array(
      (Array(-1, 0, 1, 2, -1, -4), List(List(-1, 0, 1), List(-1, -1, 2)))
    ).foreach {
      case (x, ans) =>
        val rx = threeSum(x)
        println("check ", x.toSeq, rx)
        assert(ans == rx)
    }
  }
}
