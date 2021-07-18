package leetcode.normal.n2106

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/group-anagrams-lcci/
  * 面试题 10.02. 变位词组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.map { str =>
      (str, str.sorted)
    }.groupBy(_._2)
      .values
      .map { arr =>
        arr.map(_._1).toList
      }
      .toList
  }
}
