package leetcode.normal.n232

import scala.collection.mutable

class MyQueue() {

  /** Initialize your data structure here. */

  val stack = mutable.Stack[Int]()
  val stackOut = mutable.Stack[Int]()

  /** Push element x to the back of queue. */
  def push(x: Int): Unit = {
    stack.push(x)
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    if (stackOut.nonEmpty) stackOut.pop()
    else {
      while (stack.nonEmpty) stackOut.push(stack.pop())
      stackOut.pop()
    }
  }

  /** Get the front element. */
  def peek(): Int = {
    val ret = pop()
    stackOut.push(ret)
    ret
  }

  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    stack.isEmpty && stackOut.isEmpty
  }

}

/**
  * Your MyQueue object will be instantiated and called as such:
  * var obj = new MyQueue()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.peek()
  * var param_4 = obj.empty()
  */