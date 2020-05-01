package leetcode.normal.n3

/**
  * 获得最长不重复子串的长度
  */
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var ans = 0
    var checkNum = 0
    var lastCheckPosition = -1
    s.zipWithIndex.foreach {
      case (char: Char, i) =>
        val pos = s.indexOf(char, lastCheckPosition)
        if (pos < i) {
          ans = Math.max(ans, checkNum)
          checkNum = i - pos - 1
          lastCheckPosition = pos + 1
        }
        checkNum += 1
//        println(char, checkNum, lastCheckPosition)
    }
    //    var map = Map.empty[Char, Int]
    //    s.zipWithIndex.foreach {
    //      case (char, i) =>
    //        if (!map.contains(char)) map += char -> -1
    //        if (map(char) == -1) {
    //          checkNum += 1
    //        } else {
    //          ans = Math.max(ans, checkNum)
    //          lastCheckPosition = Math.max(lastCheckPosition, map(char))
    //          checkNum = i - Math.max(lastCheckPosition, map(char))
    //        }
    //        map += char -> i
    //        println(char, checkNum, lastCheckPosition, map)
    //    }
    Math.max(ans, Math.min(checkNum, s.length))
  }

  def main(args: Array[String]): Unit = {
    Array(
      "abcabcbb"
      , "bbbbb"
      , "pwwkew"
      , ""
      , " "
      , "dvdf"
      , "abba"
      , "abbcadaba"
      , "biidygcc"
      , "wobgrovw"
      , "zwnigfunjwz"
    ).foreach {
      str =>
        println(str)
        println(lengthOfLongestSubstring(str))
    }
  }
}

