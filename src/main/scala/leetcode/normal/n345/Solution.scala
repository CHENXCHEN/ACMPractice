package leetcode.normal.n345

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
  * 345. 反转字符串中的元音字母
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def reverseVowels(s: String): String = {
    val sb = new StringBuilder(s)
    val ss = Set('a', 'e', 'i', 'o', 'u')
    var left = 0
    var right = s.length - 1
    while (left < right) {
      while (left < right && !ss.contains(s(left).toLower)) left += 1
      while (left < right && !ss.contains(s(right).toLower)) right -= 1
      if (left < right) {
        sb.setCharAt(left, s(right))
        sb.setCharAt(right, s(left))
        left += 1
        right -= 1
      }
    }
    sb.toString()
  }
}
