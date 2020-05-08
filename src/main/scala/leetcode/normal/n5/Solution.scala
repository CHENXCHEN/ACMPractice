package leetcode.normal.n5

/**
  * 给定一个字符串，计算最大回文子串
  * 做法：给字符串加入分割符 # 用来统一回文串奇数或者偶数的解法，然后枚举字符串，以每个下标i计算最大回文串，
  *       假定 s(i - k) = s(i + k)，且 s(i - k - 1) != s(i + k + 1)
  *       这里需要额外讨论 当 i 为奇数或者偶数时候，真实的回文串长度是多少
  *       当 i - k 为奇数或者偶数的时候，真实的回文串起始长度是多少
  * 其它问题：将字符串逆序后，原字符串和逆序字符串的最大公共子串是回文串吗？
  *             -- 不是，如果将字符串逆序求最大公共子串，那么得到的结果是最大逆序子串
  */
object Solution {
  def longestPalindrome(s: String): String = {
    if (s.isEmpty) return ""
    val str = s.mkString("#")
    var ansCnt = 1
    var ansStart = 0
    str.zipWithIndex.foreach {
      case (_, i) =>
        var k = 0
        while (i - k >= 0 && i + k < str.length && str(i - k) == str(i + k)) k += 1
        k -= 1
//        println("here", i, k, str)
        // 计算当 i 为偶数奇数的时候，回文串长度为多少
        // 计算当 i 为偶数奇数的时候，回文串开始的坐标
        val (realK, startI) =
          if (i % 2 == 0) {
            (k / 2 * 2 + 1, (i - k + (i - k) % 2) / 2)
          } else {
            ((k + 1) / 2 * 2, (i - k + (i - k) % 2) / 2)
          }
        if (realK > ansCnt) {
//          println(s"realK $realK startI $startI")
          ansCnt = realK
          ansStart = startI
        }
    }
    s.substring(ansStart, ansStart + ansCnt)
  }

  def main(args: Array[String]): Unit = {
    Array(
      ("babad", "bab")
      , ("cbbd", "bb")
      , ("ccd", "cc")
      , ("aaabaaaa", "aaabaaa")
      , ("aacdefcaa", "aa")
    ).foreach {
      case (ss, ans) =>
        val str = longestPalindrome(ss)
        println(ss, str)
        assert(str == ans)
    }
  }
}
