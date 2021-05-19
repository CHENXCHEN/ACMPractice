package leetcode.normal.n1442

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
  * 1442. 形成两个异或相等数组的三元组数目
  * preXor(i) ^ preXor(j+1) = preXor(j+1) ^ preXor(k+1)
  * preXor(i) = preXor(k+1), ans += k - i
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def countTriplets(arr: Array[Int]): Int = {
    var preXor = 0
    val cntMap = mutable.Map[Int, Int]()
    val pSumMap = mutable.Map[Int, Int]()
    var ans = 0
    arr.indices.foreach {
      i =>
        val cur = preXor ^ arr(i)
        if (cntMap.contains(cur)) {
          ans += cntMap(cur) * i - pSumMap(cur)
        }
        cntMap.put(preXor, cntMap.getOrElse(preXor, 0) + 1)
        pSumMap.put(preXor, pSumMap.getOrElse(preXor, 0) + i)
        preXor = cur
    }
    ans
  }
}
