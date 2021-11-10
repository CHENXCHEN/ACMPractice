package leetcode.normal.n495

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/teemo-attacking/
  * 495. 提莫攻击
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    var ans = 0
    var lastStep = 0
    timeSeries.foreach { t =>
      ans += duration
      if (t < lastStep) {
        ans -= lastStep - t
      }
      lastStep = t + duration
    }
    ans
  }
}
