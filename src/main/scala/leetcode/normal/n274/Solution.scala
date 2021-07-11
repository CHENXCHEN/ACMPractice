package leetcode.normal.n274

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/h-index/
  * 274. H 指数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def hIndex(citations: Array[Int]): Int = {
    val sorted = citations.sorted.reverse
    var ans = 0
    sorted.zipWithIndex.foreach {
      case (vv, i) =>
        if (vv >= i + 1) {
          ans = i + 1
        }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(hIndex(Array(1, 3, 1)))
    println(hIndex(Array(0, 0, 0)))
  }
}
