package leetcode.normal.n706

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/design-hashmap/
  * 706. 设计哈希映射
  */
class MyHashMap1() {

  /** Initialize your data structure here. */
  val mm = mutable.Map[Int, Int]()

  /** value will always be non-negative. */
  def put(key: Int, value: Int): Unit = {
    mm.put(key, value)
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = {
    mm.getOrElse(key, -1)
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int): Unit = {
    mm.remove(key)
  }
}

/**
  * Your MyHashMap object will be instantiated and called as such:
  * var obj = new MyHashMap()
  * obj.put(key,value)
  * var param_2 = obj.get(key)
  * obj.remove(key)
  */
