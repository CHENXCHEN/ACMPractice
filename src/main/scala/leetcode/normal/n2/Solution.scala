package leetcode.normal.n2

/**
  * Definition for singly-linked list.
  * class ListNode(var x: Int = 0) {
  * var next: ListNode = null
  * var x: Int = x
  * }
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwo(l1, l2, 0)
  }

  def addTwo(l1: ListNode, l2: ListNode, isAdd: Int = 0): ListNode = {
    val sum = 0 + (if (l1 != null) l1.x else 0) + (if (l2 != null) l2.x else 0) + isAdd
    val l1Child = if (l1 == null) null else l1.next
    val l2Child = if (l2 == null) null else l2.next
    if (l1 == null && l2 == null && sum == 0) null
    else {
      val node = new ListNode(sum % 10)
      node.next = addTwo(l1Child, l2Child, sum / 10)
      node
    }
  }

  def main(args: Array[String]): Unit = {
    testData()
  }

  def testData(): Unit = {
    Array(
      (Array(2, 4, 3), Array(5, 6, 4))
      , (Array(2, 4, 5), Array(5, 6, 4))
      , (Array(0), Array(5, 6, 4))
      , (Array(1), Array(9, 9, 9))
    ).map {
      case (arr1, arr2) =>
        (arrayToListNode(arr1), arrayToListNode(arr2))
    }.foreach {
      case (l1, l2) =>
        println("input:")
        printListNode(l1)
        printListNode(l2)
        println("output:")
        printListNode(addTwoNumbers(l1, l2))
    }

  }

  def arrayToListNode(arr: Array[Int]): ListNode = {
    val node1 = new ListNode(-1)
    arr.foldLeft(node1) {
      case (node, vv) =>
        if (node.x == -1) {
          node.x = vv
          node
        } else {
          node.next = new ListNode(vv)
          node.next
        }
    }
    if (node1.x == -1) node1.x = 0
    node1
  }

  def printListNode(listNode: ListNode): Unit = {
    var isFirst = true
    var now = listNode
    while (now != null) {
      if (isFirst) {
        print(now.x)
        isFirst = false
      } else {
        print(" -> " + now.x)
      }
      now = now.next
    }
    if (isFirst) {
      print(0)
    }
    println()
  }
}