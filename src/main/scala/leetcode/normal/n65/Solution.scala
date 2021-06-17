package leetcode.normal.n65

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/valid-number/
  * 65. 有效数字
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isNumber(s: String): Boolean = {

    def isAllDigit(start: Int, end: Int): Boolean = {
      (start until end).forall(i => s(i).isDigit)
    }

    def checkIfDigit(start: Int, end: Int, canEmpty: Boolean = true, canWithPrefix: Boolean = false): Boolean = {
      val isPrefix = start < end && (s(start) == '+' || s(start) == '-')
      if (canEmpty && canWithPrefix) {
        if (isPrefix) end - start > 1 && isAllDigit(start + 1, end)
        else isAllDigit(start, end)
      } else if (canEmpty && !canWithPrefix) {
        if (isPrefix) false
        else isAllDigit(start, end)
      } else if (!canEmpty && canWithPrefix) {
        if (isPrefix) end - start > 1 && isAllDigit(start + 1, end)
        else end - start > 0 && isAllDigit(start, end)
      } else {
        if (isPrefix) false
        else end - start > 0 && isAllDigit(start, end)
      }
    }

    def isFloatNumber(s: String): Boolean = {
      if (s.isEmpty) return false
      val start =
        if (s.head == '+' || s.head == '-') 1
        else 0

      val dotPos = s.indexOf(".")
      if (dotPos == -1) checkIfDigit(start, s.length, canEmpty = false)
      else {
        if (dotPos == start) checkIfDigit(start + 1, s.length, canEmpty = false)
        else checkIfDigit(start, dotPos, canEmpty = false) && checkIfDigit(dotPos + 1, s.length)
      }
    }

    val ePos = s.toLowerCase().indexOf("e")

    if (ePos != -1) isFloatNumber(s.substring(0, ePos)) && checkIfDigit(ePos + 1, s.length, canEmpty = false, canWithPrefix = true)
    else isFloatNumber(s)
  }
}