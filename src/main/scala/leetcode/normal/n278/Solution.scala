package leetcode.normal.n278

class VersionControl {
  def isBadVersion(version: Int): Boolean = ???
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/first-bad-version/
  * 278. 第一个错误的版本
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
class Solution extends VersionControl {
  def firstBadVersion(n: Int): Int = {
    var left = 1L
    var right = n.toLong
    while (left < right) {
      val mid = (left + right) >> 1
      if (isBadVersion(mid.toInt)) right = mid
      else left = mid + 1
    }
    right.toInt
  }
}