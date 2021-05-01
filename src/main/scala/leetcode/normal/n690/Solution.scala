package leetcode.normal.n690

import scala.collection.mutable

class Employee() {
  var id: Int = 0
  var importance: Int = 0
  var subordinates: List[Int] = List()
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/employee-importance/
  * 690. 员工的重要性
  * BFS
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getImportance(employees: List[Employee], id: Int): Int = {
    val weights = employees.map {
      employee => employee.id -> employee.importance
    }.toMap
    val edges = employees.map {
      employee => employee.id -> employee.subordinates
    }.toMap
    val q = mutable.Queue(id)
    var ans = 0
    while (q.nonEmpty) {
      val now = q.dequeue()
      ans += weights(now)
      edges(now).foreach(next => q.enqueue(next))
    }
    ans
  }
}
