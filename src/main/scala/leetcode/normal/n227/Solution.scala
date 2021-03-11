package leetcode.normal.n227

/**
  * https://leetcode-cn.com/problems/basic-calculator-ii/
  * 227. 基本计算器 II
  */
object Solution {

  def readInt(s: String, start: Int): Int = {
    var i = start
    while (i < s.length && s(i).isDigit) {
      i += 1
    }
    i
  }

  def processMulDiv(s: String, start: Int, end: Int): Long = {
    var i = start
    var ans = Option(0L)
    var lastOp = Option.empty[Char]
    while (i < end) {
      if (s(i).isDigit) {
        val nPos = readInt(s, i)
        val now = s.substring(i, nPos).toLong
        if (lastOp.isEmpty) ans = Some(now)
        else if (lastOp.contains('*')) ans = ans.map(_ * now)
        else if (lastOp.contains('/')) ans = ans.map(_ / now)
        i = nPos
      } else {
        lastOp = Some(s(i))
        i += 1
      }
    }
    ans.get
  }

  def findMulDivPos(s: String, start: Int): Int = {
    var i = start
    while (i < s.length && (s(i).isDigit || s(i) == '*' || s(i) == '/')) {
      i += 1
    }
    i
  }

  def getNumFromLastOp(lastOp: Option[Char], num: Long): Long = {
    lastOp match {
      case Some('+') => num
      case Some('-') => -num
      case _ => num
    }
  }

  def calculate(s: String): Int = {
    val str = s.filter(_ != ' ')
    var i = 0
    var ans = 0L
    var lastOp = Option.empty[Char]
    while (i < str.length) {
      if (str(i).isDigit) {
        val mulDivPos = findMulDivPos(str, i)
        val mulDiv = processMulDiv(str, i, mulDivPos)
        ans += getNumFromLastOp(lastOp, mulDiv)
        i = mulDivPos
      } else {
        lastOp = Some(str(i))
        i += 1
      }
    }
    ans.toInt
  }

  def main(args: Array[String]): Unit = {
    val input = Seq(
      "3+2* 2"
      , "3/2"
      , " 3+5 / 2 "
    )
    input.foreach {
      s => println(s, calculate(s))
    }
  }
}
