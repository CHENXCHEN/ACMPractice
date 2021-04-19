package leetcode.normal.n27

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/remove-element/
  * 27. 移除元素
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def removeElement(nums: Array[Int], vv: Int): Int = {
    var tot = 0
    nums.indices.foreach {
      case i if (nums(i) != vv) =>
        nums(tot) = nums(i)
        tot += 1
      case _ =>
    }
    tot
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(0,1,2,2,3,0,4,2)
    val len = removeElement(arr, 2)
    println(arr.slice(0, len).toSeq)
  }
}
