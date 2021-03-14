package leetcode.normal.n706

/**
  * https://leetcode-cn.com/problems/design-hashmap/
  * 706. 设计哈希映射
  */
class MyHashMap() {

  /** Initialize your data structure here. */

  val vv: Array[Array[(Int, Int)]] = Array.fill(811)(Array.empty)

  def hash(v: Int): Int = v % 791

  def findKey(key: Int): Int = vv(hash(key)).indexWhere { case (x, _) => x == key }

  /** value will always be non-negative. */
  def put(key: Int, value: Int): Unit = {
    val hashKey = hash(key)
    val index: Int = findKey(key)
    if (index >= 0) vv(hashKey)(index) = (key, value)
    else {
      vv(hashKey) :+= (key, value)
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = {
    val hashKey = hash(key)
    val index: Int = findKey(key)
    if (index >= 0) vv(hashKey)(index)._2
    else -1
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int): Unit = {
    val hashKey = hash(key)
    vv(hashKey) = vv(hashKey).filter {
      case (x, _) => x != key
    }
  }
}

/**
  * Your MyHashMap object will be instantiated and called as such:
  * var obj = new MyHashMap()
  * obj.put(key,value)
  * var param_2 = obj.get(key)
  * obj.remove(key)
  */
