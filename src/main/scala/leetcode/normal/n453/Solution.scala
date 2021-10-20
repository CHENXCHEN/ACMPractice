package leetcode.normal.n453

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
  * 453. 最小操作次数使数组元素相等
  * 因为有 n - 1 个元素 +1，那么可以看成只有 1 个元素 -1
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minMoves(nums: Array[Int]): Int = {
    val min = nums.min
    nums.map(n => n - min).sum
  }
}