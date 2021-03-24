package leetcode.normal.n456

import java.util

/**
  * https://leetcode-cn.com/problems/132-pattern/
  * 456. 132 模式
  */
object Solution {
  def find132pattern(nums: Array[Int]): Boolean = {
    if (nums.length < 3) return false
    val ss: util.TreeMap[Int, Integer] = new util.TreeMap[Int, Integer]()
    (2 until nums.length).foreach {
      i => ss.put(nums(i), ss.getOrDefault(nums(i), Integer.valueOf(0)) + Integer.valueOf(1))
    }
    var minNum = nums.head
    (1 until nums.length - 1).foreach {
      i =>
        if (minNum < nums(i) && ss.lastKey() >= minNum + 1) {
          val rightNum: java.lang.Integer = ss.ceilingKey(minNum + 1)
          if (nums(i) > rightNum) {
            return true
          }
        }
        minNum = math.min(minNum, nums(i))
        ss.put(nums(i + 1), ss.get(nums(i + 1)) - 1)
        if (ss.get(nums(i + 1)) <= 0) {
          ss.remove(nums(i + 1))
        }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(find132pattern(Array(-2, 1, -2)))
    //    println(find132pattern(Array(1, 3, 2)))
  }
}
