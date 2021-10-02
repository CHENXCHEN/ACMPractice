package leetcode.normal.n405

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
  * 405. 数字转换为十六进制数
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  val hexString = "0123456789abcdef"

  def toHex(num: Int): String = {
    if (num == 0) return "0"
    if (num == Int.MinValue) return "80000000"
    val sb = new StringBuilder()
    var tran = math.abs(num)
    while (tran != 0 && sb.length < 9) {
      val mod = tran % 16
      sb.append(hexString.charAt(mod))
      tran /= 16
    }
    val isPlus =
      if (num >= 0) true
      else false
    if (isPlus) sb.reverse.mkString
    else {
      // 反码
      val revStr = sb.padTo(8, '0').map {
        ch =>
          val num = (~hexString.indexOf(ch)) & 0xf
          hexString(num)
      }
      // 获取补码，+1
      var isPush = true
      revStr.map { ch =>
        if (isPush) {
          if (ch == 'f') '0'
          else {
            isPush = false
            hexString(hexString.indexOf(ch) + 1)
          }
        } else ch
      }.reverse.mkString
    }
  }
}
