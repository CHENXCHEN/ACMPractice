package leetcode.normal.n1720

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/decode-xored-array/
  * 1720. 解码异或后的数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def decode(encoded: Array[Int], first: Int): Array[Int] = {
    var lastNum = first
    first +: encoded.map {
      encodeNum =>
        lastNum = encodeNum ^ lastNum
        lastNum
    }
  }
}
