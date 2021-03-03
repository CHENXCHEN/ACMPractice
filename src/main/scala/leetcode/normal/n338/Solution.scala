package leetcode.normal.n338

/**
  * https://leetcode-cn.com/problems/counting-bits/
  * 338. 比特位计数
  */
object Solution {
  def countBits(num: Int): Array[Int] = {
    (0 to num).map {
      i =>
        var ret = 0
        var ri = i
        while (ri > 0) {
          ri = ri & (ri - 1)
          ret += 1
        }
        ret
    }.toArray
  }
}