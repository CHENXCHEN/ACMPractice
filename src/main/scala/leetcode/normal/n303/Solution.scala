package leetcode.normal.n303

/**
  * https://leetcode-cn.com/problems/range-sum-query-immutable/
  * 303. 区域和检索 - 数组不可变
  * 简单的区间和
  *
  * @param _nums
  */
class NumArray(_nums: Array[Int]) {
  lazy val prefixSum: Array[Int] = {
    var sum = 0
    _nums.map(x => {
      sum += x
      sum
    })
  }

  def sumRange(i: Int, j: Int): Int = {
    if (i <= 0) prefixSum(j)
    else prefixSum(j) - prefixSum(i - 1)
  }
}

/*
["NumArray","sumRange","sumRange","sumRange"]
[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
  */