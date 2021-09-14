package leetcode.normal.n524

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
  * 524. 通过删除字母匹配到字典里最长单词
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findLongestWord(s: String, dictionary: List[String]): String = {
    val dp = Array.fill(s.length + 1, 26)(s.length)
    (s.length - 1).to(0, -1).foreach { i =>
      (0 until 26).foreach { j =>
        if (s(i).equals(('a' + j).toChar)) dp(i)(j) = i
        else dp(i)(j) = dp(i + 1)(j)
      }
    }
    var ans = -1
    dictionary.zipWithIndex.foreach { case (dict, idx) =>
      var j = 0
      var i = 0
      var isMatch = true
      while (i < dict.length && isMatch) {
        if (dp(j)(dict(i) - 'a') == s.length) {
          isMatch = false
        } else {
          j = dp(j)(dict(i) - 'a') + 1
        }
        i += 1
      }

      if (isMatch) {
        if (ans == -1) ans = idx
        else if (dictionary(ans).length < dictionary(idx).length || (dictionary(ans).length == dictionary(idx).length && dictionary(ans).compareTo(dictionary(idx)) > 0)) {
          ans = idx
        }
      }
    }
    if (ans != -1) dictionary(ans)
    else ""
  }
}