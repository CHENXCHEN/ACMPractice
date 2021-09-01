package leetcode.normal.n165

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/compare-version-numbers/
  * 165. 比较版本号
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def compareVersion(version1: String, version2: String): Int = {
    val versions1 = version1.split("\\.").map(_.toInt)
    val versions2 = version2.split("\\.").map(_.toInt)
    val maxLen = versions1.length.max(versions2.length)
    val v1 = versions1 ++ Array.fill(maxLen - versions1.length)(0)
    val v2 = versions2 ++ Array.fill(maxLen - versions2.length)(0)
    var i = 0
    while (i < maxLen) {
      if (v1(i) > v2(i)) return 1
      else if (v1(i) < v2(i)) return -1
      i += 1
    }
    0
  }
}
