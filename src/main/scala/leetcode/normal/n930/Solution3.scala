package leetcode.normal.n930

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
  * 930. 和相同的二元子数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution3 {

  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    def atMostK(_k: Int): Int = {
      if (_k < 0) return 0
      var res = 0
      var i = 0
      var j = 0
      var k = _k
      while (i < nums.length) {
        k -= nums(i)
        while (k < 0) {
          k += nums(j)
          j += 1
        }
        res += i - j + 1
        i += 1
      }
      res
    }

    atMostK(goal) - atMostK(goal - 1)
  }

}
