package leetcode.normal.n825

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
  * 825. 适龄的朋友
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numFriendRequests(ages: Array[Int]): Int = {
    val has = Array.fill(121)(0)
    ages.foreach { age => has(age) += 1 }
    val pSum = Array.fill(121)(0)
    (1 to 120).foreach { i => pSum(i) = pSum(i - 1) + has(i) }
    var ans = 0
    ages.foreach { age =>
      //     !(x + y + z)
      // =>  !(!(!x * !y) + z)
      // => 令 k = !(!x * !y)
      // => !(k + z)
      // => !(!(!k * !z))
      // => !k * !z
      // => !x * !y * !z
      //
      // xy => !(!x + !y)
      // !xy => !x + !y
      // y > 0.5 * age + 7 && y <= age && (y <= 100 || age >= 100)
      val left = (age >> 1) + 7 + 1
      val right = age
      val lag = if (has(age) >= 1) 1 else 0
      if (right >= left)
        ans += pSum(right) - pSum(left - 1) - lag
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(numFriendRequests(Array(16, 17, 18)))
  }
}