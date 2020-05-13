package leetcode.normal.n9

/**
  * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
  *
  */
object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) return false
    val ss = x.toString
    var i = 0
    var j = ss.length - 1
    var check = true
    while(i < ss.length && j >= 0 && check && i <= j) {
      check = ss(i) == ss(j)
      i += 1
      j -= 1
    }
    check
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
