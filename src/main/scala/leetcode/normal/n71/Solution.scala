package leetcode.normal.n71

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/simplify-path/
  * 71. 简化路径
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def simplifyPath(path: String): String = {
    val stack = mutable.Stack[String]()
    stack.push("")
    var i = 1
    while (i < path.length) {
      val j = path.indexOf('/', i)
      val end = if (j == -1) path.length else j
      if (end - i > 0) {
        val sub = path.substring(i, end)
        sub match {
          case "." =>
          case ".." =>
            if (stack.length > 1) stack.pop()
          case _ => stack.push(sub)
        }
      }
      i = end + 1
    }
    if (stack.length == 1) "/"
    else stack.reverse.mkString("/")
  }
}