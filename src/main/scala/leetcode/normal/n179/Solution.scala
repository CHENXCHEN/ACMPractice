package leetcode.normal.n179

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/largest-number/
  * 179. 最大数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def cmp(left: String, right: String): Boolean = {
    s"$left$right" > s"$right$left"
  }

  def largestNumber(nums: Array[Int]): String = {
    val ans = nums.map(_.toString).sortWith(cmp).mkString.replaceFirst("^0*", "")
    if (ans.isEmpty && nums.nonEmpty) return "0"
    ans
  }

  def main(args: Array[String]): Unit = {
    println(largestNumber(Array(3, 30, 34, 5, 9)))
    println(largestNumber(Array(0, 0, 10)))
    println(largestNumber(Array(0, 0)))
    println(largestNumber(Array()))
  }
}
