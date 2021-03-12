package leetcode.normal.n705

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/design-hashset/
  * 705. 设计哈希集合
  */
class MyHashSet() {

  /** Initialize your data structure here. */

  val ss = mutable.Set.empty[Int]

  def add(key: Int): Unit = {
    ss.add(key)
  }

  def remove(key: Int): Unit = {
    ss.remove(key)
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    ss.contains(key)
  }
}

/**
  * Your MyHashSet object will be instantiated and called as such:
  * var obj = new MyHashSet()
  * obj.add(key)
  * obj.remove(key)
  * var param_3 = obj.contains(key)
  */