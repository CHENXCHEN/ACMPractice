package leetcode.normal.n68

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/text-justification/
  * 68. 文本左右对齐
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    var i = 0
    val ans = mutable.ListBuffer.empty[String]
    while (i < words.length) {
      var j = i
      var len = 0
      var check = true
      while (check) {
        if (j < words.length && len + words(j).length + j - i <= maxWidth) {
          len += words(j).length
          j += 1
        } else check = false
      }
      if (j != words.length) ans.append(formatStr(words.slice(i, j), maxWidth - len))
      else ans.append(words.slice(i, j).mkString(" ").padTo(maxWidth, ' '))
      i = j
    }
    ans.toList
  }

  def formatStr(words: Array[String], space: Int): String = {
    if (words.length == 1) return words.head.padTo(space + words.head.length, ' ')
    var firstAdd = space % (words.length - 1)
    val perSpace = space / (words.length - 1)
    val str1 = words.zipWithIndex.map {
      case (str, i) =>
        if (firstAdd > 0) {
          firstAdd -= 1
          s"$str".padTo(str.length + 1, ' ')
        } else str
    }.mkString("".padTo(perSpace, ' '))
    str1
  }

  def main(args: Array[String]): Unit = {
    val strings = fullJustify(Array("This", "is", "an", "example", "of", "text", "justification."), 16)
    strings.foreach(x => println(s""""$x""""))
  }
}