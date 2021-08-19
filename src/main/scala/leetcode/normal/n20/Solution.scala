package leetcode.normal.n20

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/valid-parentheses/
  * 20. 有效的括号
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isValid(s: String): Boolean = {
    val stack = mutable.Stack[Char]()
    val mapChar = Map(
      ')' -> '(',
      ']' -> '[',
      '}' -> '{'
    )
    var pos = 0
    while (pos < s.length) {
      val ch = s(pos)
      if (mapChar.valuesIterator.contains(ch)) {
        stack.push(ch)
      } else {
        if (stack.isEmpty || mapChar(ch) != stack.pop()) {
          return false
        }
      }
      pos += 1
    }
    stack.isEmpty
  }
}
