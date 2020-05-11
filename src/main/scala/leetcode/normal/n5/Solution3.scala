package leetcode.normal.n5

/**
  * 给定一个字符串，计算最大回文子串
  * 解法：Manacher
  *
  */
object Solution3 {
  def longestPalindrome(s: String): String = {
    if (s.isEmpty) return ""
    val str = s.mkString("#")
    var l = 0
    var r = -1
    val d = new Array[Int](str.length + 1)
    var ansStart = 0
    var ansCnt = 0
    str.zipWithIndex.foreach {
      case (_, i) =>
        var k = if (i >= r) 1 else Math.min(d(l + r - i), r - i)
        while (i - k >= 0 && i + k < str.length && str(i - k) == str(i + k)) k += 1
        k -= 1
        d(i) = k
        if (i + k > r) {
          l = i - k
          r = i + k
        }
        // 如果起始坐标是奇数，那么需要减去1，因为奇数是填充字符串
        if (k - (i - k) % 2 >= ansCnt) {
          ansCnt = k - (i - k) % 2
          ansStart = i
        }
    }
    str.zipWithIndex.filter {
      case (_, i) => i % 2 == 0 && i >= ansStart - ansCnt && i <= ansStart + ansCnt
    }.map(_._1).mkString
  }

  def main(args: Array[String]): Unit = {
    Array(
      ("babad", "aba")
      , ("cbbd", "bb")
      , ("ccd", "cc")
      , ("aaabaaaa", "aaabaaa")
      , ("aacdefcaa", "aa")
      , ("abb", "bb")
    ).foreach {
      case (ss, ans) =>
        val str = longestPalindrome(ss)
        println(ss, str)
        assert(str == ans)
    }
  }
}
