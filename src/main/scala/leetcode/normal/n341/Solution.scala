package leetcode.normal.n341

object Solution {

}

trait NestedInteger {

  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int

  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int)

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList: List[NestedInteger]

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger)
}

/**
  * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
  * 341. 扁平化嵌套列表迭代器
  */
class NestedIterator(_nestedList: List[NestedInteger]) {
  var leftList: List[NestedInteger] = _nestedList

  def next(): Int = {
    var ans = Option.empty[Int]
    while (ans.isEmpty) {
      val head = leftList.head
      leftList = leftList.drop(1)
      if (head.isInteger) {
        ans = Some(head.getInteger)
      } else {
        leftList = head.getList ++: leftList
      }
    }
    ans.get
  }

  def hasNext(): Boolean = {
    while (leftList.nonEmpty && !leftList.head.isInteger) {
      val head = leftList.head
      leftList = leftList.drop(1)
      leftList = head.getList ++: leftList
    }
    leftList.nonEmpty
  }
}
