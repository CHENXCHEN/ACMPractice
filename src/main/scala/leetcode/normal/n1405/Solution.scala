package leetcode.normal.n1405

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/longest-happy-string/
  * 1405. 最长快乐字符串
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def longestDiverseString(a: Int, b: Int, c: Int): String = {
    val sb = new StringBuilder
    var cntArr = Array((a, 'a'), (b, 'b'), (c, 'c'))
    var isFinish = false
    while (!isFinish) {
      var hasNext = false
      cntArr = cntArr.sortBy(_._1).reverse
      val len = sb.length
      (0 until 3).find { i =>
        val (cnt, ch) = cntArr(i)
        cnt > 0 && !(len >= 2 && sb.charAt(len - 2) == ch && sb.charAt(len - 1) == ch)
      }.foreach { i =>
        val (cnt, ch) = cntArr(i)
        cntArr(i) = (cnt - 1, ch)
        hasNext = true
        sb.append(ch)
      }
      if (!hasNext) isFinish = true
    }
    sb.toString()
  }
}