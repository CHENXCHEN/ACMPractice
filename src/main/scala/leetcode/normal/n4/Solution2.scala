package leetcode.normal.n4

object Solution2 {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val len = nums1.length + nums2.length
    val first = findKth(nums1, -1, nums2, -1, (len + 1) / 2)
    //    println("----")
    val second = findKth(nums1, -1, nums2, -1, (len + 2) / 2)
    //    println("ans:", first, second, (len + 1) / 2, (len + 2) / 2)
    (first + second) / 2.0
  }

  @scala.annotation.tailrec
  def findKth(nums1: Array[Int], i: Int, nums2: Array[Int], j: Int, k: Int): Int = {
    //    println("in findKth", i, j, k)
    if (nums1.isEmpty || nums1.length - 1 <= i) nums2(j + k)
    else if (nums2.isEmpty || nums2.length - 1 <= j) nums1(i + k)
    else if (k == 1) Math.min(nums1(i + k), nums2(j + k))
    else {
      val midK = k / 2
      val endI = Math.min(nums1.length - 1, i + midK)
      val endJ = Math.min(nums2.length - 1, j + midK)
      if (nums1(endI) > nums2(endJ)) findKth(nums1, i, nums2, endJ, k - (endJ - j))
      else findKth(nums1, endI, nums2, j, k - (endI - i))
    }
  }

  def main(args: Array[String]): Unit = {
    Array(
      (Array(1, 3), Array(2), 2.0)
      , (Array(1, 2), Array(3, 4), 2.5)
      , (Array(1, 3), Array(2, 4), 2.5)
      , (Array(1, 2), Array(2, 4), 2)
      , (Array(2, 2), Array(2, 2), 2)
      , (Array(2, 2), Array(4, 5), 3)
      , (Array(2, 2), Array(2, 5), 2)
      , (Array(1), Array(2, 5), 2)
      , (Array(1), Array(2), 1.5)
      , (Array(1), Array.emptyIntArray, 1)
      , (Array(1, 2), Array(1, 2), 1.5)
      , (Array(10), Array(9999), 5004.5)
      , (Array(1), Array(2, 3, 4), 2.5)
      , (Array(2), Array(1, 3, 4), 2.5)
      , (Array(1), Array(2, 3, 4, 5, 6), 3.5)
    ).foreach {
      case (nums1, nums2, ans) =>
        println("nums: ", nums1.toSeq, nums2.toSeq)
        val ret = findMedianSortedArrays(nums1, nums2)
        println(ret)
        assert(ret == ans)
    }
  }
}
