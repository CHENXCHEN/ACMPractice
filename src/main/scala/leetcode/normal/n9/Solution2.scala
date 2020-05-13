package leetcode.normal.n9

/**
  * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
  *
  */
object Solution2 {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false
    var oriX = x
    var otherPart = 0
    while (oriX > otherPart) {
      otherPart = otherPart * 10 + oriX % 10
      oriX /= 10
    }
    println(oriX, otherPart)
    oriX == otherPart || oriX == otherPart / 10
  }

  def main(args: Array[String]): Unit = {
    Array(
      (121, true)
      , (-121, false)
      , (10, false)
    ).foreach {
      case (x, ans) =>
        val rx = isPalindrome(x)
        println("check ", x, rx)
        assert(ans == rx)
    }
  }
}
