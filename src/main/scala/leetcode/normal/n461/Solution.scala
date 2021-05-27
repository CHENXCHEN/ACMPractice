package leetcode.normal.n461

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/hamming-distance/
  * 461. 汉明距离
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def hammingDistance(x: Int, y: Int): Int = {
    var z = x ^ y
    var cnt = 0;
    while (z > 0) {
      cnt += 1
      z = z & (z - 1)
    }
    cnt
  }
}
