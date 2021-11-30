package leetcode.normal.n400

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/nth-digit/
  * 400. 第 N 位数字
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def calc(v: Long): Long = {
    var cnt = 1
    var tmpV = v / 10
    while (tmpV > 0) {
      cnt += 1
      tmpV /= 10
    }
    var base = 9
    var ans = 0L
    (1 until cnt).foreach { i =>
      ans += base * i
      base *= 10
    }
    ans += (v - (base / 9) + 1) * cnt
    ans
  }

  def findNthDigit(n: Int): Int = {
    if (n == 1) return 1
    var l = 1L
    var r = Int.MaxValue.toLong
    var res = 1L
    while (l <= r) {
      val m = (l + r) >> 1
      val mAns = calc(m)
      if (mAns < n) {
        res = m
        l = m + 1
      } else r = m - 1
    }
    val pos = n - calc(res) - 1
    (res + 1).toString.charAt(pos.toInt) - '0'
  }

}
