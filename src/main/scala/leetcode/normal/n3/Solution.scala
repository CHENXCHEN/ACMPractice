package leetcode.normal.n3

/**
  * 获得最长不重复子串的长度
  * 解法1: 遍历每个元素时找到该元素在字符串中最后出现的位置，然后重新计算长度，记录最后位置，每次从最后位置开始找元素最后出现的位置
  * 解法2：每个元素最后出现的位置可以通过 hash 记录
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

