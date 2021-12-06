package leetcode.normal.n1816

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/truncate-sentence/
  * 1816. 截断句子
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def truncateSentence(s: String, k: Int): String = {
    var cnt = 0
    s.takeWhile {
      case ' ' => cnt += 1
        cnt < k
      case _ => true
    }
  }
}
