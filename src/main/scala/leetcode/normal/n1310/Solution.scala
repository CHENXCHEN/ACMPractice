package leetcode.normal.n1310

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
  * 1310. 子数组异或查询
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def xorQueries(arr: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val preSum = Array.fill(arr.length + 1)(0)
    (1 to arr.length).foreach {
      i => preSum(i) = preSum(i - 1) ^ arr(i - 1)
    }
    queries.map {
      query =>
        val (left, right) = (query.head, query.last)
        preSum(right + 1) ^ preSum(left)
    }
  }
}
