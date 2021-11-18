package leetcode.normal.n318

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
  * 318. 最大单词长度乘积
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxProduct(words: Array[String]): Int = {
    val wordBitMap = words.map { word =>
      var bitMap = 0
      word.foreach(ch => bitMap |= (1 << (ch - 'a')))
      bitMap
    }
    val len = words.length
    var ans = 0
    (0 until len).foreach { i =>
      (i + 1 until len).foreach { j =>
        if ((wordBitMap(i) & wordBitMap(j)) == 0) {
          ans = ans.max(words(i).length * words(j).length)
        }
      }
    }
    ans
  }
}
