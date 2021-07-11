package leetcode.normal.n930

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
  * 930. 和相同的二元子数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {

  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    var ans = 0
    var left1 = 0
    var left2 = 0
    var right = 0
    var s1 = 0
    var s2 = 0
    while (right < nums.length) {
      s1 += nums(right)
      while (left1 <= right && s1 > goal) {
        s1 -= nums(left1)
        left1 += 1
      }
      s2 += nums(right)
      while (left2 <= right && s2 >= goal) {
        s2 -= nums(left2)
        left2 += 1
      }
      ans += left2 - left1

      right += 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
//    println(numSubarraysWithSum(Array(1, 0, 1, 0, 1), 2))
    println(numSubarraysWithSum(Array(0, 0, 0, 0, 0), 0))
  }
}
