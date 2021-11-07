package leetcode.normal.n598

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/range-addition-ii/
  * 598. 范围求和 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    if (ops.isEmpty) m * n
    else ops.map(_.head).min * ops.map(_.last).min
  }
}

