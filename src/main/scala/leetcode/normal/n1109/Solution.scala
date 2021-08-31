package leetcode.normal.n1109

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/corporate-flight-bookings/
  * 1109. 航班预订统计
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {

  case class TreeNode(l: Int, r: Int, var acc: Int)

  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val tree: Array[TreeNode] = Array.fill(n << 2)(null)

    def build(n: Int, left: Int, right: Int): Unit = {
      tree(n) = TreeNode(left, right, 0)
      if (left >= right) return
      val mid = (left + right) >> 1
      build(n << 1, left, mid)
      build(n << 1 | 1, mid + 1, right)
    }

    def pushDown(n: Int): Unit = {
      if (tree(n).acc > 0 && tree(n).l != tree(n).r) {
        val leftNode = tree(n << 1)
        val rightNode = tree(n << 1 | 1)
        if (leftNode != null) leftNode.acc += tree(n).acc
        if (rightNode != null) rightNode.acc += tree(n).acc
        tree(n).acc = 0
      }
    }

    def insert(n: Int, left: Int, right: Int, vv: Int): Unit = {
      pushDown(n)
      if (left <= tree(n).l && tree(n).r <= right) {
        tree(n).acc += vv
      } else {
        val mid = (tree(n).l + tree(n).r) >> 1
        if (left <= mid) {
          insert(n << 1, left, right, vv)
        }
        if (right > mid) {
          insert(n << 1 | 1, left, right, vv)
        }
      }
    }

    @scala.annotation.tailrec
    def query(n: Int, pos: Int): Int = {
      pushDown(n)
      if (tree(n).l == tree(n).r) {
        tree(n).acc
      } else {
        val mid = (tree(n).l + tree(n).r) >> 1
        if (pos <= mid) query(n << 1, pos)
        else query(n << 1 | 1, pos)
      }
    }

    build(1, 1, n)
    bookings.foreach(arr => insert(1, arr(0), arr(1), arr(2)))
    (1 to n).map(x => query(1, x)).toArray
  }
}