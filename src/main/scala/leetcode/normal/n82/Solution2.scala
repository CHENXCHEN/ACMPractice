package leetcode.normal.n82

/**
  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
  * 82. 删除排序链表中的重复元素 II
  */
object Solution2 {
  def deleteDuplicates(head: ListNode): ListNode = {
    val root = ListNode(-101, head)
    var parent = root
    var pre: ListNode = root
    while (parent != null) {
      var isDuplicate = false
      while (parent.next != null && parent.next.x == parent.x) {
        parent.next = parent.next.next
        isDuplicate = true
      }
      if (isDuplicate) pre.next = parent.next
      else pre = parent
      parent = parent.next
    }
    root.next
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 2, 3, 3, 4, 4, 5)
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
