package leetcode.normal.n846

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/hand-of-straights/
  * 846. 一手顺子
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def isNStraightHand(hand: Array[Int], groupSize: Int): Boolean = {
    if (hand.length % groupSize != 0) false
    else {
      val tMap = mutable.TreeMap.empty[Int, Int]
      hand.foreach { h => tMap.put(h, tMap.getOrElse(h, 0) + 1) }
      (0 until (hand.length / groupSize)).forall { _ =>
        var head = tMap.keySet.head
        tMap(head) -= 1
        if (tMap(head) == 0) tMap.remove(head)
        (0 until (groupSize - 1)).forall { _ =>
          head += 1
          if (tMap.contains(head)) {
            tMap(head) -= 1
            if (tMap(head) == 0) tMap.remove(head)
            true
          } else false
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(isNStraightHand(Array(1, 2, 3, 2, 3, 4), 3))
  }
}
