package leetcode.normal.n1734

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/decode-xored-permutation/
  * 1734. 解码异或后的排列
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def decode(encoded: Array[Int]): Array[Int] = {
    val n = encoded.length + 1
    var tot = 0
    (1 to n).foreach(i => tot ^= i)
    var odd = 0
    (1 until(encoded.length, 2)).foreach {
      i => odd ^= encoded(i)
    }
    val perms = Array.fill(n)(0)
    perms(0) = tot ^ odd
    encoded.zipWithIndex.foreach {
      case (vv, i) =>
        perms(i + 1) = vv ^ perms(i)
    }
    perms
  }
}
