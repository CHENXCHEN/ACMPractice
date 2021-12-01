package leetcode.normal.n1446

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/consecutive-characters/
  * 1446. 连续字符
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxPower(s: String): Int = {
    var ch = s.head
    var cnt = 0
    var ans = 0
    s.foreach { cc =>
      if (cc == ch) {
        cnt += 1
      } else {
        cnt = 1
        ch = cc
      }
      ans = ans.max(cnt)
    }
    ans
  }
}
