package leetcode.normal.n338

/**
  * https://leetcode-cn.com/problems/counting-bits/
  * 338. 比特位计数
  */
object Solution2 {
  def countBits(num: Int): Array[Int] = {
    val ret = Array.fill[Int](num + 1)(0)
    (1 to num).foreach {
      i => ret(i) = ret(i & (i - 1)) + 1
    }
    ret
  }

  def main(args: Array[String]): Unit = {
    println(countBits(2).toSeq)
  }
}