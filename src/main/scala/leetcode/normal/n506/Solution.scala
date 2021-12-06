package leetcode.normal.n506

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/relative-ranks/
  * 506. 相对名次
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def findRelativeRanks(score: Array[Int]): Array[String] = {
    var idx = score.indices.toArray
    idx = idx.sortBy(x => score(x)).reverse
    val mpIdx = Array.fill(score.length)(0)
    idx.zipWithIndex.foreach {
      case (v, idx) => mpIdx(v) = idx
    }
    score.indices.map { i =>
      mpIdx(i) match {
        case 0 => "Gold Medal"
        case 1 => "Silver Medal"
        case 2 => "Bronze Medal"
        case x => (x + 1).toString
      }
    }.toArray
  }
}
