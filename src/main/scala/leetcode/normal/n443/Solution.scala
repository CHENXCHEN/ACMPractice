package leetcode.normal.n443

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/string-compression/
  * 443. 压缩字符串
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def compress(chars: Array[Char]): Int = {
    var pos = 0
    var ans = 0
    while (pos < chars.length) {
      val ch = chars(pos)
      val end = chars.indexWhere(_ != ch, pos) match {
        case -1 => chars.length
        case x => x
      }
      val cnt = end - pos
      chars(ans) = ch
      ans += 1
      if (cnt > 1) {
        cnt.toString.foreach {
          ch =>
            chars(ans) = ch
            ans += 1
        }
      }
      pos = end
    }
    ans
  }

}