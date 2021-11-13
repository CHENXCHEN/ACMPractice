package leetcode.normal.n520

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/detect-capital/
  * 520. 检测大写字母
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def detectCapitalUse(word: String): Boolean = {
    val upperCnt = word.filter(_.isUpper).length
    val lowerCnt = word.length - upperCnt
    word.length == upperCnt || word.length == lowerCnt || (word.head.isUpper && lowerCnt == word.length - 1)
  }
}
