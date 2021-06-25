package leetcode.normal.n752

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/open-the-lock/
  * 752. 打开转盘锁
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def openLock(deadends: Array[String], target: String): Int = {
    val tMap = mutable.TreeMap.empty[String, Int]
    val deadEndSet = deadends.toSet
    if (deadEndSet.contains("0000")) return -1
    tMap.put("0000", 0)
    val q = mutable.Queue.empty[String]
    q.enqueue("0000")

    def walk(nextString: String, step: Int): Option[String] = {
      if (deadEndSet.contains(nextString)) None
      else {
        val nextStepOpt = tMap.get(nextString)
        if (nextStepOpt.isEmpty || nextStepOpt.get > step + 1) {
          tMap.put(nextString, step + 1)
          Option(nextString)
        } else None
      }
    }

    while (q.nonEmpty) {
      val cur = q.dequeue()
      val step = tMap(cur)
      if (cur == target) return step;
      for (i <- 0 to 3) {
        walk(addOnePosition(cur, i, 1), step).foreach(x => q.enqueue(x))
        walk(addOnePosition(cur, i, -1), step).foreach(x => q.enqueue(x))
      }
    }
    tMap.getOrElse(target, -1)
  }

  def addOnePosition(s: String, pos: Int, vv: Int): String = {
    val sb = new mutable.StringBuilder
    sb.append(s)
    val num = (sb.charAt(pos) - '0' + vv + 10) % 10
    sb.setCharAt(pos, ('0' + num).toChar)
    sb.toString()
  }
}