package leetcode.normal.n8

/**
  * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
  *
  * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
  *
  * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
  * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
  * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
  * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
  *
  * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
  *
  * 提示：
  * 本题中的空白字符只包括空格字符 ' ' 。
  * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
  *
  * 来源：力扣（LeetCode）
  * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  *
  */
object Solution {
  def myAtoi(str: String): Int = {
    var ans = 0
    var checkSign = 1
    var i = 0
    while (i < str.length && str(i) == ' ') i += 1
    if (i < str.length) {
      if (str(i) == '-') {
        checkSign = -1
        i += 1
      } else if (str(i) == '+') i += 1
    }
    var check = true
    while (i < str.length && check) {
      if (str(i).isDigit) {
        val t = checkSign * str(i).asDigit
        if (checkSign > 0 && ans > (Int.MaxValue - t) / 10) {
          check = false
          ans = Int.MaxValue
        } else if (checkSign < 0 && ans < (Int.MinValue - t) / 10) {
          check = false
          ans = Int.MinValue
        } else ans = ans * 10 + t
      } else check = false
      i += 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    Array(
      ("123", 123)
      , ("-123", -123)
      , (" jsdf", 0)
      , ("  -42", -42)
      , ("  42 with", 42)
      , (" - 42 with", 0)
      , ("-91283472332", -2147483648)
      , ("91283472332", 2147483647)
    ).foreach {
      case (x, ans) =>
        val rx = myAtoi(x)
        println("check ", x, rx)
        assert(ans == rx)
    }
  }
}
