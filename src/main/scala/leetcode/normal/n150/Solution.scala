package leetcode.normal.n150

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
  * 150. 逆波兰表达式求值
  */
object Solution {
  def calc(left: String, right: String, op: String): Long = {
    op match {
      case "+" => left.toLong + right.toLong
      case "-" => left.toLong - right.toLong
      case "*" => left.toLong * right.toLong
      case "/" => left.toLong / right.toLong
    }
  }

  def evalRPN(tokens: Array[String]): Int = {
    val opStr = Set("+", "-", "*", "/")
    val q = mutable.Stack[String](tokens.head)
    tokens.foreach {
      token =>
        if (opStr.contains(token)) {
          val right = q.pop()
          val left = q.pop()
          q.push(calc(left, right, token).toString)
        } else q.push(token)
    }
    q.pop().toInt
  }

  def main(args: Array[String]): Unit = {
    println(evalRPN(Array("2", "1", "+", "3", "*")))
    println(evalRPN(Array("4", "13", "5", "/", "+")))
    println(evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
  }
}
