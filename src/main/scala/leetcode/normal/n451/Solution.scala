package leetcode.normal.n451

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/sort-characters-by-frequency/
  * 451. 根据字符出现频率排序
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def frequencySort(s: String): String = {
    val map = mutable.TreeMap.empty[Char, Int]
    s.foreach { ch =>
      map.put(ch, map.getOrElse(ch, 0) + 1)
    }
    val ans = new mutable.StringBuilder
    map.toArray.sortBy(_._2).reverse.foreach {
      case (ch, cnt) =>
        (0 until cnt).foreach { _ =>
          ans.append(ch)
        }
    }
    ans.toString()
  }
}
