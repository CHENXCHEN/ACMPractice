package leetcode.normal.n881

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/boats-to-save-people/
  * 881. 救生艇
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    val sorted = people.sorted
    var ll = 0
    var rr = sorted.length - 1
    var ans = 0
    while (ll <= rr) {
      ans += 1
      if (sorted(ll) + sorted(rr) <= limit) {
        ll += 1
        rr -= 1
      } else {
        rr -= 1
      }
    }
    ans
  }
}
