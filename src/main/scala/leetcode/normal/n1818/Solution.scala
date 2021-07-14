package leetcode.normal.n1818

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
  * 1818. 绝对差值和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int = {
    val tSet = mutable.TreeSet.empty[Int]
    val mod = 1000000000 + 7
    val absSum = nums1.indices.map { i =>
      math.abs(nums1(i) - nums2(i))
    }.foldLeft(0)((a, b) => (a + b) % mod)
    nums1.foreach(x => tSet.add(x))

    var ans = absSum
    nums1.indices.foreach { i =>
      val left = tSet.rangeImpl(None, Some(nums2(i) + 1))
      val right = tSet.rangeImpl(Some(nums2(i)), None)
      val before = absSum - math.abs(nums1(i) - nums2(i))
      if (left.nonEmpty) {
        left.lastOption.foreach { n1 =>
          val changed = (before + math.abs(n1 - nums2(i))) % mod
          if (changed < ans) ans = changed
        }
      }
      if (right.nonEmpty) {
        right.headOption.foreach { n1 =>
          val changed = (before + math.abs(n1 - nums2(i))) % mod
          if (changed < ans) ans = changed
        }
      }
    }
    (ans + mod) % mod
  }
}
