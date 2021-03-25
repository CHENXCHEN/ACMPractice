package leetcode.normal.n82

case class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
  * 82. 删除排序链表中的重复元素 II
  */
object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    var root = head
    var parentParent = head
    var parent = head
    while (parent != null && parent.next != null) {
      var isDuplicate = false
      while (parent.next != null && parent.next.x == parent.x) {
        parent.next = parent.next.next
        isDuplicate = true
      }
      if (isDuplicate) {
        if (parent == root) {
          root = parent.next
          parent = parent.next
        } else {
          parentParent.next = parent.next
          parent = parent.next
        }
      } else {
        parentParent = parent
        parent = parent.next
      }
    }
    root
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
    val head = ListNode(arr.head)
    var cur = head
    (1 until arr.length).foreach {
      i =>
        cur.next = ListNode(arr(i))
        cur = cur.next
    }
    var node = deleteDuplicates(head)
    while (node != null) {
      println(node.x)
      node = node.next
    }
  }
}
