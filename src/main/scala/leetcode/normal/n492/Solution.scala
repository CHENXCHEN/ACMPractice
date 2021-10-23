package leetcode.normal.n492

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/construct-the-rectangle/
  * 492. 构造矩形
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def constructRectangle(area: Int): Array[Int] = {
    var maxAns = math.sqrt(area).toInt
    val ans = Array(0, 0)
    while (ans.head == 0) {
      if (area % maxAns == 0) {
        ans(1) = maxAns
        ans(0) = area / maxAns
      }
      maxAns -= 1
    }
    ans
  }
}