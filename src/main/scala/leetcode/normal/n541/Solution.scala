package leetcode.normal.n541

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/reverse-string-ii/
  * 541. 反转字符串 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def reverseStr(s: String, k: Int): String = {
    val sb = new StringBuilder(s)
    val len = s.length
    0.until(len, k << 1).foreach { i =>
      var start = i
      var end = math.min(start + k - 1, len - 1)
      while (end >=i) {
        sb.setCharAt(start, s(end))
        start += 1
        end -=1
      }
    }
    sb.toString()
  }
}
