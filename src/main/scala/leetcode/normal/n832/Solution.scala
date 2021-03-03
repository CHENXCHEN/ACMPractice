package leetcode.normal.n832

/**
  * https://leetcode-cn.com/problems/flipping-an-image/
  * 832. 翻转图像
  */
object Solution {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
    A.map {
      arr =>
        arr.map(x => (x + 1) % 2).reverse
    }
  }
}
