package leetcode.normal.n268

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/missing-number/
  * 268. 丢失的数字
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def missingNumber(nums: Array[Int]): Int = {
    nums.length * (nums.length + 1) / 2 - nums.sum
  }
}
