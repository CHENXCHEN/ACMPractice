package leetcode.normal.n1190

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
  * 1190. 反转每对括号间的子串
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def reverseParentheses(s: String): String = {
    val ans = (0 until s.length).toArray
    val stack = mutable.Stack[Int]()
    s.indices.foreach { i =>
      if (s(i) == '(') {
        stack.push(i)
      } else if (s(i) == ')') {
        var start = stack.pop()
        var end = i
        while (start <= end) {
          val tmp = ans(end)
          ans(end) = ans(start)
          ans(start) = tmp
          start += 1
          end -= 1
        }
      }
    }
    ans.filter(i => s(i) != '(' && s(i) != ')').map(s(_)).mkString
  }
}
