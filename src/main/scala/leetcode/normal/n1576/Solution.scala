package leetcode.normal.n1576

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
  * 1576. 替换所有的问号
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def modifyString(s: String): String = {
    val sb = new StringBuilder(s)
    def isPlace(ch: Char, pos: Int): Boolean = {
      if (pos == 0) {
        sb.length <= 1 || sb.charAt(1) != ch
      } else if (pos == sb.length - 1) {
        sb.length <= 1 || sb.charAt(sb.length - 2) != ch
      } else {
        sb.charAt(pos - 1) != ch && sb.charAt(pos + 1) != ch
      }
    }

    sb.indices.foreach { i =>
      if (sb(i) == '?') {
        (0 until 26).exists { j =>
          val ch = ('a' + j).toChar
          if (isPlace(ch, i)) {
            sb(i) = ch
            true
          } else false
        }
      }
    }
    sb.toString()
  }
}