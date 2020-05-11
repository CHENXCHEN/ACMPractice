package leetcode.normal.n6

/**
  * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
  * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串
  * LEETCODEISHIRING 3
  * LCIRETOESIIGEDHN
  *
  * LEETCODEISHIRING 4
  * LDREOEIIECIHNTSG
  */
object Solution {
  def convert(s: String, numRows: Int): String = {
    var i = 0
    val arr = new Array[(Char, Int, Int)](s.length)
    var x = -1
    var y = 0
    while (i < s.length) {
      x = -1
      var r = numRows
      while (i < s.length && r > 0) {
        x += 1
        r -= 1
        arr(i) = (s(i), x, y)
        i += 1
      }
      var k = numRows - 2
      while (i < s.length && k > 0) {
        y += 1
        x -= 1
        k -= 1
        arr(i) = (s(i), x, y)
        i += 1
      }
    }
    //    println(arr.toSeq)
    //    println(arr.sortBy(_._2).toSeq)
    arr.sortBy(_._2)
      .map(_._1)
      .mkString
  }

  def main(args: Array[String]): Unit = {
    Array(
      ("LEETCODEISHIRING", 3, "LCIRETOESIIGEDHN")
      , ("LEETCODEISHIRING", 4, "LDREOEIIECIHNTSG")
    ).foreach {
      case (s, numRows, ans) =>
        val ret = convert(s, numRows)
        println(s, numRows, ret)
        assert(ret == ans)
    }
  }

}
