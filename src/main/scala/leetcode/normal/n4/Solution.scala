package leetcode.normal.n4

object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var leftValue =
      if (nums1.nonEmpty && nums2.nonEmpty) Math.min(nums1.head, nums2.head)
      else if (nums1.nonEmpty) nums1.head
      else nums2.head
    var rightValue =
      if (nums1.nonEmpty && nums2.nonEmpty) Math.max(nums1.last, nums2.last)
      else if (nums1.nonEmpty) nums1.last
      else nums2.last
    val len = nums1.length + nums2.length
    val isOdd = len % 2 == 1
    var ans = Array.emptyIntArray
    var lastAns = -1
    var lastAnsCheck = false
    var hSet = Array.empty[Int]
    while (leftValue <= rightValue) {
      val midValue = (leftValue + rightValue) >> 1
      val valuePos1 = arrBinarySearch(nums1, 0, nums1.length - 1, midValue)
      val valuePos2 = arrBinarySearch(nums2, 0, nums2.length - 1, midValue)

      val (ret, mVal, inArrPos) = compareMid((nums1, nums2), (valuePos1, valuePos2), midValue)

//      println(s"check here leftValue: $leftValue rightValue: $rightValue midValue: $midValue valuePos1: $valuePos1 valuePos2: $valuePos2 inArrPos: $inArrPos ret: $ret mVal: $mVal")
      if (ret == 0) {
        if (isOdd) return mVal
        else {
          if (!hSet.contains(inArrPos)) {
            ans :+= mVal
            hSet :+= inArrPos
          }
          if (inArrPos == len / 2 - 1) leftValue = midValue + 1
          else rightValue = midValue - 1
        }
      } else if (ret < 0) {
        lastAns = mVal
        leftValue = midValue + 1
        lastAnsCheck = true
      } else rightValue = midValue - 1
    }
//    println("here check", ans.toSeq, lastAns)
    if (ans.length == 2) (ans.head + ans.last) / 2.0
    else if (ans.nonEmpty) {
      if (lastAnsCheck) (ans.head + lastAns) / 2.0
      else ans.head
    } else lastAns
  }

  def compareMid(nums: (Array[Int], Array[Int]), pos: (Int, Int), midVal: Int): (Int, Int, Int) = {
    val (nums1, nums2) = nums
    val (pos1, pos2) = pos
    val len = nums1.length + nums2.length
    val isOdd = len % 2 == 1
    // 最小那个元素的位置在整个数组中的位置和最小值
    val (inArrPos, minVal) = getPosInArr(nums, pos, midVal)

    //    println(s"check in compare: inArrPos: $inArrPos")

    if (isOdd) {
      if (inArrPos == len / 2) (0, minVal, inArrPos)
      else if (inArrPos < len / 2) (-1, minVal, inArrPos)
      else (1, minVal, inArrPos)
    } else {
      if (inArrPos == len / 2 || inArrPos == len / 2 - 1) (0, minVal, inArrPos)
      else if (inArrPos < len / 2) (-1, minVal, inArrPos)
      else (1, minVal, inArrPos)
    }
  }

  @scala.annotation.tailrec
  def getPosInArr(nums: (Array[Int], Array[Int]), pos: (Int, Int), midVal: Int): (Int, Int) = {
    val (nums1, nums2) = nums
    val (pos1, pos2) = pos
    var inArrPos = 0
    var checkIfMin = false
    var minVal = Int.MaxValue
    if (nums1.nonEmpty) {
      if (nums1.head <= midVal && midVal <= nums1.last) {
        if (!checkIfMin) minVal = nums1(pos1)
        checkIfMin = true
        minVal = Math.min(nums1(pos1), minVal)
        inArrPos += pos1
      } else if (midVal > nums1.last) inArrPos += nums1.length
    }

    if (nums2.nonEmpty) {
      if (nums2.head <= midVal && midVal <= nums2.last) {
        if (!checkIfMin) minVal = nums2(pos2)
        checkIfMin = true
        minVal = Math.min(nums2(pos2), minVal)
        inArrPos += pos2
      } else if (midVal > nums2.last) inArrPos += nums2.length
    }

    if (!checkIfMin) {
      if (nums1.nonEmpty && nums2.nonEmpty) {
        if (Math.min(nums1.head, nums2.head) > midVal) {
          (-1, 0)
        } else if (Math.max(nums1.last, nums2.last) < midVal) {
          (1, 0)
        } else if (nums1.last < midVal && midVal < nums2.head) {
          getPosInArr(nums, (pos1, 0), nums2.head)
        } else if (nums2.last < midVal && midVal < nums1.head) {
          getPosInArr(nums, (0, pos2), nums1.head)
        } else {
          throw new Exception(s"can not check for pos: $pos, midVal: $midVal")
        }
      } else if (nums1.nonEmpty) {
        if (nums1.head > midVal) (-1, 0)
        else if (nums1.last < midVal) (1, 0)
        else throw new Exception(s"can not check for pos: $pos, midVal: $midVal")
      } else {
        if (nums2.head > midVal) (-1, 0)
        else if (nums2.last < midVal) (1, 0)
        else throw new Exception(s"can not check for pos: $pos, midVal: $midVal")
      }
    } else {
      (inArrPos, minVal)
    }
  }

  // 获得 >= vv 的最小坐标
  def arrBinarySearch(arr: Array[Int], left: Int, right: Int, vv: Int): Int = {
    var l = left
    var r = right
    while (l < r) {
      val mid = (l + r) >> 1
      if (arr(mid) < vv) l = mid + 1
      else r = mid
    }
    r
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
    ).foreach {
      case (nums1, nums2, ans) =>
        println("nums: ", nums1.toSeq, nums2.toSeq)
        val ret = findMedianSortedArrays(nums1, nums2)
        println(ret)
        assert(ret == ans)
    }
  }
}
