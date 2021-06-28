package leetcode.normal.n815

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/bus-routes/
  * 815. 公交路线
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numBusesToDestination(routes: Array[Array[Int]], source: Int, target: Int): Int = {
    if (source == target) return 0
    val edges = Array.fill(routes.length + 1)(mutable.TreeSet.empty[Int])
    val busToNumber = mutable.TreeMap.empty[Int, mutable.TreeSet[Int]]
    routes.zipWithIndex.foreach {
      case (route, i) =>
        route.foreach { bus =>
          val tSet = busToNumber.getOrElse(bus, mutable.TreeSet.empty[Int])
          tSet.foreach { k =>
            if (i != k) {
              edges(i).add(k)
              edges(k).add(i)
            }
          }
          tSet.add(i)
          busToNumber.put(bus, tSet)
        }
    }
    val visit = Array.fill(routes.length + 1)(-1)
    val q = mutable.Queue.empty[Int]
    busToNumber.get(source).foreach { tSet =>
      tSet.foreach { x =>
        q.enqueue(x)
        visit(x) = 1
      }
    }
    while (q.nonEmpty) {
      val now = q.dequeue()
      val step = visit(now)
      edges(now).foreach { next =>
        if (visit(next) == -1 || visit(next) > step + 1) {
          visit(next) = step + 1
          q.enqueue(next)
        }
      }
    }
    busToNumber.get(target).flatMap { tSet =>
      val ansArr = tSet.map(num => visit(num)).filter(_ > 0)
      if (ansArr.nonEmpty) Some(ansArr.min)
      else None
    }.getOrElse(-1)
  }

  def main(args: Array[String]): Unit = {
    println(numBusesToDestination(
      Array(Array(1, 2, 7), Array(3, 6, 7)),
      1, 6
    ))
  }
}
