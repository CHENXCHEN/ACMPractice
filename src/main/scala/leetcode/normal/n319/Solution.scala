package leetcode.normal.n319

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/bulb-switcher/
  * 319. 灯泡开关
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def bulbSwitch(n: Int): Int = {
    math.sqrt(n + 0.5).toInt
  }
}
