package leetcode.normal.n412

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/fizz-buzz/
  * 412. Fizz Buzz
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def fizzBuzz(n: Int): List[String] = {
    (1 to n).map {i =>
      val mod3 = i % 3
      val mod5 = i % 5
      if (mod3 == 0 && mod5 == 0) "FizzBuzz"
      else if (mod3 == 0) "Fizz"
      else if (mod5 == 0) "Buzz"
      else i.toString
    }.toList
  }
}
