package leetcode.normal.n87

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/scramble-string/
  * 87. 扰乱字符串
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isScramble(s1: String, s2: String): Boolean = {
    // 0 -> 未计算, 1 -> 正确, -1 -> 错误
    val result: Array[Array[Array[Int]]] = Array.fill(31)(Array.fill(31)(Array.fill(31)(0)))

    def checkSimilar(i1: Int, i2: Int, len: Int): Boolean = {
      val arr1 = Array.fill(26)(0)
      (0 until len).foreach {
        i =>
          arr1(s1(i1 + i) - 'a') += 1
          arr1(s2(i2 + i) - 'a') -= 1
      }
      (0 until 26).forall(i => arr1(i) == 0)
    }

    def dfs(i1: Int, i2: Int, len: Int): Boolean = {
      // 判断是否计算过
      if (result(i1)(i2)(len) != 0) {
        return result(i1)(i2)(len) == 1
      }

      // 判断子串是否相等
      if (s1.substring(i1, i1 + len) == s2.substring(i2, i2 + len)) {
        result(i1)(i2)(len) = 1
        return true
      }

      // 判断字符出现次数是否正确
      if (!checkSimilar(i1, i2, len)) {
        result(i1)(i2)(len) = -1
        return false
      }

      (1 until len).foreach {
        i =>
          if (
          // 不交换
            (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, len - i)) ||
              // 交换
              (dfs(i1, i2 + len - i, i) && dfs(i1 + i, i2, len - i))
          ) {
            result(i1)(i2)(len) = 1
            return true
          }
      }

      result(i1)(i2)(len) = -1
      false
    }

    dfs(0, 0, s1.length)
  }
}
