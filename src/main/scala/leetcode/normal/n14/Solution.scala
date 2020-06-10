package leetcode.normal.n14

/**
  * 获得最长公共前缀
  *
  */
object Solution {

  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) {
      return ""
    }
    var pos = 0
    while (strs.forall(_.length > pos) && strs.forall(_ (pos) == strs.head(pos))) {
      pos += 1
    }
    strs.head.substring(0, pos)
  }

  def main(args: Array[String]): Unit = {
    Array(
      (Array("flower", "flow", "flight"), "fl")
      , (Array("dog", "racecar", "car"), "")
    ).foreach {
      case (x, ans) =>
        val rx = longestCommonPrefix(x)
        println("check ", x.toSeq, rx)
        assert(ans == rx)
    }
  }
}
