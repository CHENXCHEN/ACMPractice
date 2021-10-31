package leetcode.normal.n500

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/keyboard-row/
  * 500. 键盘行
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  val rows: Seq[Int] = Seq("qwertyuiop", "asdfghjkl", "zxcvbnm").map(getBitMap)

  def getBitMap(str: String): Int = {
    str.foldLeft(0)((ans, ch) => ans | (1 << (ch.toLower - 'a')))
  }

  def isContains(res: Int): Boolean = {
    rows.exists(row => (row & res) == res)
  }

  def findWords(words: Array[String]): Array[String] = {
    words.filter(word => isContains(getBitMap(word)))
  }

  def main(args: Array[String]): Unit = {
    print(rows)
  }
}
