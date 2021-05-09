package leetcode.normal.n1482

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
  * 1482. 制作 m 束花所需的最少天数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minDays(bloomDay: Array[Int], m: Int, k: Int): Int = {
    def check(day: Int): Boolean = {
      var ans = 0
      var cnt = 0
      bloomDay.foreach {
        bloom =>
          if (bloom <= day) cnt += 1
          else cnt = 0
          if (cnt == k) {
            ans += 1
            cnt = 0
          }
      }
      ans >= m
    }

    var (left, right) = (bloomDay.min, bloomDay.max)
    var ret = -1
    while (left <= right) {
      val mid = (left + right) >> 1
      if (check(mid)) {
        ret = mid
        right = mid - 1
      } else left = mid + 1
    }
    ret
  }
}
