package leetcode.normal.n401

import scala.collection.mutable.ListBuffer

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/binary-watch/
  * 401. 二进制手表
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def readBinaryWatch(turnedOn: Int): List[String] = {
    val ans = ListBuffer.empty[String]

    def getHour(mark: Int): Int = mark >> 6

    def getMinute(mark: Int): Int = mark & 0x3F

    def getStrFromBinaryWatch(mark: Int): Option[String] = {
      val hour = getHour(mark)
      val minute = getMinute(mark)
      if (hour <= 11 && minute <= 59) {
        Some(f"$hour%d:$minute%02d")
      } else None
    }

    def findTurnedOn(mark: Int, step: Int, leftOn: Int): Unit = {
      if (getHour(mark) > 11 || getMinute(mark) > 59) {
        return
      }
      if (leftOn == 0) {
        getStrFromBinaryWatch(mark).foreach(str => ans.append(str))
        return
      }
      ((step + 1) until 10).foreach { i =>
        val bitPos = 1 << i
        if ((mark & bitPos) == 0) {
          findTurnedOn(mark | bitPos, i, leftOn - 1)
        }
      }
    }

    findTurnedOn(0, -1, turnedOn)

    ans.toList
  }
}
