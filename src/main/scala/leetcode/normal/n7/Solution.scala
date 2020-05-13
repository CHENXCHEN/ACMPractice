package leetcode.normal.n7

/**
  * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
  * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
  * 判断是否溢出，那么只需要判断等式是否成立，将乘法转换为除法，比如 当 t > 0 时， rx * 10 + t > Int.MaxValue -> rx > (Int.MaxValue - t)/ 10
  */
object Solution {
  def reverse(x: Int): Int = {
    var rx = 0
    var check = false
    var oriX = x
    while (oriX != 0) {
      val t = oriX % 10
      if (t > 0 && rx > (Int.MaxValue - t) / 10) check = true
      else if (t < 0 && rx < (Int.MinValue - t) / 10) check = true
      rx = rx * 10 + t
      oriX /= 10
    }
    if (check) 0
    else rx
  }

  def main(args: Array[String]): Unit = {
    Array(
      (123, 321)
      , (-123, -321)
      , (2099999999, 0)
    ).foreach {
      case (x, ans) =>
        val rx = reverse(x)
        println(x, rx)
        assert(ans == rx)
    }
  }
}
