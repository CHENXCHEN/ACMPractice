package leetcode.normal.n299

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/bulls-and-cows/
  * 299. 猜数字游戏
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getHint(secret: String, guess: String): String = {
    var ansA = 0
    var ansB = 0
    val arrA = Array.fill(10)(0)
    val arrB = Array.fill(10)(0)
    secret.indices.foreach { i =>
      if (secret(i) == guess(i)) ansA += 1
      else {
        arrA(secret(i) - '0') += 1
        arrB(guess(i) - '0') += 1
      }
    }
    (0 until 10).foreach { i =>
      ansB += arrA(i).min(arrB(i))
    }
    s"${ansA}A${ansB}B"
  }
}
