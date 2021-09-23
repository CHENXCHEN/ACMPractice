package leetcode.normal.n725

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/split-linked-list-in-parts/
  * 725. 分隔链表
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def splitListToParts(head: ListNode, k: Int): Array[ListNode] = {
    var root = head
    var len = 0
    while (root != null) {
      len += 1
      root = root.next
    }
    val perPart = len / k
    var mod = len % k
    root = head
    (0 until k).map { _ =>
      var subLen =
        if (mod == 0) perPart
        else {
          mod -= 1
          perPart + 1
        }
      val tmp = root
      while (subLen > 0 && root != null) {
        val _tmp = root.next
        if (subLen == 1) root.next = null
        root = _tmp
        subLen -= 1
      }
      tmp
    }.toArray
  }
}
