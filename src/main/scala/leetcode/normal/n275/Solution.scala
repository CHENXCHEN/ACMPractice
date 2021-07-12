package leetcode.normal.n275

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/h-index-ii/
  * 275. H 指数 II
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def hIndex(citations: Array[Int]): Int = {
    citations.zipWithIndex.find {
      case (vv, i) =>
        val h = citations.length - i
        vv >= h
    }
      .map(citations.length - _._2)
      .getOrElse(-1)
  }
}
