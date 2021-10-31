package leetcode.normal.n260

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/single-number-iii/
  * 260. 只出现一次的数字 III
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val twoXor = nums.foldLeft(0)((ans, num) => ans ^ num)
    val minBit = twoXor & -twoXor
    var num1 = 0
    var num2 = 0
    nums.foreach { num =>
      if ((num & minBit) != 0) {
        num1 ^= num
      } else {
        num2 ^= num
      }
    }
    Array(num1, num2)
  }
}