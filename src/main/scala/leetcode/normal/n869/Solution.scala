package leetcode.normal.n869

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/reordered-power-of-2/
  * 869. 重新排序得到 2 的幂
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  lazy val record: Set[Seq[Int]] = {
    val maxN = (1e9).toInt
    var res = 1
    val ss = mutable.Set[Seq[Int]]()
    while (res < maxN) {
      ss.add(getBitCount(res))
      res <<= 1
    }
    ss.toSet
  }

  def getBitCount(res: Int): Seq[Int] = {
    val bitCount = Array.fill(10)(0)
    res.toString.foreach(ch => bitCount(ch.toInt - '0'.toInt) += 1)
    bitCount
  }

  def reorderedPowerOf2(n: Int): Boolean = {
    record.contains(getBitCount(n))
  }
}
