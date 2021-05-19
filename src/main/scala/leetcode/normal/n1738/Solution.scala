package leetcode.normal.n1738

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
  * 1738. 找出第 K 大的异或坐标值
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def kthLargestValue(matrix: Array[Array[Int]], k: Int): Int = {
    val preXorSum = Array.fill(matrix.length + 1)(Array.fill(matrix.head.length + 1)(0))
    // (i,j) = (i-1,j) ^ (i,j-1) ^ (i-1,j-1) ^ m(i,j)
    // (i+1,j+1) = (i,j+1) ^ (i+1, j) ^ (i,j) ^ m(i+1,j+1)
    matrix.indices.flatMap { i =>
      matrix.head.indices.map { j =>
        preXorSum(i + 1)(j + 1) = preXorSum(i)(j + 1) ^ preXorSum(i + 1)(j) ^ preXorSum(i)(j) ^ matrix(i)(j)
        preXorSum(i + 1)(j + 1)
      }
    }.sorted.reverse(k - 1)
  }
}
