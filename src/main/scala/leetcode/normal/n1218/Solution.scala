package leetcode.normal.n1218

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
  * 1218. 最长定差子序列
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def longestSubsequence(arr: Array[Int], difference: Int): Int = {
    val tMap = mutable.TreeMap.empty[Int, Int]
    var ans = 0
    arr.foreach { item =>
      val last = item - difference
      val m = tMap.getOrElse(last, 0) + 1
      ans = ans.max(m)
      tMap.put(item, m)
    }
    ans
  }
}