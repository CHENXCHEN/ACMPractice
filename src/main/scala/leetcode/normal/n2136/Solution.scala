package leetcode.normal.n2136

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/find-majority-element-lcci/
  * 面试题 17.10. 主要元素
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    var cnt = 0
    var mostNum = 0
    nums.foreach { num =>
      if (cnt == 0) mostNum = num
      if (mostNum == num) cnt += 1
      else cnt -= 1
    }

    val mostCnt = nums.count(_ == mostNum)
    if (mostCnt * 2 > nums.length) mostNum
    else -1
  }
}
