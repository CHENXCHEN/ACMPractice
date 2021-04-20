package leetcode.normal.n28

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/implement-strstr/
  * 28. 实现 strStr()
  * kmp 算法实现
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def strStr(haystack: String, needle: String): Int = {
    if (needle.length == 0) return 0
    val next = Array.fill(needle.length + 1)(0)
    next(0) = -1
    var (i, j) = (0, -1)
    while (i < needle.length) {
      if (j == -1 || needle(i) == needle(j)) {
        j += 1
        i += 1
        next(i) = j
      }
      else
        while (j != -1 && needle(i) != needle(j)) j = next(j)
    }
    i = 0
    j = 0
    while (i < haystack.length) {
      if (j == -1 || haystack(i) == needle(j)) {
        j += 1
        i += 1
      } else
        while (j != -1 && haystack(i) != needle(j)) j = next(j)
      if (j == needle.length) {
        return i - j
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(strStr("hello", "ll"))
    println(strStr("", ""))
    println(strStr("aaaaa", "bba"))
    println(strStr("mississippi", "mississippi"))
    println(strStr("mississippi", "issip"))
  }
}
