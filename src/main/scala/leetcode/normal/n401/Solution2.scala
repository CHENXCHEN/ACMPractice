package leetcode.normal.n401

import scala.collection.mutable.ListBuffer

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-watch/
  * 401. 二进制手表
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def readBinaryWatch(turnedOn: Int): List[String] = {
    val ans = ListBuffer.empty[String]
    for(hour <- 0 to 11) {
      for(minute <- 0 to 59) {
        if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
          ans.append(f"$hour%d:$minute%02d")
        }
      }
    }
    ans.toList
  }
}
