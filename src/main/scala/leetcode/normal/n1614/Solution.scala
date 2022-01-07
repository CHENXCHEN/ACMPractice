package leetcode.normal.n1614

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
  * 1614. 括号的最大嵌套深度
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxDepth(s: String): Int = {
    var cnt = 0
    var ans = 0
    s.foreach {
      case '(' =>
        cnt += 1
        ans = ans.max(cnt)
      case ')' =>
        cnt -= 1
      case _ =>
    }
    ans
  }
}