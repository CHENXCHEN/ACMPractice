package leetcode.normal.n1239

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
  * 1239. 串联字符串的最大长度
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxLength(arr: List[String]): Int = {
    var ans = 0
    val validHash = Array.fill(arr.length)(false)
    val arrCompress = arr.indices.map { i =>
      val str = arr(i)
      var ret = 0
      validHash(i) = str.forall { ch =>
        val now = 1 << (ch - 'a')
        if ((now & ret) == 0) {
          ret |= now
          true
        } else false
      }
      ret
    }

    def findMax(cur: Int, mark: Int, len: Int): Unit = {
      ans = ans.max(len)
      (cur + 1).until(arrCompress.length).foreach { i =>
        if (validHash(i) && (mark & arrCompress(i)) == 0) {
          findMax(i, mark | arrCompress(i), len + arr(i).length)
        }
      }
    }

    findMax(-1, 0, 0)

    ans
  }
}
