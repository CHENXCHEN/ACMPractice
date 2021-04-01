package leetcode.normal.n1006

/**
  * https://leetcode-cn.com/problems/clumsy-factorial/
  * 1006. 笨阶乘
  */
object Solution {
  def clumsy(N: Int): Int = {
    var ans: Int = 0
    val opSeq = Seq('*', '/', '+', '-')
    var opPos = -1
    var lastAns: Int = 0
    N.to(1, -1).foreach {
      n =>
        if (opPos == -1) {
          ans = n
          opPos += 1
        } else {
          opSeq(opPos) match {
            case '*' => ans *= n
            case '/' => ans /= n
            case '+' => ans += n
            case '-' =>
              lastAns += ans
              ans = -n
          }
          opPos = (opPos + 1) % opSeq.length
        }
    }
    lastAns + ans
  }
}
