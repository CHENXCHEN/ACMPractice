package leetcode.normal.n477

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/total-hamming-distance/
  * 477. 汉明距离总和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def totalHammingDistance(nums: Array[Int]): Int = {
    val bitCnt = Array.fill(32)(Array.fill(2)(0))
    nums.foreach { num =>
      (0 until 32).foreach { pos =>
        bitCnt(pos)((num >> pos) & 1) += 1
      }
    }
    bitCnt.map { bitZeroOne =>
      bitZeroOne.head * bitZeroOne.last
    }.sum
  }
}