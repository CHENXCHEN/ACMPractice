package leetcode.normal.n363

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
  * 363. 矩形区域不超过 K 的最大数值和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    var ans = Option.empty[Int]
    matrix.indices.foreach { i => // 枚举上边界
      val colSum = Array.fill(matrix(i).length)(0)
      (i until matrix.length).foreach { d => // 枚举下边界
        // 计算边界内的前缀和
        matrix.head.indices.foreach {
          j => colSum(j) += matrix(d)(j)
        }
        val tSet = mutable.TreeSet[Int](0)
        // 通过枚举前缀和 sr，找出 sl
        var ss = 0
        colSum.foreach {
          colS =>
            ss += colS
            // sr - sl <= k  ->  sr - k <= sl
            val subSet = tSet.rangeImpl(Some(ss - k), None)
            if (subSet.nonEmpty) {
              ans = ans.map(_.max(ss - subSet.head))
                .orElse(Some(ss - subSet.head))
            }
            tSet.add(ss)
        }
      }
    }
    ans.get
  }

  def main(args: Array[String]): Unit = {
    println(maxSumSubmatrix(Array(Array(1, 0, 1), Array(0, -2, 3)), 2))
    println(maxSumSubmatrix(Array(Array(2, 2, -1)), 3))
    println(maxSumSubmatrix(Array(Array(2, 2, -1)), 0))
  }
}
