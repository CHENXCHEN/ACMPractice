package leetcode.normal.n981


object Solution {

}

import scala.collection.mutable
/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/time-based-key-value-store/
  * 981. 基于时间的键值存储
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
class TimeMap() {

  /** Initialize your data structure here. */

  val mm: mutable.TreeMap[String, mutable.TreeMap[Int, String]] = mutable.TreeMap.empty[String, mutable.TreeMap[Int, String]]

  def set(key: String, value: String, timestamp: Int): Unit = {
    val version = mm.getOrElse(key, mutable.TreeMap.empty[Int, String])
    version.put(timestamp, value)
    mm.put(key, version)
  }

  def get(key: String, timestamp: Int): String = {
    if (!mm.contains(key)) {
      ""
    } else {
      mm(key).rangeImpl(None, Some(timestamp + 1))
        .lastOption.map(_._2).getOrElse("")
    }
  }
}