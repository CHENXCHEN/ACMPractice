package leetcode.normal.n88

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/merge-sorted-array/
  * 88. 合并两个有序数组
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var (pos1, pos2) = (0, 0)
    val ans = Array.fill[Int](n + m)(0)
    var ansPos = 0
    while (pos1 < m && pos2 < n) {
      if (nums1(pos1) <= nums2(pos2)) {
        ans(ansPos) = nums1(pos1)
        ansPos += 1
        pos1 += 1
      } else {
        ans(ansPos) = nums2(pos2)
        ansPos += 1
        pos2 += 1
      }
    }
    while (pos1 < m) {
      ans(ansPos) = nums1(pos1)
      ansPos += 1
      pos1 += 1
    }
    while(pos2 < n) {
      ans(ansPos) = nums2(pos2)
      ansPos += 1
      pos2 += 1
    }
    ans.copyToArray(nums1)
  }
}
