package leetcode.normal.n2017

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
  * 剑指 Offer 42. 连续子数组的最大和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    var ans = nums.head
    var ss = 0
    nums.foreach { num =>
      ans = ans max num
      ss += num
      if (ss <= 0) ss = 0
      else {
        ans = ans max ss
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
  }
}
