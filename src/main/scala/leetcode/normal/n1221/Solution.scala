package leetcode.normal.n1221

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
  * 1221. 分割平衡字符串
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def balancedStringSplit(s: String): Int = {
    var ans = 0
    var cntL = 0
    var cntR = 0
    s.foreach { ch =>
      ch match {
        case 'L' => cntL += 1
        case 'R' => cntR += 1
      }
      if (cntL == cntR) ans +=1
    }
    ans
  }
}
