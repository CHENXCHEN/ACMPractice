package leetcode.normal.n554

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/brick-wall/
  * 554. 砖墙
  * 哈希, Hash
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def leastBricks(wall: List[List[Int]]): Int = {
    val map = mutable.Map[Long, Int]()
    wall.foreach {
      list =>
        var ss = 0L
        list.foreach {
          num =>
            ss += num.toLong
            map.put(ss, map.getOrElse(ss, 0) + 1)
        }
    }
    val cols = wall.head.map(_.toLong).sum
    val rows = wall.length
    var ans = rows
    map.foreach {
      case (col, cnt) =>
        if (col != cols) ans = ans min (rows - cnt)
    }
    ans
  }
}
