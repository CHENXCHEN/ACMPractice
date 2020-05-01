package leetcode.normal.n1
/**
  * 求两数之和
  * 输出数组中两个元素相加等于 target 的下标，下标不能相等
  */
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val numsIndex = nums.zipWithIndex
    import scala.collection.mutable
    val map = mutable.Map.empty[Int, Int]
    numsIndex.toStream.flatMap {
      case (vv, index) if map.contains(target - vv) && map(target - vv) != index =>
        val maybeInts = Option(Array(index, map(target - vv)))
        map.put(vv, index)
        maybeInts
      case (vv, index) =>
        map.put(vv, index)
        None
    }.head
    //    import scala.collection.mutable
    //    var map = Map.empty[Int, Int]
    //    for (i <- nums.indices) {
    //      val other = target - nums(i)
    //      if (map.contains(other) && map(other) != i) {
    //        return Array(i, map(other))
    //      }
    ////      map.put(nums(i), i)
    //      map += (nums(i) -> i)
    //    }
    //    Array.emptyIntArray
    // 优化的两种方法，一种用 collectFirst 一种用 toStream
    // 使用 toStream 更直观
    //    val map = numsIndex.map {
    //      case (num, index) => num -> index
    //    }
    //      .groupBy(_._1)
    //      .mapValues(_.map(_._2))
    //    numsIndex.toStream.flatMap {
    //      case (vv, index) if map.contains(target - vv) =>
    //        if (target - vv == vv && map(vv).length >= 2) Option(Array(index, map(vv)(1)))
    //        else if (target - vv != vv) Option(Array(index, map(target - vv).head))
    //        else None
    //      case _ => None
    //    }.head
    //    val option = numsIndex.collectFirst {
    //      case (vv, index)
    //        if map.contains(target - vv) && (target - vv == vv && map(vv).length >= 2) =>
    //        Array(index, map(vv)(1))
    //      case (vv, index)
    //        if map.contains(target - vv) && target - vv != vv =>
    //        Array(index, map(target - vv).head)
    //    }
    //    option.get
  }

  def main(args: Array[String]): Unit = {
    testData()
  }

  def testData(): Unit = {
    Array(
      (Array(2, 7, 11, 15), 9)
      , (Array(3, 8, 12, 4, 7), 19)
      , (Array(2, 5, 5, 11), 10)
      , (Array(3, 3), 6)
    ).foreach {
      case (nums, target) =>
        println(nums.toSeq, target)
        println(twoSum(nums, target).toSeq)
    }
  }
}