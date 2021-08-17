package leetcode.normal.n551

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/student-attendance-record-i/
  * 551. 学生出勤记录 I
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def checkRecord(s: String): Boolean = {
    var isLate3Day = false
    (1 until s.length - 1).foreach { i =>
      if (s(i - 1) == 'L' && s(i) == 'L' && s(i + 1) == 'L') isLate3Day = true
    }
    var cntA = 0
    var cntL = 0
    s.foreach {
      case 'A' => cntA += 1
      case 'L' => cntL += 1
      case _ =>
    }
//    cntA < 2 && (!isLate3Day || (!isLate3Day && cntL <= 3))
    cntA < 2 && !isLate3Day
  }
}
