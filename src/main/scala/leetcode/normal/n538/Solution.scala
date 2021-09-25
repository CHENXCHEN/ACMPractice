package leetcode.normal.n538

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
  * 583. 两个字符串的删除操作
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minDistance(word1: String, word2: String): Int = {
    val dp = Array.fill(word1.length + 1, word2.length + 1)(0)
    // dp(i)(j) -> word1 前缀长度为 i 的子串 和 word2 前缀长度为 j 的子串的最大公共子串长度
    (1 to word1.length).foreach { i =>
      (1 to word2.length).foreach { j =>
        // 如果匹配
        if (word1(i - 1) == word2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1) + 1
        // 如果不匹配
        dp(i)(j) = dp(i)(j) max dp(i)(j - 1) max dp(i - 1)(j)
      }
    }
    val commLen = dp(word1.length)(word2.length)
    word1.length - commLen + word2.length - commLen
  }

  def main(args: Array[String]): Unit = {
    println(minDistance("leetcode", "etco"))
  }
}
