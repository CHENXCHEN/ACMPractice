package leetcode.normal.n692

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/top-k-frequent-words/
  * 692. 前K个高频单词
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {

  case class Node(cnt: Int, pos: Int)

  def topKFrequent(words: Array[String], k: Int): List[String] = {
    val map = mutable.Map[String, Node]()
    words.indices.foreach {
      i =>
        val pre = map.getOrElse(words(i), Node(0, i))
        map.put(words(i), pre.copy(pre.cnt + 1))
    }
    val seq = map.values.toSeq
    seq.sortWith {
      case (ll, rr) =>
        if (ll.cnt != rr.cnt) ll.cnt > rr.cnt
        else words(ll.pos) < words(rr.pos)
    }.take(k).map {
      case Node(_, i) => words(i)
    }.toList
  }
}
