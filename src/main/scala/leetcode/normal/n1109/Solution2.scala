package leetcode.normal.n1109

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/corporate-flight-bookings/
  * 1109. 航班预订统计
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val accArr = Array.fill(n + 2)(0)
    bookings.foreach { bk =>
      accArr(bk(0)) += bk(2)
      accArr(bk(1) + 1) -= bk(2)
    }
    var s = 0
    (1 to n).map { i =>
      s += accArr(i)
      s
    }.toArray
  }
}