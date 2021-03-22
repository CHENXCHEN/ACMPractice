package leetcode.normal.n191

/**
  * https://leetcode-cn.com/problems/number-of-1-bits/
  * 191. 位1的个数
  */
object Solution {
  def hammingWeight(n: Int): Int = {
    var (cnt, rn) = (0, n)
    while (rn != 0) {
      rn &= (rn - 1)
      cnt += 1
    }
    cnt
  }

  def main(args: Array[String]): Unit = {
    Seq(1, 0, 3, -1).foreach {
      x =>
        println(s"$x: ${hammingWeight(x)}")
    }
  }
}
