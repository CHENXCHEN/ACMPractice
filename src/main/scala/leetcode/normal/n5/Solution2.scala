package leetcode.normal.n5

/**
  * 给定一个字符串，计算最大回文子串
  * 解法：将字符串逆序后，原字符串和逆序字符串的最大公共子串，需要判断坐标是否相等，在原字符串中，起始坐标是否和 j的原始坐标相等
  *
  * 其它问题：将字符串逆序后，原字符串和逆序字符串的最大公共子串是回文串吗？
  *             -- 不是，如果将字符串逆序求最大公共子串，那么得到的结果是最大逆序子串
  *             -- aacdefcaa 例
  *          空间复杂度优化 O(n)
  *          时间复杂度优化 O(n + m) 广义后缀树
  */
object Solution2 {
  def longestPalindrome(s: String): String = {
    val rs = s.reverse
    val sWithIndex = s.zipWithIndex
    val rsWithIndex = rs.zipWithIndex
    val dps = Array.ofDim[Int](s.length, s.length)
    var ansCnt = 0
    var ansStart = 0
    sWithIndex.foreach {
      case (chi, i) =>
        rsWithIndex.foreach {
          case (chj, j) =>
            if (chi == chj) {
              if (i == 0 || j == 0) dps(i)(j) = 1
              else dps(i)(j) = dps(i - 1)(j - 1) + 1
              if (dps(i)(j) > ansCnt) {
                val preJ = s.length - 1 - j
                val preI = i - dps(i)(j) + 1
                if (preI == preJ) {
                  ansCnt = dps(i)(j)
                  ansStart = i - dps(i)(j) + 1
                }
              }
            }
            else dps(i)(j) = 0
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
