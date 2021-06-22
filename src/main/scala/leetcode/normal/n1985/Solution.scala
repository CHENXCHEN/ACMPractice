package leetcode.normal.n1985

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
  * 剑指 Offer 38. 字符串的排列
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def permutation(s: String): Array[String] = {
    val distinctSet = mutable.TreeSet.empty[String]
    val posSet = mutable.TreeSet.empty[Int]

    val ans = new mutable.StringBuilder(s.length)
    ans.setLength(s.length)

    def findAll(step: Int): Unit = {
      if (step == s.length) {
        distinctSet.add(ans.toString())
      } else {
        (0 until s.length).foreach { i =>
          if (!posSet.contains(i)) {
            posSet.add(i)
            ans.setCharAt(step, s(i))
            findAll(step + 1)
            posSet.remove(i)
          }
        }
      }
    }

    findAll(0)

    distinctSet.toArray
  }
}
