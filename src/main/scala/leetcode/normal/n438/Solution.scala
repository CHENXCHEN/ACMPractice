package leetcode.normal.n438

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
  * 438. 找到字符串中所有字母异位词
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    var ans = List.empty[Int]
    var pos = 0
    val vis = Array.fill(26)(0)
    val pVis = Array.fill(26)(0)
    p.foreach { ch =>
      pVis(ch - 'a') += 1
    }
    val n = p.length

    def compareVis(): Boolean = {
      (0 until 26).forall { i =>
        vis(i) == pVis(i)
      }
    }

    while (pos < s.length) {
      vis(s.charAt(pos) - 'a') += 1
      if (pos >= n - 1) {
        if (compareVis()) {
          ans :+= pos - (n - 1)
        }
        vis(s.charAt(pos - (n - 1)) - 'a') -= 1
      }
      pos += 1
    }
    ans
  }
}
