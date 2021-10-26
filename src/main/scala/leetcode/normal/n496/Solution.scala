package leetcode.normal.n496

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/next-greater-element-i/
  * 496. 下一个更大元素 I
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val stack = new mutable.Stack[Int]()
    val mAns = mutable.Map[Int, Int]()
    nums2.reverse.foreach { n =>
      while (stack.headOption.exists(_ < n)) {
        stack.pop()
      }
      mAns.put(n, stack.headOption.getOrElse(-1))
      stack.push(n)
    }
    nums1.map { n =>
      mAns.getOrElse(n, -1)
    }
  }
}