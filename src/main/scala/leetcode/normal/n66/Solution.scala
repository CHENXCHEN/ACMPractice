package leetcode.normal.n66

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/plus-one/
  * 66. 加一
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    digits(digits.length - 1) += 1
    var i = digits.length - 1
    while (i > 0 && digits(i) >= 10) {
      digits(i) -= 10
      digits(i - 1) += 1
      i -= 1
    }
    if (digits(0) >= 10) {
      digits(0) -= 10
      1 +: digits
    } else digits
  }
}