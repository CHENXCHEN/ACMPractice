package leetcode.normal.n852

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
  * 852. 山脉数组的峰顶索引
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    var l = 1
    var r = arr.length - 2
    var ans = 0
    while (l <= r) {
      val m = (l + r) >> 1
      if (arr(m) > arr(m + 1)) {
        ans = m
        r = m - 1
      } else l = m + 1
    }
    ans
  }
}